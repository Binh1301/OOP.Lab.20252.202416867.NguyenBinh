## 2.2.6 phần 1
import java.util.Scanner;

public class linear_equation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ax + b = 0");
        System.out.print("a: ");
        double a = sc.nextDouble();

        System.out.print("b: ");
        double b = sc.nextDouble();

        if (a == 0) {
            if (b == 0)
                System.out.println("Vo han nghiem");
            else
                System.out.println("Vo nghiem");
        } else {
            double x = -b / a;
            System.out.println("x = " + x);
        }

        sc.close();
    }
}