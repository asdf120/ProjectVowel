package data_structure;

import java.util.HashMap;

// https://www.youtube.com/watch?v=xnGyjBptpZ4&list=PLjSkJdbr_gFaPf3ojJFZYXXA__8zcUpdZ&index=4
// 문자열 안의 문자들이 고유한지 확인
public class UniqueChar {
    public static void main(String[] args) {
        System.out.println(isUnique("abcdefgghijk"));
        System.out.println(isUnique("abcdefghijk"));
        System.out.println(isUnique2("abcdefgghijk"));
        System.out.println(isUnique2("abcdefghijk"));
        System.out.println(isUnique3("abcdefgghijk"));
        System.out.println(isUnique3("abcdefghijk"));
    }

    // 문자를 아스키코드로만 봤을때
    private static boolean isUnique(String str){
        if(str.length()>128){
            return false;
        }
        boolean[] char_set = new boolean[128];
        for(int i = 0; i<str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    // 문자를 unicode로 봤을때
    private static boolean isUnique2(String str){
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        for(int i = 0;i<str.length(); i++){
            int ch = str.charAt(i);
            if(hashMap.containsKey(ch)){
                return false;
            }
            hashMap.put(ch,true);
        }
        return true;
    }

    // 비트 연산자
    private static boolean isUnique3(String str){
        int checker = 0;
        for(int i = 0; i<str.length(); i++){
            int val = str.charAt(i)-'a';
            if((checker & (1<<val))>0){
                return false;
            }
            checker |= (1<<val);
        }
        return true;
    }
}
