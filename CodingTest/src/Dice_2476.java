import java.util.Scanner;

/**
 * 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.
 * 규칙(1) 같은 눈이 3개가 나오면 10,000원+(같은 눈)*1,000원의 상금을 받게 된다.
 * 규칙(2) 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)*100원의 상금을 받게된다.
 * 규칙(3) 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)*100원의 상금을 받게 된다.
 *  예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3*100으로 계산되어 1,300원을 받게 된다. 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2*1,000 으로 계산되어 12,000원을 받게 된다. 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6*100으로 계산되어 600원을 상금으로 받게 된다.
 *  3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.
 * 입력형식
 * 첫 째 줄에 전체 실행횟수가 입력되고 두번째 줄에 세개의 주사위 값이 빈칸을 사이에 두고 각각 주어진다.
 * 출력형식
 * 첫째 줄에 게임의 상금을 출력 한다.
 */
public class Dice_2476 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = 0;
        int largeNum = 0;

        int diceNum = scanner.nextInt();

        int[] dice = new int[3];

        for(int i=0; i<dice.length; i++) {
            dice[i] = scanner.nextInt();
            largeNum = dice[0];
            if(i == 0){
                continue;
            }else{
                if(largeNum < dice[i]){
                    largeNum = dice[i];
                }
            }
        }

        if(dice[0] == dice[1] && dice[1] == dice[2]){
            money = 10000 + dice[0]*1000;
        }else if(dice[0] == dice[1] && dice[0] != dice[2]){
            money = 1000 + dice[1]*100;
        }else if(dice[0] != dice[1] && dice[1] == dice[2]){
            money = 1000 + dice[1]*100;
        }else if(dice[0] == dice[2] && dice[0] != dice[1]){
            money = 1000 + dice[0]*100;
        }else{
            money = largeNum * 100;
        }

        System.out.println(money);
    }
}
