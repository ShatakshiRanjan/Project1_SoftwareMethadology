package eventorganizer;

public enum Timeslot {
    MORNING("10", "30"),
    AFTERNOON("02", "00"),
    EVENING("06", "30");

    private final String hours;
    private final String minutes;

    Timeslot(String hours, String minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getHours() {
        return hours;
    }

    public String getMinutes() {
        return minutes;
    }
}
