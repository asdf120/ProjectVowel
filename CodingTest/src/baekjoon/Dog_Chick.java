package baekjoon;

import java.util.Scanner;

/**
 * 강아지와 병아리의 합과 다리의 수를 입력받아 강아지와 병아리가 각각 몇 마리씩인지 구하는 프로그램을 작성하시오.
 * 입력형식
 * 강아지와 병아리의 합 1000 이하 다리의 합 4000 이하의 정수를 공백으로 구분하여 입력받는다.
 * 하나의 결과가 나온 후에도 계속 새로운 입력을 받다가 0 이 입력되면 프로그램을 종료한다.
 * 출력형식
 * 강아지와 병아리가 각각 몇 마리씩인지 공백으로 구분하여 출력한다.
 * 주어진 데이터로 마리수를 정할 수 없을 때는 "0" 을 출력한다.
 * 데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력한다.
 */
public class Dog_Chick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int animalCount = scanner.nextInt();
        int legCount = scanner.nextInt();


        int dogCount = 0;
        int chickCount = 0;

        if(animalCount <= 1000 && animalCount > 0 && legCount <= 4000 && legCount > 0 ){
            for(int i = animalCount; i>0; i--){
                if (4 * i < legCount) {
                    for(int j = 1; j<i; j++){
                        if((4*i + 2*j) == legCount && i+j == animalCount){
                            dogCount = i;
                            chickCount = j;
                            System.out.printf("%d %d",dogCount,chickCount);
                            return;
                        }
                    }
                }
            }
        }else{
            System.out.println("INPUT ERROR!");
            return;
        }

        System.out.println(0);

    }
}
