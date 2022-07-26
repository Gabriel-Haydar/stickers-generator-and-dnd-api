import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorForDnD implements ContentExtractor {

    public List<Content> extractContent(String json) {

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listOfAttributes = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> attributes : listOfAttributes) {
            String title = attributes.get("title");
            String urlImage = attributes.get("url");

            var content = new Content(title, urlImage);

            contents.add(content);
        }

        return contents;
    }

}
