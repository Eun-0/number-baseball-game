package exception.input;

public class InvalidDuplicationException extends InvalidInputException {
    public InvalidDuplicationException(int input) {
        super("입력된 '" + input + "'은 중복된 숫자가 존재하므로, 유효한 입력값이 아닙니다.");
    }
}
