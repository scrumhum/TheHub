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
