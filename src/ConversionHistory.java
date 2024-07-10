import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;

public class ConversionHistory {
    public void SaveFile(Exchange exchange) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("history.txt", true);
        writer.write(gson.toJson(exchange));
        writer.close();
    }

    public void showHistory(){
        String history = "";
        try {
            File myObj = new File("history.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                history += myReader.nextLine();
            }
            myReader.close();
            System.out.println(history
                    .replace("{", "\n")
                    .replace("}", "")
                    .replace(",", "")
                    .replace("\"", "")
                    .replace("base_code: ", "")
                    .replace(" target_code:", "->")
                    .replace("conversion_result: ", "$"));
        }catch (FileNotFoundException e) {
            System.out.println("Nothing.");
        }
    }
}
