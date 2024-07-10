import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeMenu {
    private Scanner reading = new Scanner(System.in);
    public Map<String, String> options = Map.of(
            "MXN", "Mexican Pesos",
            "ARS", "Argentine Pesos",
            "USD", "United States Dollars",
            "BRL", "Brazilian Reals");

    public String getUserCode(String baseCode){
        System.out.println("\nWrite " + (baseCode.isEmpty() ? "your":"a DIFFERENT ") + "currency code (" + (baseCode.isEmpty() ? "FROM":"TO") + "): ");
        options.forEach((k,v) -> {if(!k.equals(baseCode))System.out.println(k + " - " + v);});
        System.out.println("EXT - Exit");
        return reading.nextLine();
    }

    public boolean checkCode(String code){
        if(options.containsKey(code) || code.equals("EXT"))
            return true;
        return false;
    }

    public double getAmount(String baseCode, String dstCode){
        double amount;
        System.out.println("\nAmount of " + options.get(baseCode) + " to convert to " + options.get(dstCode) +": ");
        try{
            amount = Double.valueOf(reading.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Incorrect amount, please try again.");
            amount = 0.0;
        }
        return amount;
    }
}
