package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12926
// 시저암호
public class CaesarCipher {
    public static void main(String[] args) {
        String result = solution("aaav",150);
        System.out.println(result);
    }

    public static String solution(String s, int n) {
        String answer = "";
        char ch;

        n = n % 26;

        for(int i = 0; i<s.length(); i++){
            ch = s.charAt(i);
            if(ch>=65 && ch <=90){
                ch = (char)(s.charAt(i)+n);
                if(ch>90){
                    ch = (char)(65 + ch-90-1);
                }
            }else if(ch>=97 && ch <=122){
                ch = (char)(s.charAt(i)+n);
                if(ch>122){
                    ch = (char)(97 + ch-122-1);
                }
            }
            answer += ch;
        }
        return answer;
    }
}
