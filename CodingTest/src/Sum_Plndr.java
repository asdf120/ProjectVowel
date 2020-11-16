import java.util.Scanner;

/**
 * 정수를 입력받아 각 자릿수의 합을 구한후 그 수가 회문(거꾸로해도 같은 수인경우에)이면 YES 회문이 아니면 NO를 출력하세요
 * 입력값은 1~ 100000 까지입니다. 예를들어 2345 를 입력하면 2+3+4+5 = 14 는 회문이 아닙니다.
 * 입력예                   출력예
 * 3                                  전체 데이터 입력횟수
 * 131                     YES        한자리수의 경우에도 회문에 해당됩니다 .
 * 123457                  YES         22이므로 회문임
 * 2345                    NO
 */

public class Sum_Plndr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력 : ");
        int input = scanner.nextInt();
        boolean flag = true;
        int sum = 0;

        int temp; // 임시 저장 변수

        int ten;
        int one;

        while (flag) {
            if (input == 100000) {
                System.out.println("YES");
                flag = false;
            } else if (input >= 10000) {
                temp = input / 10000;
                input = input % 10000;
                sum+= temp;
            } else if (input >= 1000) {
                temp = input / 1000;
                input = input % 1000;
                sum += temp;
            } else if (input >= 100) {
                temp = input /100;
                input = input % 100;
                sum += temp;
            } else if (input >= 10) {
                temp = input / 10;
                input = input % 10;
                sum += temp;
            } else if (input < 10){
                temp = input;
                sum += temp;
                flag = false;
            }
        }

        ten = sum / 10;
        one = sum % 10;
        if (sum < 10 || ten == one) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
