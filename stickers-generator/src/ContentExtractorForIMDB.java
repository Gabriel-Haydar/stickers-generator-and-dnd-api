import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorForIMDB implements ContentExtractor {
    
    public List<Content> extractContent(String json) {
         // extrair só os dados que interessam (titulo, poster, classificação)
         var parser = new JsonParser();
         List<Map<String, String>> listOfAttributes = parser.parse(json);
 
         List<Content> conteudos = new ArrayList<>();
 
         // popular a lista de conteudos
         for (Map<String, String> attributes : listOfAttributes) {

            String tittle = attributes.get("title");
            String urlImage = attributes.get("image")
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var content = new Content(tittle, urlImage);
 
             conteudos.add(content);
         }
 
         return conteudos;
    }

}
