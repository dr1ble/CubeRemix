import java.awt.*;
import java.util.Scanner;

public class Main {

    public static String typeofview;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Сделать куб прозрачным?(да/нет)");
        typeofview = sc.next();
        Cube cube = new Cube(); // модель
        cube.scalek(80);
        cube.rotate(0, 0, 0);
        Screen screen = new Screen(cube); //view + controller

    }
}