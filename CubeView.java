//import javax.swing.*;
//import java.awt.*;
//
//public class CubeView extends JPanel {
//    private Cube _cube;
//
//    public CubeView(Cube cube){
//        _cube = cube;
//    }
//    @Override
//    public void paint(Graphics g){
//        Graphics2D g2d = (Graphics2D)g;
//        super.paint(g2d);
//        if(Facet.type_of_proection)
//            g.drawString("Ортогональная проекция", this.getWidth()/2+90, this.getHeight()/2 +100);
//        else g.drawString("Прямая проекция", this.getWidth()/2+100, this.getHeight()/2+100);
//        g.translate(this.getWidth()/2, this.getHeight()/2);
//        _cube.draw(g2d);
//
//    }
//}