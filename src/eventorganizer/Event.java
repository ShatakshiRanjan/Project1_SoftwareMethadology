package eventorganizer;

public class Event implements Comparable<Event>{
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    public static void main(String[] args){

    }

    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    public String toString(){
        return "[Event Date: " + dateToString(date)
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
