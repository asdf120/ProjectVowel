import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mod1, mod2, max_range;
        int result = 0;

        System.out.println("mod1, mod2, max_range값 입력 ");
        mod1 = scanner.nextInt();
        mod2 = scanner.nextInt();
        max_range = scanner.nextInt();

        for(int i = 1; i<=max_range; i++){
            if (i % mod1 == 0 && i % mod2 != 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
