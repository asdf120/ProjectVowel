package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12921
public class Deciaml {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int answer = solution(30000);

        long end = System.currentTimeMillis();
        System.out.println("수행시간 : " + (end - start) / 1000.0);

        System.out.println(answer);
    }

    //TODO 효율성 실패
    public static int solution(int n) {

        // 효율성 실패
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 2; j <= i - 1; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                answer++;
            }
        }

        return answer;


        // 헐...
        /*
        int[] arr = new int[n + 1];
        int c = 0;
        for (int i = 2; i <= n; i++) { // 입력받은 숫자까지의 모든 숫자들을 배열에 초기화한다.
            arr[i] = i;
        }

        int Sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= Sqrt; i++) { // 제곱근 까지만 계산
            if (arr[i] == 0) { // 0으로 초기화 되어있는 숫자들은 건너뛴다.
                continue;
            }
            for (int j = i + i; j <= n; j += i) { // 현재 숫자(i)를 제외한 제곱수들은 모두 0으로 초기화.
                arr[j] = 0; // 0이 들어있는 번지는 소수가 아니다.
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                c++;
            }
        }
        return c;
        */

    }
}
