package eventorganizer;

public class Contact {
    private Department department;
    private String email;
    public boolean isValid() {
        boolean valid = true;
        if ( EventOrganizer.department() != "HLL114" || "ARC103" || "BE_AUD" || "TIL232" || "AB2252" || "MU302" )
        {
            valid = false;
        }

    }

    public Department getDepartment(){
        return department;
    }

    public String getEmail(){
        return email;
    }


}
