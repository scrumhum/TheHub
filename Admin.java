import java.util.ArrayList;
import java.util.List;

public class Admin {

    public Admin() {

    }
    List events = new ArrayList();
    List venues = new ArrayList();

    public void createEvent(Event event) {
        events.add(event);
    }

    public void deleteEvent(Event event) {
        events.remove(event);
    }

    public void createVenue(Venue venue) {
        venues.add(venue);
    }

    public void deleteVenue(Venue venue) {
        venues.remove(venue);
    }
}
