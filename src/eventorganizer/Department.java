package eventorganizer;

public enum Department {
    CS("computer science"),
    EE("electrical engineering"),
    ITI("information technology and informatics"),
    MATH("mathematics"),
    BAIT("business analytics and information technology");

    private final String fullName;

    private Department(String fullName) {
        this.fullName = fullName;
    }

    String getFullName() {
        return fullName;
    }
}


