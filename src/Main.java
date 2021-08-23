import java.awt.color.ColorSpace;
import java.awt.image.ColorConvertOp;
import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String args[]) throws Exception {
        JFrame frame = new JFrame("Slike");
        frame.setSize(new Dimension(1200, 900));
        JPanel panel = new Window();
        frame.add(panel);
        frame.setVisible(true);
    }
}