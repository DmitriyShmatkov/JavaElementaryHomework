package homework2;

public class Deposit {

    private Deposit() {}

    public static void calculate(double money, double percent, int years) {
        percent /= 100;
        System.out.println();
        for (int i = 0; i < years; i++) {
            double income = money * percent;
            money += income;
            System.out.println("Year " + (i + 1) + ": +" + income + ", money: " + money);
        }
        System.out.println();
    }
}
