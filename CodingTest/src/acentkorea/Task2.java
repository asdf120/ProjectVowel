package acentkorea;

public class Task2 {
    public static void main(String[] args) {
        int[][] array = {{4,3,4,5,3},{2,7,3,8,4},{1,7,6,5,2},{8,4,9,5,5}};
        solution(array);
    }
    public static int solution(int[][] A) {
        // write your code in Java SE 8
        int result = 0;

        for(int i = 0; i<A.length; i++){
            for(int j = 0; j<A[i].length; j++){
                System.out.print(A[i][j]+ " ");
            }
            System.out.println();
        }

        return result;
    }
}
