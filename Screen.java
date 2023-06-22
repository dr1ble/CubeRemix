import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Screen extends JFrame {
    private Cube _cube;
    private BufferedImage buffer;
    public Screen(Cube cube){
        _cube = cube;
        this.setTitle("CUBE3D");
        this.setSize(Config._WIDTH, Config._HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        buffer = new BufferedImage(Config._WIDTH, Config._HEIGHT, BufferedImage.TYPE_INT_RGB);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(3,1));
        ControlPanel cp = new ControlPanel(cube, this);
        this.add(cp);
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        super.paint(g2d);
        g.translate(this.getWidth()/2, this.getHeight()/2);
        _cube.draw(g2d);
    }
}