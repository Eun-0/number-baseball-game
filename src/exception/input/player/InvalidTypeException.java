package exception.input.player;

public class InvalidTypeException extends InvalidInputException {
    public InvalidTypeException(String input) {
        super("입력된 '" + input + "'은 숫자만으로 구성된 입력이 아니므로, 유효한 입력 형식이 아닙니다.");
    }
}
