package eventorganizer;

public class Event implements Comparable<Event>{
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    public Event() {
        this.date = this.date;
        this.startTime = this.startTime;
        this.location = this.location;
        this.contact = this.contact;
        this.duration = this.duration;
    }
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    public Event(Date date, Timslot startTime, Location location)
    {

    }

    public Date getDate() { return this.date; }
    public Timeslot getStartTime() {
        return startTime;
    }
    public Location getLocation() {
        return location;
    }

    public Contact getContact() {
        return contact;
    }
    public int getDuration() {
        return duration;
    }


    @Override
    public int compareTo(Event other) {
        int dateComparison = this.date.compareTo(other.date);
        if (dateComparison != 0) {
            return dateComparison;
        }
        return this.startTime.compareTo(other.startTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return date.equals(event.date) &&
                startTime.equals(event.startTime) &&
                location.equals(event.location);
    }

    @Override
    public String toString() {
        return String.format("[Event Date: %s] [Start: %s] [End: %s] @%s (%s, %s) [Contact: %s, %s]",
                date.toString(),
                startTime.toString(),
                startTime.plusMinutes(duration).toString(),
                location.getAcronym(),
                location.getBuilding(),
                location.getCampus(),
                contact.getDepartment().getAcronym(),
                contact.getEmail()
        );
    }
}
