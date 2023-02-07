public class Main {
    public static void main(String[] args) {

        User person = new User();
        User.profileCreate(person);
        System.out.println(person.getEmail());
    }
}
