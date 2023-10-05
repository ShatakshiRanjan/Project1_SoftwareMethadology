package eventorganizer;

/**
 Event class: Represents an event with attributes such as date, start time, location, contact, and duration
 allows for comparison and equality checks based on date and time
 @author Sreekruthi Dubagunta, Shatakshi Ranjan
 */
public class Event implements Comparable<Event> {

    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    /**
     * Event constructor
     * @param date of Event
     * @param startTime of Event
     * @param location of Event
     * @param contact of Event
     * @param duration of Event
     */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        super();
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    /**
     * Event constructor
     * @param date of Event
     * @param startTime of Event
     * @param location of Event
     */
    public Event(Date date, Timeslot startTime, Location location) {
        super();
        this.date = date;
        this.startTime = startTime;
        this.location = location;
    }

    /**
     * Method to get date of Event
     * @return date of Event
     */
    public Date getDate() {
        return date;
    }

    /**
     * Method to get startTime of Event
     * @return startTime of Event
     */
    public Timeslot getStartTime() {
        return startTime;
    }

    /**
     * Method to get location of Event
     * @return location of Event
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Method to get contact of Event
     * @return contact of Event
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Method to get duration of Event
     * @return duration of Event
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Method to compare Event to other Event
     * @param o other Event
     * @return integer comparing Event and other Event
     */
    @Override
    public int compareTo(Event o) {
        if (date.compareTo(o.date) != 0)
            return date.compareTo(o.date);
        else
            return startTime.compareTo(o.startTime);
    }

    /**
     * Method to get if Event equals other Event
     * @return if Event equals other Event
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event o = (Event) obj;
        return compareTo(o) == 0 && location.compareTo(o.location) == 0;
    }

    /**
     * Method to get String representation of Event
     * @return String representation of Event
     */
    @Override
    public String toString() {
        return String.format("[Event Date: %s] [Start: %s] [End: %s] @%s [Contact: %s]",
                date, startTime, startTime.toString(duration), location, contact);
    }

    /**
     * Event class Testbed
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Event event1 = new Event(new Date(2023,10,21), Timeslot.AFTERNOON, Location.HLL114, new Contact(Department.CS, "cs@rutgers.edu"), 60);
        Event event2 = new Event(new Date(2023,10,21), Timeslot.MORNING, Location.HLL114, new Contact(Department.CS, "cs@rutgers.edu"), 60);
        Event event3 = new Event(new Date(2023,10,21), Timeslot.AFTERNOON, Location.ARC103, new Contact(Department.CS, "cs@rutgers.edu"), 60);
        Event event4 = new Event(new Date(2023,10,20), Timeslot.AFTERNOON, Location.HLL114, new Contact(Department.MATH, "math@rutgers.edu"), 60);
        Event event5 = new Event(new Date(2023,10,21), Timeslot.AFTERNOON, Location.HLL114, new Contact(Department.MATH, "math@rutgers.edu"), 60);
        boolean expectedOutput = false;
        System.out.println("Test Case #1: event1.equals(event2)" + ", Expected Output:" + expectedOutput + ", Actual Output:" +
                event1.equals(event2));

        expectedOutput = false;
        System.out.println("Test Case #2: event1.equals(event3)" + ", Expected Output:" + expectedOutput + ", Actual Output:" +
                event1.equals(event3));

        expectedOutput = false;
        System.out.println("Test Case #3: event1.equals(event4)" + ", Expected Output:" + expectedOutput + ", Actual Output:" +
                event1.equals(event4));;

        expectedOutput = true;
        System.out.println("Test Case #4: event1.equals(event5)" + ", Expected Output:" + expectedOutput + ", Actual Output:" +
                event1.equals(event5));
    }
}

