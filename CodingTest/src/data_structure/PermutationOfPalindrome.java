package data_structure;

public class PermutationOfPalindrome {
    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("aa bb cc dd"));
        System.out.println(isPermutationOfPalindrome("aa bb cc dd efg"));
        System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff g h"));
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('z'));
    }

    private static boolean isPermutationOfPalindrome(String s){
        int[] table = buildCharFrequencyTable(s);
        return checkMaxOneOdd(table);
    }

    private static int[] buildCharFrequencyTable(String s){
        int[] table = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a')+1];    // 문자들의 갯수만큼 배열 공간 배정
        for(char c : s.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }
        return table;
    }

    private static int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a<= val && val <=z){
            System.out.print("c의 값 : " +  c + " ");
            System.out.println(val - a);
            return val - a;
        }
        return -1;
    }

    private static boolean checkMaxOneOdd(int[] table){
        boolean founndOdd = false;
        for(int count : table){
            if(count %2 == 1){
                if(!founndOdd){
                    founndOdd = true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

}
