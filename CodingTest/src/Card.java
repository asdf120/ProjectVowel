import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Card {
    public static void main(String[] args) {
        int num = 7;
        Queue<Integer> numQue = new LinkedList<>();
        Queue<Integer> deQue = new LinkedList<>();
        for(int i = 1; i<=num; i++){
            numQue.add(i);
        }
        deQue.add(numQue.poll());
        System.out.println(deQue);
        System.out.println(numQue);
        numQue.add(numQue.poll());
        System.out.println(numQue);
        deQue.add(numQue.poll());
        System.out.println(deQue);
        System.out.println(numQue);
        numQue.add(numQue.poll());
        System.out.println(numQue);
    }
}
