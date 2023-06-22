import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] _vertex;
    private Color _color;

    private boolean visibility = false;
    public static boolean type_of_proection = false;

    public static boolean type_of_view = false;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4){
        _vertex = new R3Vector[]{v1, v2, v3, v4};
        setColor(Color.RED);
    }

    public void setColor(Color color){
        _color = color;
    }

    public void scale(double kx, double ky, double kz){
        for(int i = 0; i < _vertex.length; i++)
            _vertex[i].scale(kx,ky,kz);

        //for(R3Vector v: _vertex)
        // v.scale(kx,ky,kz);
    }
    public void scalek(double k){
        for(int i = 0; i < _vertex.length; i++)
            _vertex[i].scalek(k);

        //for(R3Vector v: _vertex)
        // v.scale(kx,ky,kz);
    }


    public void translate(double dx, double dy, double dz) {
        for (int i = 0; i < _vertex.length; i++)
            _vertex[i].translate(dx, dy, dz);
    }

    public void rotate(double ux, double uy, double uz) {
        for (int i = 0; i < _vertex.length; i++)
            _vertex[i].rotate(ux, uy, uz);
    }

    public void draw(Graphics2D g) {
        Path2D p = new Path2D.Double();

        int c = -2000;

        if(type_of_proection) {
            double t0 = 1 + (_vertex[0].getZ() / c);
            double t1 = 1 + (_vertex[1].getZ() / c);
            double t2 = 1 + (_vertex[2].getZ() / c);
            double t3 = 1 + (_vertex[3].getZ() / c);
            p.moveTo(_vertex[0].getX() * t0, _vertex[0].getY() * t0);
            p.lineTo(_vertex[1].getX() * t1, _vertex[1].getY() * t1);
            p.lineTo(_vertex[2].getX() * t2, _vertex[2].getY() * t2);
            p.lineTo(_vertex[3].getX() * t3, _vertex[3].getY() * t3);
            p.lineTo(_vertex[0].getX() * t0, _vertex[0].getY() * t0);
        }
        else{
            p.moveTo(_vertex[0].getX(), _vertex[0].getY());
            p.lineTo(_vertex[1].getX(), _vertex[1].getY());
            p.lineTo(_vertex[2].getX(), _vertex[2].getY());
            p.lineTo(_vertex[3].getX(), _vertex[3].getY());
            p.lineTo(_vertex[0].getX(), _vertex[0].getY());
        }
        p.closePath();

        g.setColor(_color);

        if (type_of_view)
            g.draw(p);

        if (normal(visibility) && !type_of_view)
            g.fill(p);
    }

    public boolean normal(boolean visibility) {
        double zVal = R3Vector.vect(
                R3Vector.toR3Vector(_vertex[1], _vertex[2]),
                R3Vector.toR3Vector(_vertex[2], _vertex[3])).getZ();
        if (zVal < 0) {
            visibility = true;
        }
        return visibility;
    }
}
