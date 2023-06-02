import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{
    private String str = "0";

    private Cube cube;

    public ControlPanel(Cube cube){
        JButton button = new JButton("Test button");
        JButton button1 = new JButton("ASD");
        JButton button2 = new JButton("Test button");
        JButton button3 = new JButton("ASD");
        GridLayout grid = new GridLayout(2, 2);
        this.setLayout(grid);
        this.add(button);
        this.add(button1);
        this.add(button2);
        this.add(button3);
    }

    @Override
    public void paintComponent(Graphics g){
        g = (Graphics2D) g;
        super.paintComponent(g);
        g.drawString(str, 20, 20);
    }
}