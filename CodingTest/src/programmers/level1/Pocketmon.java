package programmers.level1;

//https://programmers.co.kr/learn/courses/30/lessons/1845
public class Pocketmon {
    public static void main(String[] args) {
        int[] num = {3,3,3,2,2,4};

        int result = solution(num);

        System.out.println(result);
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    nums[j]--;
                }
            }
        }
        System.out.println("포켓몬 종류 : " + nums.length);

        int choice = nums.length/2 ;



        return answer;
    }
}
