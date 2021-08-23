import javax.swing.*;
import java.awt.*;

public class ButtonForOut extends JPanel {
    private JButton show;
    private JTextField num;
    SecondCanvas secondCanvas;


    ButtonForOut(SecondCanvas sc){
        setLayout(null);
        secondCanvas = sc;

        show = new JButton("Broj");
        show.setBounds(5,5,165,165);
        show.setBackground(Color.darkGray);
        show.setForeground(Color.white);
        show.addActionListener(l->{
            if(secondCanvas.jedan) num.setText("1");
            else num.setText("2");
        });

        add(show);

        num = new JTextField("");
        num.setBounds(5,200,165,165);

        add(num);

    }

}
