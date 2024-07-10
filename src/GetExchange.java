import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetExchange {
    public Exchange getConversion(String fromCurrency, String toCurrency, double amount){
        String apiKey = "9fb08933353e134adcc09344";
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/";
        URI url = URI.create(apiUrl + fromCurrency + "/" + toCurrency + "/" + amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Exchange.class);
        } catch (Exception e) {
            throw new RuntimeException("Conversion error. ");
        }
    }
}
