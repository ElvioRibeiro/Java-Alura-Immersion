import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class Stickers {

    void createStickers(InputStream inputStream, String fileName) throws Exception{

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
        Font font = new Font(Font.DIALOG, Font.BOLD, 64);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);
        String text = "ESCRITA TEXTO";
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D rectangle =  fontMetrics.getStringBounds(text, graphics);
        int textlenght = (int) rectangle.getWidth();
        int textPosX = (width-textlenght)/2;
        graphics.drawString( text ,textPosX, newHeight-20);
        // write image in file
        ImageIO.write(newImage, "png", new File(fileName));
    }    
}
