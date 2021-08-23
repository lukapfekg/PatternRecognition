import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SecondFrame extends JFrame {


    SecondFrame(ArrayList<Tacka> kec, ArrayList<Tacka> dva) {
        JFrame frame = new JFrame("Slike");
        frame.setSize(new Dimension(1200, 900));
        JPanel panel = new ScndWindow(kec, dva);
        frame.add(panel);
        frame.setVisible(true);
    }


}
