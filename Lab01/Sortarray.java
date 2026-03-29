## 6.5
import java.util.Arrays;
import java.util.Scanner;

public class Sortarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do dài mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Giá trị của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Mảng ban đầu: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.print("\nMảng sau khi sắp xếp: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        double avg = (double) sum / n;
        System.out.println("\nTổng: " + sum);
        System.out.println("Trung bình: " + avg);
        sc.close();
    }
}
