public class ScienceCrew extends SpaceCrew {
    private final String researchSpecialization;

    public ScienceCrew(String crewName, String homeplanet, CrewRank initialRank, String specialization) {
        super(crewName, homeplanet, initialRank);
        this.researchSpecialization = specialization;
    }

    public String getResearchSpecialization() {
        return researchSpecialization;
    }

    public void conductExperiment() {
        System.out.println(getCrewName() + " is conducting research in: " + researchSpecialization);
    }
}