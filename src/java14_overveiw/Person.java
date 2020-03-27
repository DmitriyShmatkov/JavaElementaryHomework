package java14_overveiw;

import java.util.Arrays;

public record Person(String name, int age) {

    public static final String SQL_GET_PERSON_INFO = """
            SELECT * FROM person
            WHERE name = 'Sam'
            AND age > 20
            """;

    public static void main(String[] args) {

        Person namelessPerson = new Person(null, 25);
        boolean isSam = Arrays.equals(namelessPerson.name().toCharArray(), "Sam".toCharArray());

        if (isSam) {
            System.out.println("Sam");
        } else {
            System.out.println("Not Sam");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person person) {
            return person.name().equals(this.name) && person.age() == this.age;
        }
        return false;
    }
}
