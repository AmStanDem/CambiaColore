import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CambiaColoreLayout extends JFrame {

    private final int numLabels = 3;

    private ThreadChangeRedColorLabel threadRed;

    private JPanel panRedLabel , panBlueLabel , panButtonsChangeColor;


    private JLabel [] redLabels;

    private JButton btnStartChangeColorRedLabels;

    private JLabel [] blueLabels;

    private JButton btnStartChangeColorBlueLabels;


    public CambiaColoreLayout() {
        Container c = this.getContentPane();

        panRedLabel = new JPanel();

        panRedLabel.setLayout(new GridLayout(numLabels , 1));

        redLabels = new JLabel[numLabels];

        for (int i = 0; i < redLabels.length; i++){
            redLabels[i] = new JLabel("red" + i);
            redLabels[i].setOpaque(true);
            panRedLabel.add(redLabels[i]);
        }

        btnStartChangeColorRedLabels = new JButton("change red label color");

        btnStartChangeColorRedLabels.addActionListener((ActionListener)new ThreadChangeRedColorLabel(this));


        panBlueLabel = new JPanel();

        panBlueLabel.setLayout(new GridLayout(numLabels , 1));

        blueLabels = new JLabel[numLabels];

        for (int i = 0; i < blueLabels.length; i++){
            blueLabels[i] = new JLabel("blue" + i);
            blueLabels[i].setOpaque(true);
            panBlueLabel.add(blueLabels[i]);
        }

        btnStartChangeColorBlueLabels = new JButton("change blue label color");

        btnStartChangeColorBlueLabels.addActionListener((ActionListener) new ThreadChangeBlueColorLabel(this));

        panButtonsChangeColor = new JPanel();

        panButtonsChangeColor.setLayout(new FlowLayout());

        panButtonsChangeColor.add(btnStartChangeColorRedLabels);

        panButtonsChangeColor.add(btnStartChangeColorBlueLabels);

        c.add(panRedLabel , BorderLayout.WEST);

        c.add(panButtonsChangeColor , BorderLayout.SOUTH);

        c.add(panBlueLabel , BorderLayout.EAST);

        this.setSize(600 , 400);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);


    }





    public JLabel[] getBlueLabels() {
        return blueLabels;
    }

    public void setBlueLabels(JLabel[] blueLabels) {
        this.blueLabels = blueLabels;
    }

    public JLabel[] getRedLabels() {
        return redLabels;
    }

    public void setRedLabels(JLabel[] redLabels) {
        this.redLabels = redLabels;
    }

}
