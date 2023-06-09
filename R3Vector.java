public class R3Vector {
    private double _x, _y, _z;

    public R3Vector(double x, double y, double z){
        _x = x;
        _y = y;
        _z = z;
    }

    public double getX(){
        return _x;
    }

    public double getY(){
        return _y;
    }

    public double getZ(){
        return _z;
    }

    public void scale(double kx, double ky, double kz){
        _x *= kx;
        _y *= ky;
        _z *= kz;
        //this.actual();
    }
    public void scalek(double k){
        _x *= k;
        _y *= k;
        _z *= k;
        //this.actual();
    }

    public void translate(double dx, double dy, double dz){
        _x += dx;
        _y += dy;
        _z += dz;
        //this.actual();
    }

    private void rotateZ(double u){ //угол в градусах
        // u *= Math.PI/180;
        u = Math.toRadians(u);
        double x = _x;
        double y = _y;
        _x = x*Math.cos(u) - y*Math.sin(u);
        _y = x*Math.sin(u) + y*Math.cos(u);
    }
    private void rotateX(double u){ //угол в градусах
        // u *= Math.PI/180;
        u = Math.toRadians(u);
        double y = _y;
        double z = _z;
        _y = y*Math.cos(u) + z*Math.sin(u);
        _z = z*Math.cos(u) - y*Math.sin(u);
    }
    private void rotateY(double u){ //угол в градусах
        // u *= Math.PI/180;
        u = Math.toRadians(u);
        double x = _x;
        double z = _z;
        _x = x*Math.cos(u) + z*Math.sin(u);
        _z = z*Math.cos(u) - x*Math.sin(u);
    }

    public void rotate(double ux, double uy, double uz){
        this.rotateX(ux);
        this.rotateY(uy);
        this.rotateZ(uz);
        //this.actual();
    }


    public static R3Vector toR3Vector(R3Vector begin, R3Vector end){
        return new R3Vector(end._x - begin._x,
                end._y - begin._y,
                end._z - begin._z);
    }

    public static R3Vector vect(R3Vector a, R3Vector b){
        return new R3Vector(a.getY()*b.getZ() - a.getZ()*b.getY(),
                a.getZ()*b.getX() - a.getX()*b.getZ(),
                a.getX()*b.getY() - a.getY()*b.getX());
    }

    public static boolean equal(R3Vector a, R3Vector b){
        return(a._x==b._x && a._y==b._y && a._z== b._z);
    }

}