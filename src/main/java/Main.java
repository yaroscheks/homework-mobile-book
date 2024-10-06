public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        System.out.println("Добавлено контактов: " + phoneBook.add("A", "1"));
        System.out.println("Добавлено контактов: " + phoneBook.add("B", "2"));
        System.out.println("Добавлено контактов: " + phoneBook.add("A", "3"));

        System.out.println("Номер A: " + phoneBook.findByName("A"));
        System.out.println("Номер B: " + phoneBook.findByName("B"));
        System.out.println("Номер C: " + phoneBook.findByName("C"));

        System.out.println("Имя по номеру 1: " + phoneBook.findByNumber("1"));
        System.out.println("Имя по номеру 2: " + phoneBook.findByNumber("2"));
        System.out.println("Имя по номеру 3: " + phoneBook.findByNumber("3"));

        System.out.println("Все имена:");
        phoneBook.printAllNames();
    }
}
