package app;

import exception.input.player.InvalidInputException;
import exception.input.player.InvalidDuplicationException;
import exception.input.player.InvalidRangeException;
import exception.input.player.InvalidTypeException;

import java.util.LinkedHashSet;
import java.util.Set;

import java.util.Scanner;

public class Player {
    private Set<Integer> input = new LinkedHashSet<>();

    public void scanInput() throws InvalidInputException {
        input.clear();  // 초기화
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        parsingInput(input);
    }

    private void parsingInput(String inputStr) throws InvalidInputException {
        try {
            int inputNum = Integer.parseInt(inputStr);  // 숫자만으로 이루어져있는가

            if (inputNum < 111 || inputNum > 999) {     // 세자릿수 체크
                throw new InvalidRangeException(inputStr);
            }

            boolean duplicationFlag = false;            // 중복 여부 확인
            int count = 3;                              // 자릿수
            int temp = 0;

            for (int i = 0; i < count; i++) {
                temp = inputNum / (int)(Math.pow(10, count-1-i));
                if (temp == 0) {                        // 1 ~ 9 자연수
                    throw new InvalidRangeException(inputStr);
                }
                duplicationFlag = this.input.add(temp);
//                duplicationFlag = this.input.add( inputNum / (int)(Math.pow(10, count-1-i)) );
                if (!duplicationFlag) {                 // 중복 비 허용
                    throw new InvalidDuplicationException(inputStr);
                } else {
                    inputNum %= (int) Math.pow(10, count-1-i);
                }
            }
        } catch (NumberFormatException e) {
            throw new InvalidTypeException(inputStr);
        }
    }

    public Set<Integer> getInput() {
        return this.input;
    }
}
