import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private Cube _cube;

    private static int _WIDTH = 700;
    private static int _HEIGHT = 700;
    public Screen(Cube cube){
        _cube = cube;

        //this.setDoubleBuffered(true); //для JPanel
        this.setTitle("CUBE");
        this.setSize(_WIDTH, _HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        ControlPanel mypanel = new ControlPanel(cube);
        CubeView cubeView = new CubeView(cube);
        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(2, 1));
        pane.add(mypanel);
        pane.add(cubeView);
    }

}