public class PilotCrew extends SpaceCrew {
    private final String flightCertification;

    public PilotCrew(String crewName, String homeplanet, CrewRank initialRank, String flightCertification) {
        super(crewName, homeplanet, initialRank);
        this.flightCertification = flightCertification;
    }

    public String getFlightCertification() {
        return flightCertification;
    }

    public void pilotShuttle() {
        System.out.println(getCrewName() + " is piloting with certification: " + flightCertification);
    }
}