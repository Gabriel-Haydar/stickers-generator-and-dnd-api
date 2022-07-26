import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";

        String url = "https://dnd-images-api.herokuapp.com/cos-images";        
        ContentExtractor extractor = new ContentExtractorForDnD();

        var http = new HttpOfClient();
        String json = http.buscaDados(url);

        // exibir e manipular os dados 
        List<Content> contents = extractor.extractContent(json);

        var generator = new StickerGenerator();
        var scanner= new Scanner(System.in); 
        for (int i = 0; i < 4; i++) {

            Content content = contents.get(i);
            System.out.println("Title: " + content.getTitle() + ". Add a subtitle for sticker:");
            String subtitle = scanner.nextLine();

            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = "output/" + content.getTitle() + ".png";

            generator.create(inputStream, fileName, subtitle, "Arial");
            System.out.println();
        }
        scanner.close();
    }
}
