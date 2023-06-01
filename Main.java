import java.util.Scanner;

public class Main {

    public static String typeofview;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Сделать куб прозрачным?(да/нет)");
        typeofview = sc.next();

        Cube cube = new Cube();
        cube.scale(80, 80, 80);
        cube.rotate(0, 0, 180);
        Screen screen = new Screen(cube);

    }
}