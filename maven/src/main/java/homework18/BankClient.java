package homework18;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class BankClient implements Runnable {
    private int id;
    private int balance;
}
