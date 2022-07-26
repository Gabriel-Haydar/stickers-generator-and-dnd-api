import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;

import javax.imageio.ImageIO;

public class StickerGenerator {

    void create(InputStream inputStream, String pathname, String subtitle, String fontname) throws IOException {

        // leitura da imagem

        //InputStream inputStream = new FileInputStream("input/film.jpg");
        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/MostPopularTVs_1.jpg").openStream();
        BufferedImage og = ImageIO.read(inputStream);

        // cria nova imagem com trasnparência e tamanho novo
        int width = og.getWidth();
        int height = og.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        
        // copia imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(og, 0, 0, null);

        // configurar a fonte
        var font = new Font(fontname, 0, 80);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        // escrever uma frase numa nova imagem
        FontMetrics metrics = graphics.getFontMetrics(font);
        int y = og.getHeight() + ((200 - metrics.getHeight()) / 2) + metrics.getAscent();
        int x = (newImage.getWidth() - metrics.stringWidth(subtitle)) / 2;
        graphics.drawString(subtitle, x, y);

        // escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File(pathname));

    }
}
