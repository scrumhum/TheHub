import java.util.ArrayList;

public class Calendar {
    // Array to hold events for each day of the month
    private ArrayList<Event>[] eventsByDay;

    // Constructor to initialize the calendar with the given number of days in the month
    public Calendar(int numDays) {
        // Create an ArrayList for each day of the month
        eventsByDay = new ArrayList[numDays];
        for (int i = 0; i < numDays; i++) {
            eventsByDay[i] = new ArrayList<Event>();
        }
    }

    // Method to add an event to the calendar for a given day
    public void addEvent(Event event, int day) {
        // Make sure the day is within the bounds of the calendar
        if (day < 1 || day > eventsByDay.length) {
            System.out.println("Invalid day: " + day);
            return;
        }
        // Add the event to the ArrayList for the given day
        eventsByDay[day - 1].add(event);
    }

    // Method to print out the events for a given day
    public void getEventsForDay(int day) {
        // Make sure the day is within the bounds of the calendar
        if (day < 1 || day > eventsByDay.length) {
            System.out.println("Invalid day: " + day);
            return;
        }
        // Print out the events for the given day
        System.out.println("Events for day " + day + ":");
        for (Event event : eventsByDay[day - 1]) {
            System.out.println(event.toString());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a calendar with 30 days (for example)
        Calendar calendar = new Calendar(30);

        // Add some events to the calendar for various days
        Event event1 = new Event("POP SICK DANCE PARTY by KikiPlanet.Productions",
                "Louies Sports Bar, Blue Lake CA", "April 22, 2023 9pm-2am",
                "21+ event", "$25");
        calendar.addEvent(event1, 22);

        Event event2 = new Event("Poetry Slam", "The Goat, Arcata CA",
                "May 14, 2023 7pm-9pm", "Poetry", "Free");
        calendar.addEvent(event2, 14);

        Event event3 = new Event("Gourmet Food Truck Festival", "Redwood Park, Arcata CA",
                "May 30, 2023 11am-7pm", "Food", "$10");
        calendar.addEvent(event3, 30);

        // Print out the events for a specific day
        calendar.getEventsForDay(22);
    }
}
