package homework13;

import java.util.*;

public class StreamUtils {

    private StreamUtils() {}

    public static double average(Collection<Integer> collection) {
        int sum = collection.stream().mapToInt(i -> i).sum();
        return (double) sum / collection.size();
    }

    public static Map<String, String> toUpperCase(Collection<String> collection) {
        Map<String, String> map = new LinkedHashMap<>();
        collection.forEach(s -> map.put(s, s.toUpperCase()));
        return map;
    }

    public static void printShortAndLowerCase(Collection<String> collection) {
        collection.stream()
                .filter(s -> s.equals(s.toLowerCase()))
                .filter(s -> s.length() == 4)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("look");
        list.add("Look");
        list.add("LOOK");
        list.add("find");
        list.add("Find");
        list.add("FIND");
        list.add("search");
        list.add("Search");
        list.add("SEARCH");

        System.out.println("""
                Expected:
                look
                find
                """);
        System.out.println("Result:");
        printShortAndLowerCase(list);
    }
}
