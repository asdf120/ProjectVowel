import java.util.*;

public class Test2_Solution {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 3};
//        int[] arr = {3,4,4,2,5,2,5,5};
//        int[] arr = {3,5,3,5,7,5,7};
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int temp = 0;   // 임시 저장 값

        for(int num : arr){ 
            if (set.contains(num) || temp == num) { // set에 num의 값이 있거나 temp == num 이면 해당 값 제거
                set.remove(num);
                temp = num;
                continue;
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

    }
}
