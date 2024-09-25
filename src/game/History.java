package game;

import exception.history.InvalidHistoryException;
import exception.input.player.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Integer> gameHistory = new ArrayList<>();

    public void recordTrial (int trial) {
        this.gameHistory.add(trial);
    }

    public List<Integer> getHistory () {
        if (this.gameHistory.isEmpty()) {
            try {
                throw new InvalidHistoryException("아직 게임 시작 전입니다.");
            } catch (InvalidHistoryException e) {
                System.out.println(e.getMessage());
            }
        }
        return this.gameHistory;
    }
}
