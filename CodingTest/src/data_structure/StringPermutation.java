package data_structure;

import java.util.Arrays;

// https://www.youtube.com/watch?v=6I1L8oRl3FA&list=PLjSkJdbr_gFaPf3ojJFZYXXA__8zcUpdZ&index=5
// 두개의 문자열이 서로 치환(Permutation) 가능한지 알아내기
public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(permutation("ABC","BCA"));
        System.out.println(permutation("ABC","BDA"));
        System.out.println(permutation2("ABC","BCA"));
        System.out.println(permutation2("ABC","BDA"));
    }

    private static String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // sort() 함수 이용하여 확인
    private static boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        return sort(s).equals(sort(t));
    }

    // ASCII 코드 이용하여 확인
    private static boolean permutation2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] letters = new int[128];
        for(int i = 0; i<s.length(); i++){
            letters[s.charAt(i)]++;
            System.out.println(i+"의 letter s값 : " + letters[s.charAt(i)]);
        }
        for(int i = 0;i<t.length(); i++){
            letters[t.charAt(i)]--;
            System.out.println(i+"의 letter t 값 : " + letters[t.charAt(i)]);
            if(letters[t.charAt(i)]<0){
                return false;
            }
        }
        return true;
    }
}
