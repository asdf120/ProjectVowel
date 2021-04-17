package programmers.level1;

import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/12906
public class SameNumber {
    public static void main(String[] args) {
        int[] array = {4,4,4,3,3};
        List<Integer> result = solution(array);

        for(int num : result){
            System.out.println(num);
        }

    }

    public static List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] != arr[j]) {
                    answer.add(arr[i]);
                    break;
                }else{
                    i=j;
                }
            }
        }
        answer.add(arr[arr.length-1]);

        return answer;
    }
}
