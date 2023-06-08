//import javax.swing.*;
//import java.awt.*;
//
//public class ControlPanelTranslate extends JPanel{
//    public static JTextField translateX, translateY, translateZ;
//    public ControlPanelTranslate(Cube c, CubeView cv){
//        MyButton translate = new MyButton(c, cv, "Translate");
//        translateX = new JTextField("X");
//        translateY = new JTextField("Y");
//        translateZ = new JTextField("Z");
//        GridLayout grid = new GridLayout(4, 1);
//        this.setLayout(grid);
//        this.add(translateX); this.add(translateY); this.add(translateZ); this.add(translate);
//    }
//
//    @Override
//    public void paintComponent(Graphics g){
//        g = (Graphics2D) g;
//        super.paintComponent(g);
//    }
//}