import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://imdb-api.com/en/API/Top250Movies/k_12345678";
        HttpClient client = new HttpClient.newHttpClient();
        HttpRequest reqAPI = HttpRequest.newBuilder(URI.create(url)).GET().build();
        HttpResponse <String> response = client.send(reqAPI, BodyHandlers.String());
        String json = response.body();
        System.out.println(json);

    }
}
