import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MyButton extends JButton implements Observer{
    private Cube _cube;
    private ControlPanel panel;
    private CubeView cubepanel;
    private String Title;

    public MyButton(Cube cube, CubeView v, String title){
        _cube = cube;
        Title = title;
        this.setText(Title);

        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);

        this._cube = cube;
        this.cubepanel = v;
    }

    public void update(Observable o, Object arg) {
        _cube = (Cube) o;
        cubepanel.repaint();
    }
    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (Title.equals("Rotate X +")) {
                _cube.rotate(10, 0, 0);
            }
            if (Title.equals("Rotate X -")) {
                _cube.rotate(-10, 0, 0);
            }
            if (Title.equals("Rotate Y +")) {
                _cube.rotate(0, 10, 0);
            }
            if (Title.equals("Rotate Y -")) {
                _cube.rotate(0, -10, 0);
            }
            if (Title.equals("Rotate Z +")) {
                _cube.rotate(0, 0, 10);
            }
            if (Title.equals("Rotate Z -")) {
                _cube.rotate(0, 0, -10);
            }
            if (Title.equals("Scale")) {
                try {
                    _cube.scalek(Double.parseDouble(ControlPanel.scaleK.getText()));
                }
                catch (Exception b){
                    System.out.println("K не введено. Scale - невозможен");
                }
            }
            if (Title.equals("Translate")) {
                try {
                    _cube.translate(Double.parseDouble(ControlPanel.translateX.getText()),
                            Double.parseDouble(ControlPanel.translateY.getText()),
                            Double.parseDouble(ControlPanel.translateZ.getText()));
                }
                catch (Exception a){
                    System.out.println("XYZ не введено. Translate - невозможен");
                }
            }
            cubepanel.repaint();
        }
    }
}