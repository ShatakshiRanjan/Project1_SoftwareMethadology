package eventorganizer;

import java.util.Scanner;

/**
 EventOrganizer class: Facilitates the management of events through command-line interactions
 @author Sreekruthi Dubagunta, Shatakshi Ranjan
 */
public class EventOrganizer {

    /**
     * Method to run EventOrganizer
     */
    public void run() {
        System.out.println("Event Organizer running...");
        Scanner keyboard = new Scanner(System.in);
        EventCalendar eventCalendar = new EventCalendar();
        boolean quit = false;
        while (!quit) {
            String[] commands = keyboard.nextLine().split("\n");
            for (String command: commands) {
                command = command.strip();
                if (command.equals("Q")) {
                    quit = true;
                    break;
                } else if (!command.isEmpty()) {
                    processCommand(eventCalendar, command);
                }
            }
        }
        keyboard.close();
        System.out.println("Event Organizer terminated.");
    }

    /**
     * Method to process command in EventOrganizer
     * @param eventCalendar of events
     * @param command to process
     */
    public void processCommand(EventCalendar eventCalendar, String command) {
        String[] params = command.split("\\s+");
        if (params[0].equals("A") && params.length == 7) {
            String dateString = params[1];
            String startTimeString = params[2].toUpperCase();
            String locationString = params[3].toUpperCase();
            String departmentString = params[4].toUpperCase();
            String email = params[5];
            String durationString = params[6];
            processAddCommand(eventCalendar, dateString, startTimeString,
                    locationString, departmentString, email, durationString);
        } else if (params[0].equals("R") && params.length == 4) {
            String dateString = params[1];
            String startTimeString = params[2].toUpperCase();
            String locationString = params[3].toUpperCase();
            processRemoveCommand(eventCalendar, dateString, startTimeString,
                    locationString);
        } else if (params[0].equals("P") && params.length == 1) {
            if (eventCalendar.getNumEvents() == 0) {
                System.out.println("Event calendar is empty!");
                return;
            }
            System.out.println("* Event calendar *");
            eventCalendar.print();
            System.out.println("* end of event calendar *");
        } else if (params[0].equals("PE") && params.length == 1) {
            if (eventCalendar.getNumEvents() == 0) {
                System.out.println("Event calendar is empty!");
                return;
            }
            System.out.println("* Event calendar by event date and start time *");
            eventCalendar.printByDate();
            System.out.println("* end of event calendar *");
        } else if (params[0].equals("PC") && params.length == 1) {
            if (eventCalendar.getNumEvents() == 0) {
                System.out.println("Event calendar is empty!");
                return;
            }
            System.out.println("* Event calendar by campus and building *");
            eventCalendar.printByCampus();
            System.out.println("* end of event calendar *");
        } else if (params[0].equals("PD") && params.length == 1) {
            if (eventCalendar.getNumEvents() == 0) {
                System.out.println("Event calendar is empty!");
                return;
            }
            System.out.println("* Event calendar by department *");
            eventCalendar.printByDepartment();
            System.out.println("* end of event calendar *");
        } else {
            System.out.println(command + " is an invalid command!");
        }
    }

    /**
     * Method to process add command in EventOrganizer
     * @param eventCalendar maintaining Events
     * @param dateString of Event
     * @param startTimeString of Event
     * @param locationString of Event
     * @param departmentString of Event
     * @param email of Event
     * @param durationString of Event
     */
    public void processAddCommand(EventCalendar eventCalendar, String dateString,
                                  String startTimeString, String locationString, String departmentString,
                                  String email, String durationString) {
        String[] dateParams = dateString.split("/");
        Date date = null;
        try {
            date = new Date(Integer.parseInt(dateParams[2]),
                    Integer.parseInt(dateParams[0]), Integer.parseInt(dateParams[1]));
            if (!date.isValid()) {
                System.out.println(date + ": Invalid calendar date!");
                return;
            }
            if (!date.isFuture()) {
                System.out.println(date + ": Event date must be a future date!");
                return;
            }
            if (!date.isWithin6Months()) {
                System.out.println(date + ": Event date must be within 6 months!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println(dateString + ": Invalid calendar date!");
            return;
        }
        Timeslot startTime = null;
        try {
            startTime = Timeslot.valueOf(startTimeString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid time slot!");
            return;
        }
        Location location = null;
        try {
            location = Location.valueOf(locationString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid location!");
            return;
        }
        Department department = null;
        try {
            department = Department.valueOf(departmentString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid contact information!");
            return;
        }
        Contact contact = new Contact(department, email);
        if (!contact.isValid()) {
            System.out.println("Invalid contact information!");
            return;
        }
        int duration = 0;
        try {
            duration = Integer.parseInt(durationString);
            if (duration < 30 || duration > 120) {
                System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
            return;
        }
        Event event = new Event(date, startTime, location, contact, duration);
        if (eventCalendar.add(event))
            System.out.println("Event added to the calendar.");
        else
            System.out.println("The event is already on the calendar.");
    }

    /**
     * Method to process remove command in EventOrganizer
     * @param eventCalendar maintaining Events
     * @param dateString of Event
     * @param startTimeString of Event
     * @param locationString of Event
     */
    public void processRemoveCommand(EventCalendar eventCalendar, String dateString,
                                     String startTimeString, String locationString) {
        String[] dateParams = dateString.split("/");
        Date date = null;
        try {
            date = new Date(Integer.parseInt(dateParams[2]),
                    Integer.parseInt(dateParams[0]), Integer.parseInt(dateParams[1]));
            if (!date.isValid()) {
                System.out.println(date + ": Invalid calendar date!");
                return;
            }
            if (!date.isFuture()) {
                System.out.println(date + ": Event date must be a future date!");
                return;
            }
            if (!date.isWithin6Months()) {
                System.out.println(date + ": Event date must be within 6 months!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println(dateString + ": Invalid calendar date!");
            return;
        }
        Timeslot startTime = null;
        try {
            startTime = Timeslot.valueOf(startTimeString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid time slot!");
            return;
        }
        Location location = null;
        try {
            location = Location.valueOf(locationString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid location!");
            return;
        }
        Event event = new Event(date, startTime, location);
        if (eventCalendar.remove(event))
            System.out.println("Event has been removed from the calendar!");
        else
            System.out.println("Cannot remove; event is not in the calendar!");
    }
}

