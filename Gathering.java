import java.sql.*;
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
        if (this.getUsername().equals(username) && this.getPassword().equals(password)) {
            currentUser = this;
        }
    }

    public void editProfile(String name, String email, String password) {
        currentUser.setName(name);
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

    public void loadEventsFromDatabase(String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, photo, description, location, time FROM events")) {
            while (rs.next()) {
                String name = rs.getString("name");
                String photo = rs.getString("photo");
                String description = rs.getString("description");
                String location = rs.getString("location");
                String time = rs.getString("time");
                Event event = new Event(name, photo, description, location, time);
                currentUser.addEvent(event);
            }
        } catch (SQLException e) {
            System.out.println("Error loading events from database: " + e.getMessage());
        }
    }

    public void pushEventsToCalendar(Calendar calendar) {
        for (Event event : currentUser.getEvents()) {
            calendar.addEvent(event);
        }
    }
}
