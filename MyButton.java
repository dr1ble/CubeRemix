import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Double.parseDouble;

public class MyButton extends JButton implements Observer{
    private Cube _cube;
    private CubeView cubeView;
    private String Title;
    private int c = 0;

    public MyButton(Cube cube, CubeView cubeView, String title){
        _cube = cube;
        Title = title;
        this.setText(Title);

        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);

        this._cube = cube;
        this.cubeView = cubeView;
    }

    public void update(Observable o, Object arg) {
        _cube = (Cube) o;
        cubeView.repaint();
    }
    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (Title.equals("Rotate X +")) {
                _cube.rotate(Config.rotateX, 0, 0);
            }
            if (Title.equals("Rotate X -")) {
                _cube.rotate(-Config.rotateX, 0, 0);
            }
            if (Title.equals("Rotate Y +")) {
                _cube.rotate(0, Config.rotateY, 0);
            }
            if (Title.equals("Rotate Y -")) {
                _cube.rotate(0, -Config.rotateY, 0);
            }
            if (Title.equals("Rotate Z +")) {
                _cube.rotate(0, 0, Config.rotateZ);
            }
            if (Title.equals("Rotate Z -")) {
                _cube.rotate(0, 0, -Config.rotateZ);
            }
            if (Title.equals("Scale")) {
                try {
                    _cube.scalek(parseDouble(ButtonsPanel.scaleK.getText()));
                }
                catch (Exception b){
                    System.out.println("K не введено. Scale - невозможен");
                }
            }
            if (Title.equals("Translate")) {
                try {
                    double x, y, z;
                    if (Utils.isNumeric(ButtonsPanel.translateX.getText())){
                        x = parseDouble(ButtonsPanel.translateX.getText());
                    }
                    else x = 0;
                    if (Utils.isNumeric(ButtonsPanel.translateY.getText())){
                        y = parseDouble(ButtonsPanel.translateY.getText());
                    }
                    else y = 0;
                    if (Utils.isNumeric(ButtonsPanel.translateZ.getText())){
                        z = parseDouble(ButtonsPanel.translateZ.getText());
                    }
                    else z = 0;
                    if(x == 0 && y == 0 && z == 0)
                        throw new Exception();
                    else
                        _cube.translate(x,y,z);
                }
                catch (Exception a){
                    System.out.println("Координаты не введены. Translate - невозможен");
                }
            }
            if (Title.equals("Switch Proections")){
                Facet.type_of_proection = !Facet.type_of_proection;
            }

            if (Title.equals("Transparency")){
                if(c == 0) {
                    Facet.type_of_view = true;
                    c++;
                } else if (c == 1) {
                    Facet.type_of_view = false;
                    c--;
                }
            }
            cubeView.repaint();
        }
    }
}