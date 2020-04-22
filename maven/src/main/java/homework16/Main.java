package homework16;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        try {
            game.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
