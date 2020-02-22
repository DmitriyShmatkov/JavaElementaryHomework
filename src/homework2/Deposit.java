package homework2;

import auxiliary.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Deposit {

    private Deposit() {}

    public static void calculate(Money money, BigDecimal percent, int years) {
        percent = percent.divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
        for (int i = 0; i < years; i++) {
            Money income = money.multiply(percent.doubleValue());
            money = money.add(income);
            System.out.println("Year " + (i + 1) + ": +" + income + ", money: " + money);
        }
        System.out.println();
    }
}
