import javax.swing.*;
import java.awt.*;

public class Params extends JPanel {
    private JButton a, b, c;
    private JTextField af, bf, cf;
    private Graph graph;

    Params(Graph g) {
        setLayout(null);
        graph = g;
        setBackground(Color.lightGray);

        initButtons();
        initFields();


    }

    private void initFields() {
        af = new JTextField("");
        af.setBounds(5, 5, 100, 45);
        af.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(af);

        bf = new JTextField("");
        bf.setBounds(150, 5, 100, 45);
        bf.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(bf);

        cf = new JTextField("");
        cf.setBounds(300, 5, 100, 45);
        cf.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(cf);

    }

    private void initButtons() {
        a = new JButton("X koeficijent");
        a.setBounds(5, 55, 100, 45);
        a.setBackground(Color.darkGray);
        a.setForeground(Color.white);
        a.addActionListener(l->{
            graph.getA(Double.parseDouble(af.getText()));
        });
        add(a);

        b = new JButton("Y koeficijent");
        b.setBounds(150, 55, 100, 45);
        b.setBackground(Color.darkGray);
        b.setForeground(Color.white);
        b.addActionListener(l->{
            graph.getB(Double.parseDouble(bf.getText()));
        });
        add(b);

        c = new JButton("koeficijent");
        c.setBounds(300, 55, 100, 45);
        c.setBackground(Color.darkGray);
        c.setForeground(Color.white);
        c.addActionListener(l -> {
            graph.getC(Double.parseDouble(cf.getText()));
        });
        add(c);


    }


}
