package eventorganizer;

/**
 Contact class: Stores contact information including department and email for event organizers
 @author Sreekruthi Dubagunta, Shatakshi Ranjan
 */
public class Contact {

    private Department department;
    private String email;

    /**
     * Contact constructor
     * @param department of eventorganizer.Contact
     * @param email of eventorganizer.Contact
     */
    public Contact(Department department, String email) {
        super();
        this.department = department;
        this.email = email;
    }

    /**
     * Method to get department of Contact
     * @return department of Contact
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Method to get email of Contact
     * @return email of Contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to return if Contact is valid
     * @return if Contact is valid
     */
    public boolean isValid() {
        return department != null && email != null && email.contains("@") && email.split("@").length == 2 && email.split("@")[1].equals("rutgers.edu");
    }

    /**
     * Method to get String representation of Contact
     * @return String representation of Contact
     */
    @Override
    public String toString() {
        return department + ", " + email;
    }

}

