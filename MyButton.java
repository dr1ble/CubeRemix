import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Double.parseDouble;

public class MyButton extends JButton implements Observer{
    private Cube _cube;
    private Screen _sc;
    private String Title;

    public MyButton(Cube cube, Screen sc, String title){
        _cube = cube;
        Title = title;
        this.setText(Title);

        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);

        this._cube = cube;
        this._sc = sc;
    }

    public void update(Observable o, Object arg) {
        _cube = (Cube) o;
        _sc.repaint();
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
                    _cube.scalek(parseDouble(ControlPanel.scaleK.getText()));
                }
                catch (Exception b){
                    System.out.println("K не введено. Scale - невозможен");
                }
            }
            if (Title.equals("Translate")) {
                try {
                    double x, y, z;
                    if (Utils.isNumeric(ControlPanel.translateX.getText())){
                        x = parseDouble(ControlPanel.translateX.getText());
                    }
                    else x = 0;
                    if (Utils.isNumeric(ControlPanel.translateY.getText())){
                        y = parseDouble(ControlPanel.translateY.getText());
                    }
                    else y = 0;
                    if (Utils.isNumeric(ControlPanel.translateZ.getText())){
                        z = parseDouble(ControlPanel.translateZ.getText());
                    }
                    else z = 0;

                    _cube.translate(x,y,z);
                }
                catch (Exception a){
                    System.out.println("Координаты не введены. Translate - невозможен");
                }
            }
            if (Title.equals("Switch Proections")){
                Facet.type_of_proection = !Facet.type_of_proection;
            }
            _sc.repaint();
        }
    }
}