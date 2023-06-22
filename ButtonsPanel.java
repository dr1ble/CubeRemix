import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel{
    public static JTextField scaleK;
    public static JTextField translateX, translateY, translateZ;
    public ButtonsPanel(Cube cube, CubeView cubeView){
        //ROTATE BUTTONS + TEXTFIELD
        MyButton rotXadd = new MyButton(cube, cubeView, "Rotate X +");
        MyButton rotXdicr = new MyButton(cube, cubeView, "Rotate X -");
        MyButton rotYadd = new MyButton(cube, cubeView, "Rotate Y +");
        MyButton rotYdicr = new MyButton(cube, cubeView, "Rotate Y -");
        MyButton rotZadd = new MyButton(cube, cubeView, "Rotate Z +");
        MyButton rotZdicr = new MyButton(cube, cubeView, "Rotate Z -");
        this.add(rotXadd); this.add(rotXdicr); this.add(rotYadd); this.add(rotYdicr); this.add(rotZadd); this.add(rotZdicr);

        //SCALE BUTTONS + TEXTFIELD
        MyButton scale = new MyButton(cube, cubeView, "Scale");
        scaleK = new JTextField("K");

        this.add(scaleK); this.add(scale);
        //TRANSLATE BUTTONS + TEXTFIELD
        MyButton translate = new MyButton(cube, cubeView, "Translate");
        translateX = new JTextField("X");
        translateY = new JTextField("Y");
        translateZ = new JTextField("Z");
        GridLayout grid = new GridLayout(4, 1);
        this.setLayout(grid);
        this.add(translateX); this.add(translateY); this.add(translateZ); this.add(translate);

        //SWITCH PROECTIONS
        MyButton switch_proections = new MyButton(cube, cubeView, "Switch Proections");
        this.add(switch_proections);

        //TRANSPARENCY
        MyButton transparency = new MyButton(cube, cubeView, "Transparency");
        this.add(transparency);

    }
    @Override
    public void paintComponent(Graphics g){
        g = (Graphics2D) g;
        super.paintComponent(g);
    }

}