package programmers.hash;

import java.util.*;

public class Marathon {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String answer = solution(participant, completion);
        System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        // 1 효율성 탈락
        /*
        for(int i = 0; i<participant.length; i++){
            for(int j = 0; j<completion.length; j++){
                if(participant[i].equals(completion[j])){
                    participant[i] = "pass";
                    completion[j] = "pass";
                }
            }
        }
        for(int i = 0; i<participant.length; i++){
            if(!participant[i].equals("pass")){
                answer = participant[i];
            }
        }
        */

        // 2
        for (String name : participant) {
            System.out.println("participant : " + name);
            for (String complete : completion) {
                System.out.println("complete : " + complete);
                if (name.equals(complete)) {
                    System.out.println(name);
                    break;
                } else {
                    answer = name;
                }
            }
        }

        // 재상이꺼
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        for (String name : participant){
//            System.out.print(name + " ");
//        }
//        System.out.println();
//        for(String complete : completion){
//            System.out.print(complete + " ");
//        }
//        System.out.println();
//
//        int ck=0;
//        for (int i=0;i<completion.length;i++){
//            if (!participant[i].equals(completion[i])){
//                answer=participant[i];
//                ck=1;
//                break;
//            }
//        }
//        if(ck==0){
//            answer=participant[completion.length];
//        }


        return answer;

    }
}
