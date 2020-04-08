package homework15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DigitDrawer {

    private static final Map<Character, ArrayList<String>> lines = new HashMap<>();
    private static final int DIGIT_HEIGHT = 12;

    private DigitDrawer() {}

    static {
        lines.put('0', new ArrayList<>(Arrays.asList(
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@"
        )));
        lines.put('1', new ArrayList<>(Arrays.asList(
                "        @@@@@@",
                "      @@@@@@@@",
                "    @@@@@@@@@@",
                "  @@@@@@@@@@@@",
                "@@@@@@@ @@@@@@",
                "        @@@@@@",
                "        @@@@@@",
                "        @@@@@@",
                "        @@@@@@",
                "        @@@@@@",
                "        @@@@@@",
                "        @@@@@@"
        )));
        lines.put('2', new ArrayList<>(Arrays.asList(
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@                ",
                "@@@@@@                ",
                "@@@@@@                ",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@"
        )));
        lines.put('3', new ArrayList<>(Arrays.asList(
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@"
        )));
        lines.put('4', new ArrayList<>(Arrays.asList(
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "                @@@@@@"
        )));
        lines.put('5', new ArrayList<>(Arrays.asList(
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@                ",
                "@@@@@@                ",
                "@@@@@@                ",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@"
        )));
        lines.put('6', new ArrayList<>(Arrays.asList(
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@                ",
                "@@@@@@                ",
                "@@@@@@                ",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@"
        )));
        lines.put('7', new ArrayList<>(Arrays.asList(
                "@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@",
                "              @@@@@@",
                "             @@@@@@ ",
                "            @@@@@@  ",
                "           @@@@@@   ",
                "          @@@@@@    ",
                "         @@@@@@     ",
                "        @@@@@@      ",
                "       @@@@@@       ",
                "      @@@@@@        ",
                "     @@@@@@         "
        )));
        lines.put('8', new ArrayList<>(Arrays.asList(
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@"
        )));
        lines.put('9', new ArrayList<>(Arrays.asList(
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@          @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "                @@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@",
                "@@@@@@@@@@@@@@@@@@@@@@"
        )));
    }

    public static String draw(String digits) {
        if (!checkAllDigits(digits)) {
            throw new IllegalArgumentException("Input string must contain only digits");
        }
        StringBuilder representation = new StringBuilder();
        for (int i = 0; i < DIGIT_HEIGHT; i++) {
            representation.append(getLine(digits, i));
        }
        return representation.toString();
    }

    private static boolean checkAllDigits(String string) {
        for (char character : string.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    private static StringBuilder getLine(String digits, int lineIndex) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            line
                    .append(lines.get(digits.charAt(i))
                            .get(lineIndex))
                    .append("\t\t");
        }
        return line.append("\n");
    }

    public static void main(String[] args) {
        String digits = "32768";
        System.out.println("\n\n" + draw(digits));
    }
}
