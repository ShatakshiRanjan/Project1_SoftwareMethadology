package eventorganizer;

/**
 EventCalendar class: Manages a collection of events - allowing addition, removal, and retrieval operations
 @author Sreekruthi Dubagunta, Shatakshi Ranjan
 */
public class EventCalendar {

    private Event[] events;
    private int numEvents;

    private static final int INITIAL_SIZE = 4;
    private static final int GROW_SIZE = 4;

    private static final int NOT_FOUND = -1;

    /**
     * EventCalendar Constructor;
     */
    public EventCalendar() {
        events = new Event[INITIAL_SIZE];
        numEvents = 0;
    }

    /**
     * Method to get number of events in EventCalendar
     * @return number of events in EventCalendar
     */
    public int getNumEvents() {
        return numEvents;
    }

    /**
     * Method to find Event in EventCalendar
     * @param event in EventCalendar
     * @return index of Event in EventCalendar if found, else -1
     */
    private int find(Event event) {
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event))
                return i;
        }
        return NOT_FOUND;
    }

    /**
     * Method to grow array in EventCalendar
     */
    private void grow() {
        Event[] events2 = new Event[events.length + GROW_SIZE];
        for (int i = 0; i < events.length; i++)
            events2[i] = events[i];
        events = events2;
    }

    /**
     * Method to add Event to EventCalendar
     * @param event to add to EventCalendar
     * @return if Event added to EventCalendar
     */
    public boolean add(Event event) {
        if (contains(event))
            return false;
        if (numEvents == events.length)
            grow();
        events[numEvents++] = event;
        return true;
    }

    /**
     * Method to remove Event from EventCalendar
     * @param event to remove from EventCalendar
     * @return if Event removed from EventCalendar
     */
    public boolean remove(Event event) {
        if (!contains(event))
            return false;
        int index = find(event);
        for (int i = index; i < events.length - 1; i++)
            events[i] = events[i + 1];
        events[events.length - 1] = null;
        numEvents--;
        return true;
    }

    /**
     * Method to get if EventCalendar contains Event
     * @param event to check in EventCalendar
     * @return if EventCalendar contains Event
     */
    public boolean contains(Event event) {
        return find(event) != NOT_FOUND;
    }

    /**
     * Method to print Events in EventCalendar
     */
    public void print() {
        for (int i = 0; i < numEvents; i++)
            System.out.println(events[i]);
    }

    /**
     * Method to print Events in EventCalendar ordered by Date
     */
    public void printByDate() {
        for (int i = 0; i < numEvents; i++) {
            for (int j = 0; j < numEvents - 1; j++) {
                if (events[j].compareTo(events[j + 1]) > 0) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
        print();
    }

    /**
     * Method to print Events in EventCalendar ordered by Campus
     */
    public void printByCampus() {
        for (int i = 0; i < numEvents; i++) {
            for (int j = 0; j < numEvents - 1; j++) {
                if (events[j].getLocation().compareTo(events[j + 1].getLocation()) > 0) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
        print();
    }

    /**
     * Method to print Events in EventCalendar ordered by Department
     */
    public void printByDepartment() {
        for (int i = 0; i < numEvents; i++) {
            for (int j = 0; j < numEvents - 1; j++) {
                if (events[j].getContact().getDepartment().compareTo(events[j + 1].getContact().getDepartment()) > 0) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
        print();
    }
}
