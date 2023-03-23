import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadChangeBlueColorLabel extends Thread implements ActionListener {

    private CambiaColoreLayout l;

    public ThreadChangeBlueColorLabel(CambiaColoreLayout l){
        this.l = l;
    }

    public void run() {
        while (true){
            Color preColor = l.getBackground();
            for (JLabel blueLabel : l.getBlueLabels()){
                blueLabel.setBackground(Color.BLUE);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                blueLabel.setBackground(preColor);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ThreadChangeBlueColorLabel t = this;

        t.interrupt();

        t = new ThreadChangeBlueColorLabel(l);

        t.start();
    }
}
