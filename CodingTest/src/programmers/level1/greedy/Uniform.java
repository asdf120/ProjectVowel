package programmers.level1.greedy;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42862
// 체육복
public class Uniform {
    public static void main(String[] args) {
        int[] lost = {1,2,3};
        int[] reserve = {2,3,4};

        System.out.println(solution(5,lost,reserve));

    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 최소값

        List<Integer> lostList = new ArrayList<>();
        for(int num : lost){
            lostList.add(num);
        }
        List<Integer> reserveList = new ArrayList<>();
        for(int num : reserve){
            reserveList.add(num);
        }


        for(int r=0; r<reserveList.size(); r++){
            for(int l=0; l<lostList.size(); l++){
                if(reserveList.get(r) == lostList.get(l)){
                    lostList.remove(l);
                    reserveList.remove(r);
                    r = -1;
                    answer++;
                    break;
                }
            }
        }


        for(int r= 0; r<reserveList.size(); r++){
            for(int l = 0; l<lostList.size(); l++){
                    if(reserveList.get(r)-1 == lostList.get(l)){
                        lostList.remove(l);
                        System.out.println("48line 1 증가");
                        answer++;
                        break;
                    }else if(reserveList.get(r)+1 == lostList.get(l)){
                        lostList.remove(l);
                        System.out.println("53line 1 증가");
                        answer++;
                        break;
                    }
                }
        }

        return answer;
    }
}
