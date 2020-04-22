package homework16;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RockPaperScissorsGame {

    /*
     * По вертикали и горизонтали последовательно расположены Камень, Бумага и Ножницы - от начальной ячейки к крайним
     * Выбор игрока расположен по горизонтали (номер строки)
     * Выбор компьютера расположен по вертикали (номер столбца)
     * Значения ячейки:
     *  1 - победа игрока
     * -1 - победа компьютера
     *  0 - ничья
     */
    private static final int[][] resultMatrix = {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0}
    };
    private static final Map<Integer, String> stateNames;

    static {
        stateNames = new HashMap<>();
        stateNames.put(1, "Rock");
        stateNames.put(2, "Paper");
        stateNames.put(3, "Scissors");
    }

    private final Scanner scanner;
    private FileWriter fileWriter;

    public RockPaperScissorsGame() {
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    //    Метод, начинающий игру
    public void play() throws IOException {

        File file = new File("maven\\src\\main\\java\\homework16\\plays_history.txt");
        fileWriter = new FileWriter(file, true);
        FileReader fileReader = new FileReader(file);

//        Проверка существует ли файл или пуст ли он. Если да, вставляется заголовочная строка
        if (!file.exists() || fileReader.read() == -1) {
            fileWriter.append("\tPlays History").append("\n".repeat(4));
            fileReader.close();
        }

//        Время начала игры
        fileWriter
                .append(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()))
                .append("\n".repeat(2));


        System.out.println("\nWelcome to the Rock-Paper-Scissors game!");

        int matchesNumber;

//        Валидация ввода целого положительного числа
        do {
            System.out.println("\nEnter number of matches");
            if (handleInvalidInput(false) == 0) {
                continue;
            }
            matchesNumber = scanner.nextInt();
            if (!validateInputGreaterThanValue(matchesNumber, 0)) {
                continue;
            }
            break;
        } while (true);

        fileWriter.append("Matches: ").append(Integer.toString(matchesNumber)).append("\n");

        System.out.println("\nThe game is about to start!");
        System.out.println("Enter 1, 2 or 3 to make a choice");
        System.out.println("Type \"Quit\" to end the game\n");
        sleep(1500);

        int playerScore = 0;
        int opponentScore = 0;

//        Проведение заданного количества раундов
        for (int i = 0; i < matchesNumber; i++) {
            int playerChoice;
            int opponentChoice;

            System.out.println("\nRound " + (i + 1));
            fileWriter.append(Integer.toString(i + 1)).append(". ");

//            Валидация ввода целого числа от 1 до 3 с учётом ввода строки "Quit"
            do {
                System.out.println("\nMake a choice");
                System.out.println("1. Rock");
                System.out.println("2. Paper");
                System.out.println("3. Scissors\n");

                int handleInputResult = handleInvalidInput(true);

                if (handleInputResult == 0) {
                    continue;
                }
                if (handleInputResult == -1) {
                    System.out.println("\n-------------------------------------------------");
                    System.out.println("\nEND GAME");
                    fileWriter.append("Quit").append("\n".repeat(4));
                    fileWriter.close();
                    return;
                }

                playerChoice = scanner.nextInt();
                if (!validateInputGreaterThanValue(playerChoice, 0) || !validateInputLessThanValue(playerChoice, 4)) {
                    continue;
                }
                break;
            } while (true);

            System.out.println("\nYou chose " + stateNames.get(playerChoice));
            sleep(1000);
            System.out.print("Your opponent chose ");
            sleep(1000);
            opponentChoice = (int) (Math.random() * 3 + 1);
            System.out.println(stateNames.get(opponentChoice));

            int matchResult = resultMatrix[playerChoice - 1][opponentChoice - 1];

            if (matchResult == 1) {
                playerScore++;
            } else if (matchResult == -1) {
                opponentScore++;
            }
            sleep(500);
            System.out.println("\n" + playerScore + ":" + opponentScore);
            sleep(750);
            System.out.println("\n-------------------------------------------------");
            fileWriter
                    .append(Integer.toString(playerScore))
                    .append(":")
                    .append(Integer.toString(opponentScore))
                    .append(" (")
                    .append(stateNames.get(playerChoice))
                    .append(" - ")
                    .append(stateNames.get(opponentChoice))
                    .append(")\n");
        }

        System.out.println(getResult(playerScore, opponentScore));

        fileWriter.close();
        scanner.close();
    }


    /*
     * Проверяет пользовательский ввод на принадлежность к числовому типу
     * Если quitCheck == false, возвращает 1 в случае пройденной валидации, иначе 0
     * Если quitCheck == true, работает аналогично, но возвращает -1, если пользователь ввёл "quit" (без учёта регистра)
     */
    private int handleInvalidInput(boolean quitCheck) {
        boolean isValid;
        if (!scanner.hasNextInt()) {
            String input = scanner.next();
            if (quitCheck && "quit".equals(input.toLowerCase())) {
                return -1;
            }
            System.err.println("Incorrect input: not an integer value");
            isValid = false;
        } else {
            isValid = true;
        }
        return isValid ? 1 : 0;
    }

    //    Осуществляет валидацию воода числа, большего, чем value
    private boolean validateInputGreaterThanValue(int input, int value) {
        if (input > value) {
            return true;
        }
        System.err.println("Incorrect input: must be greater than " + value);
        return false;
    }

    //    Осуществляет валидацию воода числа, меньшего, чем value
    private boolean validateInputLessThanValue(int input, int value) {
        if (input < value) {
            return true;
        }
        System.err.println("Incorrect input: must be less than " + value);
        return false;
    }

    //    Реализует задержку в милисекундах
    private void sleep(long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    Возвращает итоги матча готовой строкой и записывает данные в файл в зависимости от счёта игроков
    private String getResult(int playerScore, int opponentScore) throws IOException {
        StringBuilder result = new StringBuilder("\n");

        if (playerScore > opponentScore) {
            result.append("YOU WIN!");
            fileWriter.append("You won");
        } else if (playerScore < opponentScore) {
            result.append("YOU LOST");
            fileWriter.append("You lost");
        } else {
            result.append("DRAW");
            fileWriter.append("Draw");
        }
        fileWriter.append("\n".repeat(4));


        return result.toString();
    }
}
