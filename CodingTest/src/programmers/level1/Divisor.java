package programmers.level1;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/12910
//나누어 떨어지는 숫자 배열
public class Divisor {
    public static void main(String[] args) {
        int[] array= {2, 36, 1, 3};
        List<Integer> result = solution(array,1);

        for(int num : result){
            System.out.println(num);
        }
    }

    public static List<Integer> solution(int[] arr, int divisor) {


        List<Integer> answer = new ArrayList<>();

        for(int num : arr){
            if(num % divisor == 0){
                answer.add(num);
            }
        }

        Collections.sort(answer);

        if(answer.size() == 0){
            answer.add(-1);
        }

        return answer;
    }
}
