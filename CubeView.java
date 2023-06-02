import javax.swing.*;
import java.awt.*;

public class CubeView extends JPanel {
    private Cube _cube;

    public CubeView(Cube cube){
        _cube = cube;
        this.setAlignmentX(350);

    }

    public void draw(){
        this.paint(this.getGraphics());
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        super.paint(g2d);
        _cube.draw(g2d);
    }
}