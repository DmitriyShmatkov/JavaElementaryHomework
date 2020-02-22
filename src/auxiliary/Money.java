package auxiliary;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    BigDecimal money;

    public Money(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Negative amount of money");
        }
        this.money = BigDecimal.valueOf(money);
    }

    public Money(BigDecimal money) {
        if (money.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new IllegalArgumentException("Negative amount of money");
        }
        this.money = money;
    }

    public double getMoney() {
        return money.doubleValue();
    }

    public BigDecimal getBigDecimalMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Negative amount of money");
        }
        this.money = BigDecimal.valueOf(money);
    }

    public void setMoney(BigDecimal money) {
        if (money.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new IllegalArgumentException("Negative amount of money");
        }
        this.money = money;
    }

    public Money add(Money money) {
        return new Money(this.money.add(money.getBigDecimalMoney()));
    }

    public Money add(double money) {
        return add(new Money(money));
    }

    public Money subtract(Money money) {
        return new Money(this.money.subtract(money.getBigDecimalMoney()));
    }

    public Money subtract(double money) {
        return subtract(new Money(money));
    }

    public Money multiply(double multiplier) {
        return new Money(money.multiply(BigDecimal.valueOf(multiplier)));
    }

    public Money divide(double divisor) {
        return new Money(money.divide(BigDecimal.valueOf(divisor), RoundingMode.HALF_UP));
    }

    @Override
    public String toString() {
        return BigDecimal.valueOf(this.getMoney()).setScale(2, RoundingMode.HALF_UP).toString();
    }
}
