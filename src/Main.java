import game.Controller;
//import game.NumberBaseballGame;

public class Main {
    public static void main(String[] args) {
        /* Level 1 */
        // 숫자 야구 게임 객체 생성
//        NumberBaseballGame game = new NumberBaseballGame();
//        game.play();    // 숫자 야구 게임 시작

        /* Level 2 */
        Controller gameController = new Controller();
        gameController.on();
    }
}