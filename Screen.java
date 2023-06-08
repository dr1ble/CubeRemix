import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private Cube _cube;

    private static int _WIDTH = 500;
    private static int _HEIGHT = 500;
    public Screen(Cube cube){
        _cube = cube;
        //this.setDoubleBuffered(true); //для JPanel
        this.setTitle("CUBE");
        this.setSize(_WIDTH, _HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CubeView cubeView = new CubeView(_cube);
        ControlPanelRotate PanelRotate = new ControlPanelRotate(_cube, cubeView);
        ControlPanelScale PanelScale = new ControlPanelScale(_cube, cubeView);
        ControlPanelTranslate PanelTranslate = new ControlPanelTranslate(_cube, cubeView);
        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(4,1));
        pane.add(cubeView);
        pane.add(PanelRotate);
        pane.add(PanelScale);
        pane.add(PanelTranslate);

        this.setVisible(true);
    }

}