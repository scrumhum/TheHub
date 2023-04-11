import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String hostName;
    private String eventName;
    private String eventType;
    private String location;
    private String description;
    private double entryFee;
    private boolean allAges;
    private boolean volunteersWanted;
    private LocalDateTime dateTime;

    public Event(String hostName, String eventName, String eventType, String location, String description, double entryFee, boolean allAges, boolean volunteersWanted, LocalDateTime dateTime) {
        this.hostName = hostName;
        this.eventName = eventName;
        this.eventType = eventType;
        this.location = location;
        this.description = description;
        this.entryFee = entryFee;
        this.allAges = allAges;
        this.volunteersWanted = volunteersWanted;
        this.dateTime = dateTime;
    }

    public Event(String hostName, String eventName, String eventType, String location, String $25) {
    }

    public String generateEventInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mma");
        String formattedDate = this.dateTime.format(formatter);
        String allAgesString = this.allAges ? "All Ages" : "21+ Event";
        String volunteersWantedString = this.volunteersWanted ? "Yes" : "No";
        return this.eventName + " by " + this.hostName + ". Date " + formattedDate + ". Tickets $" + this.entryFee + ". " + allAgesString + ". Location - " + this.location + ". Volunteers Wanted - " + volunteersWantedString + ".";
    }
}
