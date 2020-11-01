import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 3};
        int[] arr = {3,4,4,2,5,2,5,5};
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    continue;
                }else{
                    resultList.add(arr[i]);
                    break;
                }
            }
        }

        if (resultList.isEmpty()) {
            System.out.println("-1");
        } else {
//            Collections.sort(resultList);
            for (int result : resultList) {
                System.out.print(result + " ");
            }
        }
    }
}
