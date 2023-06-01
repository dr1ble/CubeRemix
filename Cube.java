import java.awt.*;
import java.util.ArrayList;

public class Cube {
    private Facet[] _facets;

    ArrayList<Facet> nearT;

    public Cube(){
        _facets = new Facet[6];
        nearT = new ArrayList<>();

        //дальняя грань, в плоскости XY
        _facets[0] = new Facet(new R3Vector(0, 0, 0),
                new R3Vector(0, 1, 0),
                new R3Vector(1, 1, 0),
                new R3Vector(1, 0, 0));
        _facets[0].setColor(Color.RED);

        //передняя грань
        _facets[1] = new Facet(new R3Vector(0, 0, 1),
                new R3Vector(1, 0, 1),
                new R3Vector(1, 1, 1),
                new R3Vector(0, 1, 1));
        _facets[1].setColor(Color.BLUE);

        //верхняяя грань
        _facets[2] = new Facet(new R3Vector(0, 1, 0),
                new R3Vector(0, 1, 1),
                new R3Vector(1, 1, 1),
                new R3Vector(1, 1, 0));
        _facets[2].setColor(Color.GREEN);

        //нижняя грань, в плоскоти XY
        _facets[3] = new Facet(new R3Vector(0, 0, 0),
                new R3Vector(1, 0, 0),
                new R3Vector(1, 0, 1),
                new R3Vector(0, 0, 1));
        _facets[3].setColor(Color.YELLOW);

        //левая боковая грань, в плоскости YZ
        _facets[4] = new Facet(new R3Vector(0, 0, 0),
                new R3Vector(0, 0, 1),
                new R3Vector(0, 1, 1),
                new R3Vector(0, 1, 0));
        _facets[4].setColor(Color.GRAY);

        //правая боковая грань
        _facets[5] = new Facet(new R3Vector(1, 0, 0),
                new R3Vector(1, 1, 0),
                new R3Vector(1, 1, 1),
                new R3Vector(1, 0, 1));
        _facets[5].setColor(Color.BLACK);
        this.translate(-0.5, -0.5, -0.5);
    }

    public void scale(double kx, double ky, double kz){
        for(Facet v: _facets) //(int i = 0; i<_vertex.length; i++)
            v.scale(kx, ky, kz);
    }

    public void translate(double dx, double dy, double dz){
        for(Facet v: _facets) //(int i = 0; i<_vertex.length; i++)
            v.translate(dx, dy, dz);
    }

    public void rotate(double ux, double uy, double uz){
        for(Facet v: _facets) //(int i = 0; i<_vertex.length; i++)
            v.rotate(ux, uy, uz);
    }

    public void draw(Graphics2D g){
        // near();
        for(int i = 0; i < _facets.length; i++)
            _facets[i].draw(g);


    }
}
