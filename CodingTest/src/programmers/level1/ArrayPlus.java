package programmers.level1;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/68644
// 두 개 뽑아서 더하기
public class ArrayPlus {
    public static void main(String[] args) {
        int[] array = {5,0,2,7};

        array = solution(array);
    }

    public static int[] solution(int[] numbers) {

        Set set = new HashSet();

        for(int i = 0; i<numbers.length; i++){
            for(int j = i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
            if(i == numbers.length-2){
                break;
            }
        }

        int[] answer = new int[set.size()];

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
