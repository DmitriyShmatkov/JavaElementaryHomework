package homework19;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BankTerminal terminal = new BankTerminal(50_000);

        BankClient client1 = new BankClient(1, 5000) {
            @Override
            public void run() {
                System.out.println("\nКлиент №1 -> " + getBalance());
                terminal.performTransaction(this);
            }
        };
        BankClient client2 = new BankClient(1, 2500) {
            @Override
            public void run() {
                System.out.println("\nКлиент №2 -> " + getBalance());
                terminal.performTransaction(this);
            }
        };
        BankClient client3 = new BankClient(1, 10000) {
            @Override
            public void run() {
                System.out.println("\nКлиент №3 -> " + getBalance());
                terminal.performTransaction(this);
            }
        };

        int i;
        Thread thread;
        Scanner scanner = ScannerSingleton.getInstance();
        do {

            System.out.println("\nВыберите клиента для транзакции или введите \"Завершить работу\" для закрытия сессии с терминалом:\n" +
                    "1. Клиент №1 -> " + client1.getBalance() + "\n" +
                    "2. Клиент №2 -> " + client2.getBalance() + "\n" +
                    "3. Клиент №3 -> " + client3.getBalance() + "\n");

            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                switch (i) {
                    case 1 -> thread = new Thread(client1);
                    case 2 -> thread = new Thread(client2);
                    case 3 -> thread = new Thread(client3);
                    default -> {
                        System.err.println("Пожалуйсте, введите 1, 2, 3 либо команду \"Завершить работу\"");
                        continue;
                    }
                }
                thread.start();
                try {
                    thread.join();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            if ("завершить работу".equals(scanner.next().toLowerCase())) {
                break;
            }
            System.err.println("Пожалуйсте, введите 1, 2, 3 либо команду \"Завершить работу\"");
        } while (true);
    }
}
