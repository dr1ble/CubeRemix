import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main extends JFrame {
    public Main(){
        this.setTitle("CUBE3D");
        this.setSize(Config._WIDTH, Config._HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(2,1));

        Cube cube = new Cube(); // model
        cube.scalek(80);
        cube.rotate(0, 0, 0);
        CubeView cv = new CubeView(cube); // view
        Controller c = new Controller(cube, cv); // controller

        pane.add(cv);
        pane.add(c.getCp());

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}