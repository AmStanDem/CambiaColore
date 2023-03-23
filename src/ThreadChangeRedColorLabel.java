import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadChangeRedColorLabel  extends Thread implements ActionListener  {

    private CambiaColoreLayout l;

    ThreadChangeRedColorLabel(CambiaColoreLayout l) {
        this.l = l;
    }

    public void run() {

        while (true){
            Color preColor = l.getBackground();
            for (JLabel redLabel : l.getRedLabels()){
                redLabel.setBackground(Color.RED);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                redLabel.setBackground(preColor);
            }
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ThreadChangeRedColorLabel t = this;

        t.interrupt();

        t = new ThreadChangeRedColorLabel(l);

        t.start();

    }
}
