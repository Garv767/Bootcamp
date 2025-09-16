public class EngineerCrew extends SpaceCrew {
    private final String engineeringCertification; // Permanent specialization

    public EngineerCrew(String crewName, String homeplanet, CrewRank initialRank, String certification) {
        super(crewName, homeplanet, initialRank);
        this.engineeringCertification = certification;
    }

    public String getEngineeringCertification() {
        return engineeringCertification;
    }

    // Task-specific method that uses the final attribute
    public void repairPropulsionSystem() {
        if ("Propulsion Systems".equals(this.engineeringCertification)) {
            System.out.println(getCrewName() + " is uniquely qualified and now repairing the propulsion system.");
        } else {
            System.out.println(getCrewName() + " is an engineer but lacks the required propulsion certification for this task.");
        }
    }
}
