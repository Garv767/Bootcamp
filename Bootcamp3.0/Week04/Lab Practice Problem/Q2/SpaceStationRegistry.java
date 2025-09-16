import java.util.ArrayList;
import java.util.List;

public final class SpaceStationRegistry {
    private static final List<SpaceCrew> activeCrew = new ArrayList<>();

    public static void recruitCrew(SpaceCrew crew) {
        if (activeCrew.size() < SpaceCrew.MAX_CREW_CAPACITY) {
            activeCrew.add(crew);
            System.out.println("Recruited: " + crew.getCrewIdentification());
        } else {
            System.out.println("Station at full capacity!");
        }
    }

    public static void handleEmergency(String emergencyType) {
        System.out.println("\n--- Emergency Alert: " + emergencyType + " ---");
        System.out.println("Dispatching special teams based on fixed skills:");

        boolean dispatched = false;
        for (SpaceCrew crew : activeCrew) {
            if (emergencyType.equals("Propulsion Failure") && crew instanceof EngineerCrew) {
                EngineerCrew engineer = (EngineerCrew) crew;
                if ("Propulsion Systems".equals(engineer.getEngineeringCertification())) {
                    System.out.println("Engaging irreplaceable engineer " + engineer.getCrewName() + " with " + engineer.getEngineeringCertification() + " certification.");
                    engineer.repairPropulsionSystem();
                    dispatched = true;
                    break;
                }
            } else if (emergencyType.equals("Flight Emergency") && crew instanceof PilotCrew) {
                PilotCrew pilot = (PilotCrew) crew;
                System.out.println("Dispatching pilot " + pilot.getCrewName() + " with " + pilot.getFlightCertification() + " certification.");
                pilot.pilotShuttle();
                dispatched = true;
                break;
            } else if (emergencyType.equals("Science Crisis") && crew instanceof ScienceCrew) {
                ScienceCrew scientist = (ScienceCrew) crew;
                System.out.println("Dispatching scientist " + scientist.getCrewName() + " specialized in " + scientist.getResearchSpecialization());
                scientist.conductExperiment();
                dispatched = true;
                break;
            }
        }
        if (!dispatched) {
            System.out.println("No irreplaceable crew found for this emergency. Protocol Omega initiated.");
        }
    }

    public static void displayCrewStats() {
        System.out.println("\n--- Crew Statistics ---");
        System.out.println("Total Crew: " + activeCrew.size());
        for (SpaceCrew crew : activeCrew) {
            System.out.println(crew.getCrewIdentification() + " | Missions: " + crew.getMissionCount() + " | Experience: " + crew.calculateSpaceExperience());
        }
    }

    public static void main(String[] args) {
        // Emergency recruitment
        SpaceCrew recruit1 = new SpaceCrew("Alex");
        recruitCrew(recruit1);

        // Standard recruitment
        SpaceCrew recruit2 = new SpaceCrew("Sam", "Venus", CrewRank.OFFICER);
        recruitCrew(recruit2);

        // Experienced transfer
        SpaceCrew recruit3 = new SpaceCrew("Mira", "Jupiter", CrewRank.COMMANDER, 12, 5);
        recruitCrew(recruit3);

        // Full profile
        SpaceCrew recruit4 = new SpaceCrew("Lee", "Saturn", CrewRank.CAPTAIN, CrewRank.CAPTAIN, 7, 20, 200.0);
        recruitCrew(recruit4);

        // Specialized crew
        PilotCrew pilot = new PilotCrew("Rick", "Earth", CrewRank.CAPTAIN, "Interstellar Shuttle");
        recruitCrew(pilot);

        ScienceCrew scientist = new ScienceCrew("Nina", "Mars", CrewRank.OFFICER, "Astrobiology");
        recruitCrew(scientist);

        EngineerCrew irreplaceableEngineer = new EngineerCrew("Zoe", "Mars", CrewRank.COMMANDER, "Propulsion Systems");
        recruitCrew(irreplaceableEngineer);

        EngineerCrew standardEngineer = new EngineerCrew("Bob", "Earth", CrewRank.OFFICER, "General Maintenance");
        recruitCrew(standardEngineer);

        // Display stats
        displayCrewStats();

        // Emergency scenarios
        handleEmergency("Propulsion Failure");
        handleEmergency("Flight Emergency");
        handleEmergency("Science Crisis");
        handleEmergency("Quantum Singularity");
    }
}
