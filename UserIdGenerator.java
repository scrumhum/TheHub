import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserIdGenerator {
    private final static Set<Integer> usedIds = new HashSet<>();
    private static int nextId = 1;

    public static int generateUserId() {
        while (usedIds.contains(nextId)) {
            nextId++;
        }
        usedIds.add(nextId);
        return nextId;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        int userId = generateUserId();
        System.out.println("Hello " + name + ", your user ID is: " + userId);
    }
}