import java.util.ArrayList;
import java.util.List;

    public class GatheringManager extends User {
        private User currentUser;
        private List<Gathering> gatherings;

        public GatheringManager(String username, String password, String name, String email) {
            super(username, password, name, email);
            gatherings = new ArrayList<>();
        }

        public void login(String username, String password) {
            if (this.getUserName().equals(username) && this.getPassword().equals(password)) {
                currentUser = this;
            }
        }

        public void editProfile(String name, String email, String password) {
            currentUser.setFirstName(name);
            currentUser.setEmail(email);
            currentUser.setPassword(password);
        }

        public void addEventFromLink(String link) {
            Event event = EventParser.parseFromLink(link);
            if (event != null) {
                currentUser.addEvent(event);
            }
        }

        public void createEvent(String name, String photo, String description, String location, String time) {
            Event event = new Event(name, photo, description, location, time);
            currentUser.addEvent(event);
        }

        public void addGathering(Gathering gathering) {
            gatherings.add(gathering);
        }

        public void removeGathering(Gathering gathering) {
            gatherings.remove(gathering);
        }

        public List<Gathering> getGatherings() {
            return gatherings;
        }

        public void setGatherings(List<Gathering> gatherings) {
            this.gatherings = gatherings;
        }
    }
//