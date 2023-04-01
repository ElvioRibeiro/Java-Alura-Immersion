import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractNasaAPI implements ExtractContent {

    public List<Content> extractContent (String json){

        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        //Populate content list

        for (Map<String, String> attributes : attributesList){
            String title = attributes.get("title");
            String urlImage = attributes.get("url");
            Content content = new Content(title, urlImage);
            contents.add(content);
        }
        return contents;

    }

}