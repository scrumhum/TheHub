    import jdk.jfr.Event;
    import java.util.ArrayList;
    import java.util.Scanner;

    public class Admin {
        private ArrayList<User> users;
        private ArrayList<Event> events;
        private ArrayList<ForumPost> posts;
        private String username;
        private String password;

        public Admin(String username, String password) {
            this.username = username;
            this.password = password;
            this.users = new ArrayList<>();
            this.events = new ArrayList<>();
            this.posts = new ArrayList<>();
        }

        public boolean login(String username, String password) {
            if (this.username.equals(username) && this.password.equals(password)) {
                return true;
            }
            return false;
        }

        public void approveUser(User user) {
            user.setApproved(true);
            System.out.println("User " + user.getUserName()+ " has been approved.");
        }

        public void approveEvent(Event event) {
            event.setApproved(true);
            System.out.println("Event " + event.getName() + " has been approved.");
        }
// have to import event from database
        public void approvePost(ForumPost post) {
            post.setApproved(true);
            System.out.println("Post " + post.getTitle() + " has been approved.");
        }

        public void deleteUser(User user) {
            users.remove(user);
            System.out.println("User " + user.getUserName() + " has been deleted.");
        }

        public void addEvent(Event event) {
            events.add(event);
            System.out.println("Event " + event.getName() + " has been added.");
        }

        public void deleteEvent(Event event) {
            events.remove(event);
            System.out.println("Event " + event.getName() + " has been deleted.");
        }

        public void deletePost(ForumPost post) {
            posts.remove(post);
            System.out.println("Post " + post.getTitle() + " has been deleted.");
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter username:");
            String username = sc.nextLine();
            System.out.println("Enter password:");
            String password = sc.nextLine();

            Admin admin = new Admin("admin", "password");
            if (admin.login(username, password)) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Login failed.");
            }
        }
    }


// getName needs to be linked to our database of events
// ForumPost & getTitle setApproved will be linked to forum class( maybe create an inner class for ForumPost within Admin class)