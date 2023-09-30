package eventorganizer;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;
public class EventOrganizer {

    Scanner input;
    Event newEvent;

    public EventOrganizer() {
       this.input = new Scanner(System.in);
       this.newEvent = new Event();
    }

    public void run() {
        System.out.println("Event Organizer running....\n");
        boolean isRunning = false;

        while (this.input.hasNext() && !isRunning) {
            String commandLine = this.input.nextLine();
            if (commandLine.equals("Q")) {
                System.out.print("Event Manager terminated");
                isRunning = true;
                break;
            }

            this.assignValues(commandLine);
        }

        this.input.close();
    }

    public void assignValues(String inputString) {
        StringTokenizer s = new StringTokenizer(inputString, " ");
        String[] deptList = new String[]{"CS", "EE", "ITI", "BAIT", "MATH"};
        String command = s.nextToken();
        Date date;
        Timeslot startTime;
        Location location;
        Contact contact;
        int duration;
        boolean isValid;
        if (command.equals("A")) {
            date = s.nextToken();
            startTime = s.nextToken();
            date = s.nextToken();
            newMajor = st.nextToken().toUpperCase();
            int credits = Integer.parseInt(st.nextToken());
            Date d = new Date(dob);
            isValid = d.isValid();
            Profile thisStudent = new Profile(lastName, schoolName, d);
            int age = thisStudent.getAge();
            boolean containsMajor = false;

            for(int i = 0; i < dept.length; ++i) {
                if (majorList[i].equals(newMajor)) {
                    containsMajor = true;
                }
            }

            if (age > 16) {
                if (isValid) {
                    if (containsMajor) {
                        Major studentMajorEnum = Major.valueOf(newMajor);
                        if (credits >= 0) {
                            Student newStudent = new Student(thisStudent, studentMajorEnum, credits);
                            if (!this.newRoster.contains(newStudent)) {
                                this.newRoster.add(newStudent);
                                System.out.println(thisStudent.toString() + " added to the roster.");
                            } else {
                                System.out.println(thisStudent.toString() + " is already in the roster.");
                            }
                        } else {
                            System.out.println("Credits completed invalid: cannot be negative!");
                        }
                    } else {
                        System.out.println("Major code invalid:" + newMajor.toString());
                    }
                } else {
                    System.out.println("DOB invalid: " + dob.toString() + " not a valid calendar date!");
                }
            } else {
                System.out.println("DOB invalid: " + dob.toString() + " is younger than 16 years old.");
            }
        } else if (action.equals("R")) {
            schoolName = st.nextToken();
            lastName = st.nextToken();
            dob = st.nextToken();
            Date RMDate = new Date(dob);
            Profile RMProfile = new Profile(lastName, schoolName, RMDate);
            Student RMStudent = this.newRoster.ProfileToStudent(RMProfile);
            isValid = this.newRoster.remove(RMStudent);
            if (isValid) {
                System.out.println(RMProfile.toString() + "removed from the roster.");
            } else {
                System.out.println(RMProfile.toString() + " is not in the roster.");
            }
        } else if (action.equals("P")) {
            if (this.newRoster.getSize() == 0) {
                System.out.println("Student roster is empty");
            } else {
                this.newRoster.print();
            }
        } else if (action.equals("PS")) {
            if (this.newRoster.getSize() == 0) {
                System.out.println("Student roster is empty!");
            } else {
                this.newRoster.printByStanding();
            }
        } else if (action.equals("PC")) {
            if (this.newRoster.getSize() == 0) {
                System.out.println("Student roster is empty!");
            } else {
                this.newRoster.printBySchoolMajor();
            }
        } else if (action.equals("L")) {
            if (this.newRoster.getSize() == 0) {
                System.out.println("Student roster is empty!");
            } else {
                schoolName = st.nextToken().toUpperCase();
                this.newRoster.printBySchool(schoolName);
            }
        } else if (action.equals("C")) {
            schoolName = st.nextToken();
            lastName = st.nextToken();
            dob = st.nextToken();
            newMajor = st.nextToken();
            Date CDate = new Date(dob);
            Profile CProfile = new Profile(lastName, schoolName, CDate);
            Major MajorEnum = Major.valueOf(newMajor);
            boolean isChanged = this.newRoster.ChangeMajor(CProfile, MajorEnum);
            if (isChanged) {
                PrintStream var10000 = System.out;
                String var10001 = CProfile.toString();
                var10000.println(var10001 + " major changed to " + newMajor.toString());
            } else {
                System.out.println("Student not found");
            }
        } else {
            if (action.equals("Q")) {
                System.out.println("Roster Manager terminated.");
                return;
            }

            System.out.println(action.toString() + " is an invalid command!");
        }

    }
}
