package game;

import app.Display;
import exception.input.controller.InvalidControllerException;

import java.util.Scanner;

public class Controller {
    public void on() {
        boolean status = true;
        Display display = new Display();
        History gameHistory = new History();

        while (status) {
            display.printController();

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    display.printStartGame();
                    /* Level 1에서 구현한 기본 숫자 야구 게임 */
                    NumberBaseballGame game = new NumberBaseballGame();
                    int trial = game.play();
                    gameHistory.recordTrial(trial);
                    break;
                case "2":
//                    System.out.println("현재 구현하지 않습니다.");
                    display.printHistory(gameHistory.getHistory());
                    break;
                case "3":
                    display.printEndGame();
                    status = false;
                    break;
                default:
                    InvalidControllerException e = new InvalidControllerException("올바른 옵션이 아닙니다.");
                    System.out.println(e.getMessage());
            }
        }
    }
}
