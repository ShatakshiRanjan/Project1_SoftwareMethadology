package eventorganizer;

public enum Department {
    CS("computer science"),
    EE("electrical engineering"),
    ITI("information technology and informatics"),
    MATH("mathematics"),
    BAIT("business analytics and information technology");

    private final String fullName;

    Department(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
/* public class Main {
    public static void main(String[] args) {
        Department cs = Department.CS;
        System.out.println("Department: " + cs);
        System.out.println("Full Name: " + cs.getFullName());
    }
}

 */

