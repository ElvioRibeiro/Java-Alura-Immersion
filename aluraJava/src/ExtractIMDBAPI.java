import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractIMDBAPI implements ExtractContent{

    public List<Content> extractContent (String json){

        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> content = new ArrayList<>();

        //Populate content list

        for (Map<String, String> attributes : attributesList){
            String title = attributes.get("title");
            String urlImage = attributes.get("image");
            Content contents = new Content(title, urlImage);

            content.add(contents);

        }

        return content;

    }

}