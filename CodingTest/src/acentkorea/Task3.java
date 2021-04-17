package acentkorea;

public class Task3 {
    public static void main(String[] args) {
//        int[] array = {3, 4, 5, 3, 7};
//        int[] array = {1, 3, 1, 2};
//        int[] array = {4, 3, 2, 1};
        int[] array = {1, 5, 4, 3, 2};
        System.out.println(solution(array));
    }

    public static int solution(int[] A) {
        int bigCount = 0;
        int smallCount = 0;
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            if (i == A.length - 1) {
                break;
            }
            if (i == A.length - 2 && bigCount == 0 && smallCount == 0) {
                result = 0;
                break;
            }

            if (A[i] < A[i + 1]) {
                bigCount++;
            } else {
                smallCount++;
            }
            if (bigCount >= 1 && smallCount >= 1) {
                bigCount--;
                smallCount--;
            } else if (bigCount >= 3 || smallCount >= 3) {
                return -1;
            } else {
                result++;
            }

        }
        return result;
    }
}
