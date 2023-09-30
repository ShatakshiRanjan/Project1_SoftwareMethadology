package eventorganizer;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;
public class EventOrganizer {
    Scanner input;
    EventCalendar newEventCalendar;

    //public static Event newEvent = new Event();

    public EventOrganizer() {
        this.input = new Scanner(System.in);
        this.newEventCalendar = new EventCalendar();

    }

    public void run() {
        System.out.println("Event Organizer running....");
        boolean isRunning = true;

        while (this.input.hasNext() && isRunning) {
            String commandLine = this.input.nextLine();
            if (commandLine.equals("Q")) {
                System.out.print("Event Organizer terminated");
                isRunning = false;
                break;
            }
            this.createEvent(commandLine);
        }
            this.input.close();

    }

    public void createEvent(String commandLine) {
        StringTokenizer userCommand = new StringTokenizer(commandLine, "");
        String[] locationList = new String[]{"HLL144", "ARC103", "BE_AUD", "TIL232", "AB2225", "MU302"};
        String[] departmentList = new String[]{"CS", "EE", "ITI", "MATH", "BAIT"};
        String[] timeSlotList = new String[]{"morning", "afternoon", "evening"};
        String command = userCommand.nextToken();
        String date;
        String timeSlot;
        String location;
        String department;
        String email;
        String duration;
        if(command.equals("A")) {
        //String inputs
            date = userCommand.nextToken();
            timeSlot = userCommand.nextToken().toLowerCase();
            location = userCommand.nextToken().toUpperCase();
            department = userCommand.nextToken().toUpperCase();
            email = userCommand.nextToken();
            duration = userCommand.nextToken();
        //Parsing inputs to right type
            Date d = new Date(date);
            Timeslot ts = Timeslot.valueOf(timeSlot);
            Location l = Location.valueOf(location);
            Department dep = Department.valueOf(department);
            Contact c = new Contact(dep, email);
            int dur = Integer.parseInt(duration);

        //    1. An event is not a valid calendar date. 2. An event date is not a future date. 3. An event date is more than 6 months away from today’s date.
            if(d.isValid() == false){
                System.out.println("" + date.toString() + ": Invalid calendar date!");
            }
            if(d.isBefore() == true){
                System.out.println("" + date.toString() + ": Event must be a future!");
            }
            if(d.is6Months() == true){
                System.out.println("" + date.toString() + ": Event date must be within 6 months!");
            }
        //    4. An invalid timeslot.
            boolean istimeSlot = false;
            for(int x = 0; x < timeSlotList.length; ++x) {
                if (timeSlotList[x].equals(timeSlot)) {
                    istimeSlot = true;
                }
            }
            if(istimeSlot == false)
            {
                System.out.println("Invalid time slot!");
            }
        //    5. A location that is not one of the six locations listed.
            boolean isLocation = false;
            for(int x = 0; x < timeSlotList.length; ++x) {
                if (locationList[x].equals(location)) {
                    isLocation = true;
                }
            }
            if(isLocation == false)
            {
                System.out.println("Invalid location!");
            }
        //    6. A department name that is not one of the five departments listed.
            boolean isDepartment = false;
            for(int x = 0; x < departmentList.length; ++x) {
                if (departmentList[x].equals(department)) {
                    isDepartment= true;
                }
            }
            if(isDepartment == false)
            {
                System.out.println("Invalid department!");
            }
        //    7. An invalid email address containing the wrong format or wrong domain name.
            if(c.isEmailValid(email) == false){
                System.out.println("Invalid contact information!");
            }
        //    8. Conflict of schedule - an event with the same date/timeslot/location is already on the calendar.
            Event newEvent = new Event(d, ts, l, c, dur);
            if(this.newEventCalendar.contains(newEvent)) {
                System.out.println("The event is already on the calendar.");
            }
            else {
                this.newEventCalendar.add(newEvent);
                System.out.println("Event added to the calendar.");
            }

        }
        else if (command.equals("R")) {
            date = userCommand.nextToken();
            timeSlot = userCommand.nextToken().toLowerCase();
            location = userCommand.nextToken().toUpperCase();
            Date rd = new Date(date);
            //    1. An event is not a valid calendar date. 2. An event date is not a future date. 3. An event date is more than 6 months away from today’s date.
            if(rd.isValid() == false){
                System.out.println("" + date.toString() + ": Invalid calendar date!");
            }
            if(rd.isBefore() == true){
                System.out.println("" + date.toString() + ": Event must be a future!");
            }
            if(rd.is6Months() == true){
                System.out.println("" + date.toString() + ": Event date must be within 6 months!");
            }
            Event newEvent = new Event(d)
            isValid = this.newEventCalender.remove(RMStudent);
            if (isValid) {
                System.out.println(RMProfile.toString() + "removed from the roster.");
            } else {
                System.out.println(RMProfile.toString() + " is not in the roster.");
            }

        }
        else if (userCommand.equals("P")) {
            if (this.newEventCalendar.getNumEvents() == 0) {
                System.out.println("Event calendar is empty!");
            } else {
                this.newEventCalendar.print();
            }
        } else if (userCommand.equals("PE")) {
            if (this.newEventCalendar.getNumEvents() == 0) {
                System.out.println("Event calendar is empty!");
            } else {
                this.newEventCalendar.printByDate();
            }
        } else if (userCommand.equals("PD")) {
            if (this.newEventCalendar.getNumEvents() == 0) {
                System.out.println("Event calendar is empty!");
            } else {
                this.newEventCalendar.printByCampus();
            }
        } else if (userCommand.equals("PC")) {
            if (this.newEventCalendar.getNumEvents() == 0) {
                System.out.println("Event calendar is empty!");
            } else {
                this.newEventCalendar.printByDepartment();
            }
        } else {
            if (userCommand.equals("Q")) {
                System.out.println("Event Organizer terminated.");
                return;
            }

            System.out.println(userCommand.toString() + " is an invalid command!");
        }
    }
}




