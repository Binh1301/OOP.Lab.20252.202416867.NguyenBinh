
## 2.2.5
import java.util.Scanner;
 

public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("So thu 1: ");
        String strNum1 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1);
        System.out.print("So thu 2: ");
        String strNum2 = scanner.nextLine();
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        System.out.println("Cong: " + sum);
        System.out.println("Chia: " + difference);
        System.out.println("Nhan: " + product);

        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Khong chia dươc cho 0");
        }

        scanner.close();
    }
}
