package eventorganizer;

public class EventCalendar {
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    private int find(Event event) {
        for (int i = 0; i < Event.length(); i++) {
          if(Event[i].equals(event));

    } //search an event in the list
    private void grow() {
        Event[] newEvents = new Event[events.length + 4];
        for(int i = 0; i < numEvents; i++){
            newEvents[i] = events[i];
        }
        events = newEvents;
    } //increase the capacity by 4
    public boolean add(Event event) {
        if (numEvents == events.length) grow();
    }
    public boolean remove(Event event) {
        int index = find()
    }
    public boolean contains(Event event) { }
    public void print() { } //print the array as is
    public void printByDate() { } //ordered by date and timeslot
    public void printByCampus() { } //ordered by campus and building/room
    public void printByDepartment(){ } //ordered by department
}
