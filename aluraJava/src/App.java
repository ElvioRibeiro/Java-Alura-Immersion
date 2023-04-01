import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //ExtractContent extractor = new ExtractIMDBAPI();        
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD-JamesWebbSpaceTelescope.json";
        ExtractContent extractor = new ExtractNasaAPI();

        ClientHTTP http = new ClientHTTP();
        String json = http.getData(url);

        List<Content> contents = extractor.extractContent(json);

        Stickers sticker = new Stickers();

        for (int i = 0; i < 3; i++){
            Content content = contents.get(i);
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = "aluraJava/Output" + content.getTitle() + ".png";
            sticker.createStickers(inputStream, fileName);
            System.out.println(content.getTitle());
            System.out.println();            
        }
    }
}
