package data_structure;
// https://www.youtube.com/watch?v=O0kcgFtiSkU&list=PLjSkJdbr_gFaPf3ojJFZYXXA__8zcUpdZ&index=6
// 문자열안의 공백을 URL인코딩하기
public class UrlEncoding {
    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith       ", 13));
    }

    private static String URLify(String str, int len){
        return URLify(str.toCharArray(), len);
    }

    private static String URLify(char[] str, int len){
        int spaces = 0;
        for(int i = 0; i<len; i++){
            if(str[i] == ' '){
                spaces++;
            }
        }
        System.out.println("spaces : " + spaces);
        int index = len + spaces * 2 - 1;
        System.out.println("index : " + index);
        for(int p = len -1; p>=0; p--){
            if(str[p] ==' '){
                str[index--] = '0';
                str[index--] = '2';
                str[index--] = '%';
            }else{
                str[index--] = str[p];
            }
        }
        return new String(str);
    }
}
