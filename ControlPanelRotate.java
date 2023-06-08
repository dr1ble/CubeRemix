import javax.swing.*;
import java.awt.*;

public class ControlPanelRotate extends JPanel{
    public ControlPanelRotate(Cube c, CubeView cv){
        MyButton rotXadd = new MyButton(c, cv, "Rotate X +");
        MyButton rotXdicr = new MyButton(c, cv, "Rotate X -");
        MyButton rotYadd = new MyButton(c, cv, "Rotate Y +");
        MyButton rotYdicr = new MyButton(c, cv, "Rotate Y -");
        MyButton rotZadd = new MyButton(c, cv, "Rotate Z +");
        MyButton rotZdicr = new MyButton(c, cv, "Rotate Z -");
        GridLayout grid = new GridLayout(2, 3);
        this.setLayout(grid);
        this.add(rotXadd); this.add(rotXdicr); this.add(rotYadd); this.add(rotYdicr); this.add(rotZadd); this.add(rotZdicr);
    }

    @Override
    public void paintComponent(Graphics g){
        g = (Graphics2D) g;
        super.paintComponent(g);
    }
}