import java.util.Scanner;

public class Test1_369 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int count = 0;

        System.out.println("숫자 입력 :");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            flag = true;
            int temp = i;
            while (flag) {
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) {
                    count++;
                    flag = false;
                }
                temp = temp / 10;
                if (temp == 0) {
                    flag = false;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
