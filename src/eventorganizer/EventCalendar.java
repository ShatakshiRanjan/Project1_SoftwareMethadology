package eventorganizer;

public class EventCalendar {
    private Event [] events; //the array holding the list of events


    private int numEvents; //current number of events in the array

    public int getNumEvents() {
        return numEvents;
    }

    public EventCalendar() {
        this.events = this.events;
        this.numEvents = this.numEvents;
    }

    public EventCalendar(Event[] e, int num) {
        this.events = e;
        this.numEvents = num;
}

    private int find(Event event) {
        int NOT_FOUND = -1;
        for(int i=0; i < this.numEvents; ++i){
            if(this.events[i].equals(event)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        Event[] newEvents = new Event[events.length + 4];
        if(this.events != null){
            for(int i = 0; i < this.numEvents; i++){
                newEvents[i] = this.events[i];
            }
        }
        this.events = newEvents;
    }

    public boolean add(Event event) {
        if(this.events == null){
            this.grow();
        }
        if(this.events.length - 1 == this.numEvents){
            this.grow();
        }
        this.events[this.numEvents] = event;
        ++this.numEvents;
        return true;
    }

    public boolean remove(Event event) {
        for(int i = 0; i <= this.numEvents - 1; ++i){
            if(this.events[i].equals(event)) {
                this.events[i] = null;

                for(int j = i; j < this.numEvents - 1; ++j) {
                    this.events[j] = this.events[j+1];
                }
                this.events[this.numEvents-1] = null;
                --this.numEvents;
                return true;
            }
        }
        return false;
    }
    public boolean contains(Event event) {
        for(int i=0; i<this.numEvents - 1; ++i){
            if(this.find(numEvents) != -1){
                return true;
            }
        }
        return false;

    }

    public void print() {
        int i;
        for(i = 0; i < this.numEvents; ++i){
            int min = i;

            for(int j = 1+i; j<this.numEvents; ++j) {
                if(this.events[j].compareTo(this.events[min]) == -1) {
                    min = j;
                }
            }
            Event temp = this.events[min];
            this.events[min] = this.events[i];
            this.events[i] = temp;
        }

        for(i=0; i<this.numEvents; ++i){
            System.out.println(this.events[i]);
        }
    }

    public void printByDate() { } //ordered by date and timeslot
    public void printByCampus() { } //ordered by campus and building/room
    public void printByDepartment(){ } //ordered by department
}
