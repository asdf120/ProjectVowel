package acentkorea;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(solution("-H-HH--"));
        System.out.println(solution("H"));
        System.out.println(solution("HH-HH"));
        System.out.println(solution("-H-H-H-H-H"));
    }
    public static int solution(String S) {
        // write your code in Java SE 8
        int result = 0;
        int pCount = 0;
        int hCount = 0;

        char[] ch = S.toCharArray();
        for(char c : ch){
            if(c == '-'){
                pCount++;
            }else{
                hCount++;
            }
        }
        if(hCount - pCount >= 2 || pCount == 0){
            return -1;
        }

        String[] replaceS = S.replace("H-H","1").split("");
        S = "";
        for(String str : replaceS){
            S += str;
            if(str.equals("1")){
                S = S.replace("1","");
                result++;
            }
        }

        ch = S.toCharArray();

        for(int i = 0; i<ch.length; i++){
            if(i == ch.length-1){
                break;
            }
            if(ch[i] != ch[i+1]){
                result++;
                i++;
            }
        }

        return result;
    }
}
