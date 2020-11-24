package example;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int result = test(a);
        System.out.println(result);
        System.out.println(a);


    }

    static int test(int a){
        a--;
        return a;
    }
}
