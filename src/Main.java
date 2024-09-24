import game.numberBaseballGame.NumberBaseballGame;
import game.numberBaseballGame.NumberBaseballGame_Lv2;

public class Main {
    public static void main(String[] args) {
        /* 숫자 야구 게임 객체 생성 */
//        NumberBaseballGame game = new NumberBaseballGame();
        NumberBaseballGame_Lv2 game = new NumberBaseballGame_Lv2();

        game.play();    // 숫자 야구 게임 시작
    }
}