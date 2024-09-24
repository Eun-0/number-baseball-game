package app;

import exception.input.InvalidInputException;
import exception.input.InvalidDuplicationException;
import exception.input.InvalidRangeException;
import exception.input.InvalidTypeException;

import java.util.LinkedHashSet;
import java.util.Set;

import java.util.Scanner;

public class Player {
    private Set<Integer> input = new LinkedHashSet<>();

    public void scanInput() throws InvalidInputException {
        input.clear();  // 초기화
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int num = validateInputType(input);
        validateInputRange(num);
        validateDuplication(num);
    }

    private int validateInputType(String inputStr) throws InvalidTypeException {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            throw new InvalidTypeException(inputStr);
        }
        return inputNumber;
    }

    private void validateInputRange(int inputInt) throws InvalidRangeException {
        if (inputInt < 0 || inputInt > 999) {
            throw new InvalidRangeException(inputInt);
        }
    }

    private void validateDuplication(int inputInt) throws InvalidDuplicationException {
        boolean duplicationFlag = false;
        int count = 3;
        int temp = inputInt;

        for (int i = 0; i < count; i++) {
            duplicationFlag = this.input.add( temp / (int)(Math.pow(10, count-1-i)) );
            if (!duplicationFlag) {
                throw new InvalidDuplicationException(inputInt);
            } else {
                temp %= (int) Math.pow(10, count-1-i);
            }
        }
//        System.out.println(this.input); // Parsing 잘 되었는지 확인
    }

    public Set<Integer> getInput() {
        return this.input;
    }
}
