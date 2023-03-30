import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class Stickers {

    void createStickers(InputStream inputStream, String fileName) throws Exception{

        // Get image
        //InputStream inputStream = new FileInputStream(new File("C:/JAVA/Java-Alura-Immersion/MovieAPI/images/movie.jpg"));
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_9.jpg").openStream();
        //BufferedImage defaultImage = ImageIO.read(new File("images/movie.jpg"));

        BufferedImage defaultImage = ImageIO.read(inputStream);

        // Create image - transparency and size
        int width = defaultImage.getWidth();
        int heigth = defaultImage.getHeight();
        int newHeight = heigth+200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);


        // Copy original image to new image
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(defaultImage, 0, 0, null);


        // Edit image
        Font font = new Font(Font.SERIF, Font.BOLD, width);
        graphics.setFont(font);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Imersão Java", 50, newHeight-20);

        // write image in file
        ImageIO.write(newImage, "png", new File(fileName));
    }    
}
