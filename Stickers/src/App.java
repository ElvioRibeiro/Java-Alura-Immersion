import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // get http request - get top 250 movies
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI adress = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(adress).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // parse - Title, image, rating
        JsonParser parser = new JsonParser();
        List<Map<String, String>> movieList = parser.parse(body);
        
        //show data
        for (Map<String,String> movie : movieList) {
            System.out.println("\u001b[34;1m Name:  "+" \u001b[33;1m\u001b[1m\u001b[4m" + movie.get("title") + "\u001b[m ");
            System.out.println("\u001b[34;1m Poster:"+" \u001b[m\u001b[4m\u001b[34m" + movie.get("image") + "\u001b[m ");
            System.out.print("\u001b[34;1m Rating:"+" \u001b[m" + movie.get("imDbRating") + " - ");
            double rating = Double.parseDouble(movie.get("imDbRating"));
            int stars = (int) Math.floor(rating);
            for (int i = 1; i <= stars; i++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }
    }
}
