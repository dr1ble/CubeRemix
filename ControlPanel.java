import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{
    public static JTextField scaleK;
    public static JTextField translateX, translateY, translateZ;
    public ControlPanel(Cube c, Screen sc){
        //ROTATE BUTTONS + TEXTFIELD
        MyButton rotXadd = new MyButton(c, sc, "Rotate X +");
        MyButton rotXdicr = new MyButton(c, sc, "Rotate X -");
        MyButton rotYadd = new MyButton(c, sc, "Rotate Y +");
        MyButton rotYdicr = new MyButton(c, sc, "Rotate Y -");
        MyButton rotZadd = new MyButton(c, sc, "Rotate Z +");
        MyButton rotZdicr = new MyButton(c, sc, "Rotate Z -");
        this.add(rotXadd); this.add(rotXdicr); this.add(rotYadd); this.add(rotYdicr); this.add(rotZadd); this.add(rotZdicr);

        //SCALE BUTTONS + TEXTFIELD
        MyButton scale = new MyButton(c, sc, "Scale");
        scaleK = new JTextField("K");

        this.add(scaleK); this.add(scale);
        //TRANSLATE BUTTONS + TEXTFIELD
        MyButton translate = new MyButton(c, sc, "Translate");
        translateX = new JTextField("X");
        translateY = new JTextField("Y");
        translateZ = new JTextField("Z");
        GridLayout grid = new GridLayout(4, 1);
        this.setLayout(grid);
        this.add(translateX); this.add(translateY); this.add(translateZ); this.add(translate);
        MyButton switch_proections = new MyButton(c, sc, "Switch Proections");
        this.add(switch_proections);
    }
    @Override
    public void paintComponent(Graphics g){
        g = (Graphics2D) g;
        super.paintComponent(g);
        if(Facet.type_of_proection)
            g.drawString("Ортогональная проекция", this.getWidth()/2+90, this.getHeight()/2 +100);
        else g.drawString("Прямая проекция", this.getWidth()/2+100, this.getHeight()/2+100);
    }

}