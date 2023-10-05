package eventorganizer;

/**
 Timeslot enum: Defines specific time slots with associated hours and minutes
 @author Sreekruthi Dubagunta, Shatakshi Ranjan
 */
public enum Timeslot {

    MORNING(10,30),
    AFTERNOON (14,00),
    EVENING(18,30);

    private int hours;
    private int minutes;

    private static final int NOON = 12;
    private static final int MINUTES_PER_HOUR = 60;


    /**
     * Timeslot constructor
     * @param hours of Timeslot
     * @param minutes of Timeslot
     */
    private Timeslot(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    /**
     * Method to get hours of Timeslot
     * @return hours of Timeslot
     */
    public int getHours() {
        return hours;
    }

    /**
     * Method to get minutes of Timeslot
     * @return minutes of Timeslot
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Method to get String representation of Timeslot
     * @return String representation of Timeslot
     */
    @Override
    public String toString() {
        if (hours < NOON)
            return String.format("%d:%02dam", hours, minutes);
        else if (hours == NOON)
            return String.format("%d:%02dpm", hours, minutes);
        else
            return String.format("%d:%02dpm", hours - 12, minutes);
    }

    /**
     * Method to get String representation of Timeslot with duration
     * @param duration of Timeslot
     * @return String representation of Timeslot with duration
     */
    public String toString(int duration) {
        int time = hours * MINUTES_PER_HOUR + minutes + duration;
        int endHours = time / MINUTES_PER_HOUR;
        int endMinutes = time - endHours * MINUTES_PER_HOUR;
        if (endHours < NOON)
            return String.format("%d:%02dam", endHours, endMinutes);
        else if (endHours == NOON)
            return String.format("%d:%02dpm", endHours, endMinutes);
        else
            return String.format("%d:%02dpm", endHours - 12, endMinutes);
    }


}