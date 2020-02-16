package homework2;

import java.util.List;

public class Average {

    private Average() {
    }

    public static double getAverage(double a, double b) {
        return (a + b) / 2;
    }

    public static double getAverage(List<Double> numbers) {

        if (numbers == null) {
            throw new NullPointerException();
        }
        if (numbers.size() == 0) {
            throw new IllegalArgumentException("List is empty");
        }
        if (numbers.size() == 1) {
            throw new IllegalArgumentException("List contains only 1 number");
        }

        double sum = 0;
        for (Double num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }
}
