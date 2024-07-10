import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class ConversionHistory {
    public void CreateReadFile(Exchange exchange) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("history.txt", true);
        writer.write(gson.toJson(exchange));
        writer.close();
    }
}
