## 6.4
import java.util.Scanner;

public class month {
    private int month;
    private int year;
    public month(int month, int year) {
        this.month = month;
        this.year = year;
    }
    public int getNumberOfDays() {

        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        return 31;
    }
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month: ");
        int m = sc.nextInt();
        System.out.print("Enter year: ");
        int y = sc.nextInt();
        month obj = new month(m, y);
        System.out.println("Days: " + obj.getNumberOfDays());
        sc.close();
    }
}
