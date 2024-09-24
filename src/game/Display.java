package game;

import java.util.Set;

public class Display {
    public void displayResult(int strikeCount, int ballCount){
        if (strikeCount == 3) {
            System.out.println("정답입니다!");
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("아웃");
        } else {
            System.out.println(strikeCount + "스트라이크 " + ballCount +"볼");
        }
    }

    public void displayStartGame() {
        System.out.println("숫자 야구 게임 시작!");
    }

    public void displayGameProgress() {
        System.out.print("숫자를 입력하세요: ");
    }

    public void displayAnswer(Set<Integer> answer) {
        System.out.println(answer);
    }
}
