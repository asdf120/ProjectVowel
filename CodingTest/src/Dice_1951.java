import java.util.Scanner;

/**
 * N1, N2, N3면체로 이루어진 3개의 주사위를 던졌을 때, 3개의 주사위의 눈의 합 중에서 나올 수 있는 경우의 수가 가장 많은 합을 찾는 프로그램을 작성하라.
 * N면체의 주사위에는 눈이 1개인 것부터 N개인 것이 하나씩 존재하며, N1 = 3, N2 = 2, N3 = 3일 경우 3개의 주사위의 눈의합이 가능한 경우는 다음과 같다.
 * 1 1 1 -> 3  1 2 1 -> 4  2 1 1 -> 4  2 2 1 -> 5  3 1 1 -> 5  3 2 1 -> 6
 * 1 1 2 -> 4  1 2 2 -> 5  2 1 2 -> 5  2 2 2 -> 6  3 1 2 -> 6  3 2 2 -> 7
 * 1 1 3 -> 5  1 2 3 -> 6  2 1 3 -> 6  2 2 3 -> 7  3 1 3 -> 7  3 2 3 -> 8
 * 이 경우에는 합이 5와 6인 경우가 가장 많다.
 * 입력형식
 * 입력은 3개의 자연수 N1, N2, N3가 입력된다(2≤N1≤20, 2≤N2≤20, 2≤N3≤40)
 * 출력형식
 * 입력된 주사위들의 눈의 합 중 가장 많이 나오는 합의 숫자를 출력하며 여러개 있을 경우 가장 작은 숫자를 출력한다.
 * 입력예
 * 3 2 3
 * 출력예
 * 5
 */
public class Dice_1951 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("각각의 숫자 입력 : ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int[] sumCount = new int[n1*n2*n3];

        for(int first = 1; first <= n1; first++){
            for (int second = 1; second<=n2; second++){
                for(int third = 1; third<=n3; third++){
                    System.out.println(first + second + third);
                }
            }
        }
    }
}
