package programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/12912
//두 정수 사이의 합
public class NumberPlus {
    public static void main(String[] args) {
        System.out.println(solution(3,6));
    }
    public static long solution(int a, int b) {
        long answer = 0;

//        if(a==b){
//            answer = a;
//        }else{
//            if(a<b){
//                for(int i = a; i<=b; i++){
//                    answer +=i;
//                }
//            }else{
//                for(int i = b; i<=a; i++){
//                    answer += i;
//                }
//            }
//        }

        // 다른분꺼
        if(a!=b){
            for(int i=Math.min(a,b);i<=Math.max(a,b);i++){
                answer+=i;
            }
        }else{
            answer=a;
        }

        return answer;
    }
}
