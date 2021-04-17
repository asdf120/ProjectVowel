package baekjoon;

import java.util.*;

public class Test2_Solution {
    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 3};
//        int[] arr = {3,4,4,2,5,2,5,5};
        int[] arr = {3,5,3,5,7,5,7,1,4,2,5,3,9,1,9,4,11};
        List<Integer> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>(); // 중복값 넣어둘 리스트
        Set<Integer> set = new HashSet<>();

        for(int num : arr){
            if (set.contains(num) || tempList.contains(num)) { // set에 num의 값이 있거나 temp == num 이면 해당 값 제거
                set.remove(num);
                tempList.add(num);
            }else{
                set.add(num);
            }
        }

        if (set.isEmpty()) {
            list.add(-1);
            System.out.println(list);
        }else{
            for(int num : set){
                list.add(num);
            }
            Collections.sort(list);
            System.out.println(list);
        }
        solution(arr);

    }

    public static void solution(int[] arr) {

        boolean[] alreadyExist = new boolean[100];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {

                    if(alreadyExist[arr[i]]) {
                        alreadyExist[arr[i]] = false;
                        break;
                    }

                    alreadyExist[arr[i]] = true;
                }
            }
        }


        for (int i = 0; i < alreadyExist.length; i++) {
            if(alreadyExist[i]) {
                index++;
            }
        }

        if(index == 0) {
            System.out.println("-1");
        }
        else {
            for (int i = 0; i < alreadyExist.length; i++) {
                if(alreadyExist[i]) {
                    System.out.print(i + " ");
                }
            }
        }

    }

}
