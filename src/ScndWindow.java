import javax.swing.*;
import java.util.ArrayList;

public class ScndWindow extends JPanel {
    private SecondCanvas secondCanvas;
    private ButtonForOut buttonForOut;



    ScndWindow(ArrayList<Tacka> kec, ArrayList<Tacka> dva){
        setLayout(null);
        secondCanvas = new SecondCanvas();
        buttonForOut = new ButtonForOut(secondCanvas);



        secondCanvas.setBounds(0,0,1010,900);
        buttonForOut.setBounds(1010,0,200,900);

        add(secondCanvas);
        add(buttonForOut);
    }

}
