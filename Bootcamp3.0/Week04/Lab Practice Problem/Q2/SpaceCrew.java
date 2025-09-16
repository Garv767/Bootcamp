import java.util.Random;

public class SpaceCrew {
    // Permanent attributes
    private final String crewId;
    private final String homeplanet;
    private final CrewRank initialRank;

    // Mutable attributes
    private CrewRank currentRank;
    private int skillLevel;
    private int missionCount;
    private double spaceHours;

    // Static station info
    public static final String STATION_NAME = "Stellar Odyssey";
    public static final int MAX_CREW_CAPACITY = 50;

    // Emergency recruitment (minimal info - generates random homeplanet)
    public SpaceCrew(String crewName) {
        this.crewId = "ID-" + crewName + "-" + System.currentTimeMillis();
        this.homeplanet = getRandomPlanet();
        this.initialRank = CrewRank.CADET;
        this.currentRank = CrewRank.CADET;
        this.skillLevel = 1;
        this.missionCount = 0;
        this.spaceHours = 0.0;
    }

    // Standard recruitment (name, homeplanet, rank)
    public SpaceCrew(String crewName, String homeplanet, CrewRank initialRank) {
        this.crewId = "ID-" + crewName + "-" + System.currentTimeMillis();
        this.homeplanet = homeplanet;
        this.initialRank = initialRank;
        this.currentRank = initialRank;
        this.skillLevel = 1;
        this.missionCount = 0;
        this.spaceHours = 0.0;
    }

    // Experienced transfer (includes previous mission count and skills)
    public SpaceCrew(String crewName, String homeplanet, CrewRank initialRank, int missionCount, int skillLevel) {
        this.crewId = "ID-" + crewName + "-" + System.currentTimeMillis();
        this.homeplanet = homeplanet;
        this.initialRank = initialRank;
        this.currentRank = initialRank;
        this.skillLevel = skillLevel;
        this.missionCount = missionCount;
        this.spaceHours = missionCount * 10.0;
    }

    // Full detailed profile constructor
    public SpaceCrew(String crewName, String homeplanet, CrewRank initialRank, CrewRank currentRank, int skillLevel, int missionCount, double spaceHours) {
        this.crewId = "ID-" + crewName + "-" + System.currentTimeMillis();
        this.homeplanet = homeplanet;
        this.initialRank = initialRank;
        this.currentRank = currentRank;
        this.skillLevel = skillLevel;
        this.missionCount = missionCount;
        this.spaceHours = spaceHours;
    }

    private String getRandomPlanet() {
        String[] planets = {"Earth", "Mars", "Venus", "Jupiter", "Saturn"};
        return planets[new Random().nextInt(planets.length)];
    }

    // Final methods
    public final String getCrewIdentification() {
        return crewId + " from " + homeplanet + " (Initial Rank: " + initialRank + ")";
    }

    public final boolean canBePromoted() {
        return currentRank.getLevel() < CrewRank.ADMIRAL.getLevel();
    }

    public final int calculateSpaceExperience() {
        return (int)(missionCount * skillLevel + spaceHours / 10);
    }

    // Getters and setters for mutable fields
    public CrewRank getCurrentRank() { return currentRank; }
    public void setCurrentRank(CrewRank rank) { this.currentRank = rank; }
    public int getSkillLevel() { return skillLevel; }
    public void setSkillLevel(int skillLevel) { this.skillLevel = skillLevel; }
    public int getMissionCount() { return missionCount; }
    public void setMissionCount(int missionCount) { this.missionCount = missionCount; }
    public double getSpaceHours() { return spaceHours; }
    public void setSpaceHours(double spaceHours) { this.spaceHours = spaceHours; }
    public String getCrewName() { return crewId.split("-")[1]; }
    public CrewRank getInitialRank() { return initialRank; }
    public String getHomeplanet() { return homeplanet; }
}