package programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/12903?language=java
// 가운데 글자 가져오기
public class CenterChar {
    public static void main(String[] args) {
        String answer = solution("qwer");

        System.out.println("answer is "  + answer);
    }

    public static String solution(String s) {
        String answer = "";

        int length = s.length() / 2;

        if(s.length()%2 == 0){
            answer = s.substring(length-1,length+1);
        }else{
            answer = Character.toString(s.charAt(length));
        }
        return answer;
    }
}
