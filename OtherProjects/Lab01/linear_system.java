## 2.2.6 phần 2
import java.util.Scanner;
public class linear_system {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("a_11 * x1 + a_12 * x2 = b1");
        System.out.println("a_21 * x1 + a_22 * x2 = b2");

        System.out.print("a_11, a_12, b1: ");
        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();

        System.out.print("a_21, a_22, b2: ");
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();


        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            System.out.println("x1 = " + (D1 / D));
            System.out.println("x2 = " + (D2 / D));
        } else {
            if (D1 == 0 && D2 == 0)
                System.out.println("Vo han nghiem");
            else
                System.out.println("Vo nghiem");
        }

        sc.close();
    }
}
