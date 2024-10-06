import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PhoneBook {

    private final Map<String, String> contacts = new HashMap<>();

    public int add(String name, String number) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, number);
        }
        return contacts.size();
    }

    public String findByNumber(String number) {
        return contacts.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(number))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public String findByName(String name) {
        return contacts.get(name);
    }

    public void printAllNames() {
        new TreeSet<>(contacts.keySet())
                .forEach(System.out::println);
    }
}
