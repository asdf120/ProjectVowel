package baekjoon;

import java.util.Scanner;

/**
 * 철수는 주사위 두개를 가지고 있다. 이 주사위 두 개를 던질 때 눈의 합이 어떤 수가 되는가가 궁금하다. 그런데 일일이 따지기 어려워 컴퓨터를 잘하는 당신에게 도움을 요청하였다.
 * 예를 들어, 합이 9 가되 는 경우는
 * 3 6
 * 4 5
 * 5 4
 * 6 3
 * 와 같은 경우이다.
 * 입력형식
 * 입력은 12 이하인 자연수가 주어진다.
 * 출력형식
 * 두 개의 수가 출력된다. 각각 첫번째, 두번째 주사위의 눈이다.
 * 출력은 첫 수가 작은 수부터 먼저 출력한다
 */

public class DiceSum_1599 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("값을 입력 : " );
        int num = scanner.nextInt();
        int mNum = 1;
        int lNum = 1;

        for(mNum = 1; mNum <= 6; mNum++){
            lNum = num-mNum;
            if (lNum <= 6) {
                if (lNum == 0) {
                    break;
                }
                System.out.println(mNum+ " " + lNum);
            }
        }
    }
}
