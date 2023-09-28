package eventorganizer;
import java.util.Scanner;
public class EventOrganizer {
    private EventCalendar calendar;
    private Scanner scanner;

    public EventOrganizer() {
        calendar = new EventCalendar();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Event Organizer running....");
        boolean isRunning = true;

        while (isRunning) {
            String commandLine = scanner.nextLine().trim();

            if (!commandLine.isEmpty()) {
                char command = commandLine.charAt(0);

                switch (command) {
                    case 'A':
                        // Process the "A" command for adding an event
                        // Parse the commandLine, create an Event object, and add it to the calendar
                        break;
                    case 'R':
                        // Process the "R" command for removing an event
                        // Parse the commandLine, create an Event object, and remove it from the calendar
                        break;
                    case 'P':
                        // Process various print commands: P, PE, PC, PD
                        // Based on the specific print command, call the appropriate method in EventCalendar
                        break;
                    case 'Q':
                        // Quit the program
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid command: " + command);
                        break;
                }
            }
        }

        System.out.println("Event Organizer terminated.");
        }

        public static void main(String[] args) {
            EventOrganizer organizer = new EventOrganizer();
            organizer.run();
        }
    }

}
