package eventorganizer;

/**
 Location enum: Represents various university locations with building names and campuses
 @author Sreekruthi Dubagunta, Shatakshi Ranjan
 */
public enum Location {

    ARC103("Allison Road Classroom", "Busch"),
    HLL114("Hill Center", "Busch"),
    AB2225("Academic Building", "College Avenue"),
    MU302("Murray Hall", "College Avenue"),
    BE_AUD("Beck Hall", "Livingston"),
    TIL232("Tillett Hall", "Livingston");

    private String buildingName;
    private String campus;

    /**
     * Location constructor
     * @param buildingName of Location
     * @param campus of Location
     */
    private Location(String buildingName, String campus) {
        this.buildingName = buildingName;
        this.campus = campus;
    }

    /**
     * Method to get buildingName of Location
     * @return buildingName of Location
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Method to get campus of Location
     * @return campus of Location
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Method to get String representation of Location
     * @return String representation of Location
     */
    @Override
    public String toString() {
        return this.name() + " (" + buildingName + ", " + campus + ")";
    }
}

