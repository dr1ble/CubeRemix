import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{
    public static JTextField scaleK;
    public static JTextField translateX, translateY, translateZ;
    public ControlPanel(Cube c, CubeView cv){
        //ROTATE BUTTONS + TEXTFIELD
        MyButton rotXadd = new MyButton(c, cv, "Rotate X +");
        MyButton rotXdicr = new MyButton(c, cv, "Rotate X -");
        MyButton rotYadd = new MyButton(c, cv, "Rotate Y +");
        MyButton rotYdicr = new MyButton(c, cv, "Rotate Y -");
        MyButton rotZadd = new MyButton(c, cv, "Rotate Z +");
        MyButton rotZdicr = new MyButton(c, cv, "Rotate Z -");
        this.add(rotXadd); this.add(rotXdicr); this.add(rotYadd); this.add(rotYdicr); this.add(rotZadd); this.add(rotZdicr);

        //SCALE BUTTONS + TEXTFIELD
        MyButton scale = new MyButton(c, cv, "Scale");
        scaleK = new JTextField("K");

        this.add(scaleK); this.add(scale);

        //TRANSLATE BUTTONS + TEXTFIELD
        MyButton translate = new MyButton(c, cv, "Translate");
        translateX = new JTextField("X");
        translateY = new JTextField("Y");
        translateZ = new JTextField("Z");
        GridLayout grid = new GridLayout(3, 1);
        this.setLayout(grid);
        this.add(translateX); this.add(translateY); this.add(translateZ); this.add(translate);
    }
    @Override
    public void paintComponent(Graphics g){
        g = (Graphics2D) g;
        super.paintComponent(g);
    }
}