import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ConversionHistory records = new ConversionHistory();
        GetExchange currency = new GetExchange();
        CodeMenu menu = new CodeMenu();
        String baseCurrency;
        String dstCurrency;
        double amount;

        do {
            baseCurrency = menu.getUserCode("");
            if(!menu.options.containsKey(baseCurrency))
                continue;
            do {
                dstCurrency = menu.getUserCode(baseCurrency);
            }while(!(menu.options.containsKey(dstCurrency) && !dstCurrency.equals(baseCurrency)) && !dstCurrency.equals("EXT"));
            if(dstCurrency.equals("EXT"))
                continue;
            do{
                amount = menu.getAmount(baseCurrency, dstCurrency);
            }while(amount <= 0.0);
            Exchange conversion = currency.getConversion(baseCurrency, dstCurrency, amount);
            System.out.println("\n$" + amount + " " + menu.options.get(baseCurrency) +
                    " = $" + conversion.conversion_result() + " " + menu.options.get(dstCurrency));
            try{
                records.CreateReadFile(conversion);
            }catch(IOException e){
                System.out.println("Error saving conversion.");
            }
        }while(!baseCurrency.equals("EXT"));
    }
}