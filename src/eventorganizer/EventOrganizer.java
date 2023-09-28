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
                String command = commandLine.substring(0,2);

                if (command.equals("A")) {
                    EventCalendar.add();
                } else if (command.equals("R")) {
                    EventCalendar.remove();
                } else if (command.equals("P")) {
                    // Process various print commands: P, PE, PC, PD
                    // Based on the specific print command, call the appropriate method in EventCalendar
                } else if (command.equals("Q")) {
                    // Quit the program
                    isRunning = false;
                } else {
                    System.out.println(command + " is an invalid command!");
                }

                /*switch (command) {
                    case 'A ':
                        EventCalendar.add();
                        break;
                    case 'R ':
                        EventCalendar.remove();
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
                        System.out.println(command + "is an invalid command!");
                        break;
                }

                 */
            }
        }

        System.out.println("Event Organizer terminated.");
        }
/*
        public static void main(String[] args) {
            EventOrganizer organizer = new EventOrganizer();
            organizer.run();
        }
    }

 */

}
