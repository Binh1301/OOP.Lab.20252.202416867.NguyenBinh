# 2.2.6 phần 3
import java.util.Scanner;

public class quad_equation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ax^2 + bx + c = 0");
        System.out.print("a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    System.out.println("Vo han nghiem");
                else
                    System.out.println("Vo nghiem");
            } else {
                System.out.println("x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);

                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } 
            else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("x = " + x);
            } 
            else {
                System.out.println("Vo nghiem!");
            }
        }

        sc.close();
    }
}
