package game.numberBaseballGame;

import exception.input.InvalidInputException;
import display.Display;
import player.Player;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import java.util.Random;

public class NumberBaseballGame {
    /* Field */

    // 정답 숫자 //
    // 중복을 허용하지 않고, 요소의 삽입 순서를 유지해야 함 -> LinkedHashSet
    // 자릿수만큼 초기 용량 설정
    private Set<Integer> answer = new LinkedHashSet<>(3);

    // 힌트 //
    private int strikeCount;
    private int ballCount;

    /* Constructor */
    // 게임 객체 생성 시, 정답 숫자 생성
    public NumberBaseballGame() {
        // 정답 숫자를 담는 객체 생성
        Random randomNumber = new Random();

        // 난수 생성 및 저장
        int randomCount = 3;    // 자릿수만큼 난수 생성; initalCapacity와 동일한 값을 갖습니다.
        boolean flag = false;
        do {
            flag = this.answer.add(randomNumber.nextInt(10));
            if (flag) {
                randomCount--;
            }
        } while(randomCount > 0);
    }


    /* Method */
    // 게임 실행 메서드 //
    public void play(){
        Display display = new Display();
        display.displayStartGame();

        Player player = new Player();
//        display.displayAnswer(this.answer); // 생성된 정답 확인
        while (true) {
            try {
                display.displayGameProgress();
                player.scanInput();
                compareAnswerWithInput(this.getAnswer(), player.getInput());

//                display.displayResult(this.getStrikeCount(), this.getBallCount());  // 입력값 확인
                if (this.getStrikeCount() == 3) {
                    break;
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    // 정답 확인 메서드 //
    private void compareAnswerWithInput(Set<Integer> answer, Set<Integer> input) {
        this.strikeCount = 0;
        this.ballCount = 0;

        Iterator<Integer> answerIterator = answer.iterator();
        Iterator<Integer> inputIterator = input.iterator();

        while (answerIterator.hasNext() && inputIterator.hasNext()) {
            Integer answerValue = answerIterator.next();
            Integer inputValue = inputIterator.next();

            if (answerValue.equals(inputValue)) {
                this.strikeCount++;
            } else if (answer.contains(inputValue)) {
                this.ballCount++;
            }
        }

    }

    // Getters //
    public Set<Integer> getAnswer() {
        return this.answer;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }


}
