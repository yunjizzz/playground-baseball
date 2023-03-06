package study;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    static String computer;

    public static void main(String[] args) {

        computer = makeUnique3NumberStrings();

        Scanner sc = new Scanner(new InputStreamReader(System.in));

        System.out.println("컴퓨터 숫자 " + computer);
        while(sc.hasNextLine()){
            String value = sc.nextLine();
            String result = playBaseBall(value);
            System.out.println("결과는요"+ result);
            if(result.equals("3스트라이크")){
                System.out.println("게임종료");
                break;
            }
        }
    }

    public static String playBaseBall(String userInput) {
        int ball = ballCheck(userInput);
        int strike = strikeCheck(userInput);

        return makeString(ball, strike);
    }


    public static String makeUnique3NumberStrings() {
        Set<String> set = new HashSet<>();
        while ( set.size() < 3){
            set.add(makeRandomNumber(1,9));
        }
        return String.join("", set);
    }

    public static String makeRandomNumber(int start, int end){
        return ((int)(Math.random() * end) + start) + "";
    }

    public static int strikeCheck(String userInput) {
        if (computer.equals(userInput)) {
            return 3;
        }
        int strike = 0;
        for (int i = 0; i < computer.length(); i++){
            strike += strikeCharEquals(userInput.charAt(i),computer.charAt(i));
        }
        return strike;
    }

    public static int strikeCharEquals(char userChar, char computerChar) {
        if (userChar == computerChar) {
            return 1;
        }
        return 0;
    }

    public static int ballCheck(String input) {
        int ball = 0;
        for (int i = 0; i < computer.length(); i++){
            ball += ballCharContains(input.charAt(i),computer.charAt(i));
        }
        return ball;
    }

    public static int ballCharContains(char userChar, char computerChar){
        if (userChar != computerChar && computer.contains(userChar + "")) {
               return 1;
        }
        return 0;
    }

    public static String makeString(int ball, int strike){
        String result = "";
        if (ball == 0 && strike == 0) {
            return "";
        }
        if (ball != 0) {
            result += ball+"볼";
        }
        if (strike != 0) {
            result += strike+"스트라이크";
        }
        return result;
    }
}
