package homework18;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class BankTerminal {

    private int cashAmount;

    public void performTransaction(BankClient client) {
        Scanner scanner = ScannerSingleton.getInstance();
        int transactionType;
        int transactionSum;

        chooseTransactionType:
        do {
            System.out.println("""
                                     
                    Чтобы вернуться к выбору клиента, введите "Назад"
                    Выберите операцию
                    1. Пополнить счёт
                    2. Снять деньги со счёта
                    """);

            if (scanner.hasNextInt()) {
                transactionType = scanner.nextInt();
                if (transactionType == 1 || transactionType == 2) {
                    System.out.println("\nОперация: " + (transactionType == 1 ? "пополнение счёта" : "снятие наличных"));

                    do {
                        System.out.println("""
                                Чтобы вернуться к выбору операции, введите "Назад"
                                Введите денежную сумму
                                """);
                        if (scanner.hasNextInt()) {
                            transactionSum = scanner.nextInt();
                            if (transactionSum > 0) {
                                break;
                            }
                            System.err.println("\nПожалуйста, введите целое положительное число или команду \"Назад\"\n");
                            continue;
                        }
                        if ("назад".equals(scanner.next().toLowerCase())) {
                            continue chooseTransactionType;
                        }
                        System.err.println("\nПожалуйста, введите целое положительное число или команду \"Назад\"\n");
                    } while (true);

                    switch (transactionType) {
                        case 1 -> replenish(client, transactionSum);
                        case 2 -> withdraw(client, transactionSum);
                    }
                    return;
                }
                System.err.println("Пожалуйста, введите 1, 2 или команду \"Назад\"");
                continue;
            }
            if ("назад".equals(scanner.next().toLowerCase())) {
                return;
            }
            System.err.println("Пожалуйста, введите 1, 2 или команду \"Назад\"");
        } while (true);
    }

    public void replenish(BankClient client, int sum) {
        System.out.println("\nОперация: пополнение счёта");
        System.out.println("Сумма: " + sum);
        printStats(this, client);

        client.setBalance(client.getBalance() + sum);
        cashAmount += sum;

        System.out.println("\nТранзакция прошла успешно");
        printStats(this, client);
    }

    public void withdraw(BankClient client, int sum) {
        System.out.println("\nОперация: снятие наличных");
        System.out.println("Сумма: " + sum);
        printStats(this, client);

        if (sum > client.getBalance()) {
            System.err.println("\nОтмена транзации: недостаточно средств на счёте");
            return;
        }
        if (sum > cashAmount) {
            System.err.println("\nОтмена транзации: в банкомате недостаточно средств");
            return;
        }

        client.setBalance(client.getBalance() - sum);
        cashAmount -= sum;

        System.out.println("\nТранзакция прошла успешно");
        printStats(this, client);
    }

    private void printStats(BankTerminal terminal, BankClient client) {
        System.out.println("\nСредства банкомата: " + terminal.cashAmount);
        System.out.println("Ваш баланс: " + client.getBalance());
    }
}
