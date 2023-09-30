package eventorganizer;

public class Contact {
    private Department department;
    private String email;
    public boolean isValid() {
        boolean valid = true;
        if ( department == Department.CS || department == Department.EE || department == Department.ITI ||
                department == Department.MATH || department == Department.BAIT)
        {
            valid = false;
        }

        String emailPattern = "^[A-Za-z0-9._%+-]+@rutgers\\.edu$";
        if (email.matches(emailPattern) != true) {
            valid = false;
        }
        // Use the matches() method to check if the email matches the pattern
        return valid;
    }

    public Department getDepartment(){
        return department;
    }

    public String getEmail(){
        return email;
    }

    public Contact(){

    }


    public static void main(String[] args){

    }


}
