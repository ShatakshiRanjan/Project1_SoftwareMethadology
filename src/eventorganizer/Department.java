package eventorganizer;

/**
 Department enum: Enumerates academic departments with their respective full names
 @author Sreekruthi Dubagunta, Shatakshi Ranjan
 */
public enum Department {

    BAIT("Business Analytics and Information Technology"),
    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI ("Information Technology and Informatics"),
    MATH("Mathematics");

    private String name;

    /**
     * Department constructor
     * @param name of Department
     */
    private Department(String name) {
        this.name = name;
    }

    /**
     * Method to get name of Department
     * @return name of Department
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get String representation of Department
     * @return String representation of Department
     */
    @Override
    public String toString() {
        return name;
    }
}
