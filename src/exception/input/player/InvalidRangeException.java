package exception.input.player;

public class InvalidRangeException extends InvalidInputException {
    public InvalidRangeException(String input) {
        super("입력된 '" + input + "'은 유효한 입력 범위가 아닙니다.");
    }
}
