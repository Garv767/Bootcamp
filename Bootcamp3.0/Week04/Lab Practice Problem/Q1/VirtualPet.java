import java.util.Random;
import java.util.UUID; // Used for generating unique pet IDs

public class VirtualPet {

    // --- a. Fields ---
    private final String petId; // final keyword: value cannot be changed after initialization
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private int evolutionStageIndex; // To track the pet's stage
    private boolean isGhost = false;

    // static final keyword: constant shared by all objects
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0; // static variable: shared among all pets

    // --- b. Implement evolution-based constructors (with this() chaining) ---

    // Default constructor: Creates a mysterious egg with random species
    public VirtualPet() {
        this("Mysterious Egg", generateRandomSpecies());
        this.age = 0;
        this.evolutionStageIndex = 0;
    }

    // Constructor with name only: Pet starts as baby stage
    public VirtualPet(String petName) {
        this(petName, generateRandomSpecies(), 1, 50, 70, 1);
    }

    // Constructor with name and species: Pet starts as child stage
    public VirtualPet(String petName, String species) {
        this(petName, species, 3, 60, 80, 2);
    }

    // Full constructor: Specify all initial stats and stage
    public VirtualPet(String petName, String species, int age, int happiness, int health, int evolutionStageIndex) {
        this.petId = generatePetId(); // final field initialized in constructor
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStageIndex = evolutionStageIndex;

        // Increment static counter every time a pet is created
        totalPetsCreated++;
    }

    // --- c. Use this() chaining where all constructors eventually call the main constructor ---
    // (This was already done above)

    // --- d. Create unique methods ---

    // Method to generate a unique ID using UUID
    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    // Helper method to generate a random species
    private static String generateRandomSpecies() {
        String[] speciesOptions = {"Dragon", "Phoenix", "Unicorn", "Griffin"};
        return speciesOptions[new Random().nextInt(speciesOptions.length)];
    }

    // Method to evolve the pet based on age and care
    public void evolvePet() {
        if (isGhost) return; // Ghosts cannot evolve

        int currentStageIndex = evolutionStageIndex;
        if (age >= 20 && currentStageIndex < 5) {
            evolutionStageIndex = 5; // Elder
        } else if (age >= 12 && currentStageIndex < 4) {
            evolutionStageIndex = 4; // Adult
        } else if (age >= 8 && currentStageIndex < 3) {
            evolutionStageIndex = 3; // Teen
        } else if (age >= 4 && currentStageIndex < 2) {
            evolutionStageIndex = 2; // Child
        } else if (age >= 1 && currentStageIndex < 1) {
            evolutionStageIndex = 1; // Baby
        }

        if (evolutionStageIndex > currentStageIndex) {
            System.out.println(petName + " has evolved into a " + EVOLUTION_STAGES[evolutionStageIndex] + "!");
        }
    }

    // Affect stats by feeding
    public void feedPet() {
        if (isGhost) {
            hauntOtherPets("feed");
            return;
        }
        health = Math.min(100, health + 10);
        System.out.println(petName + " enjoys a meal. Health is now " + health + ".");
    }

    // Affect stats by playing
    public void playWithPet() {
        if (isGhost) {
            hauntOtherPets("play");
            return;
        }
        happiness = Math.min(100, happiness + 15);
        health = Math.max(0, health - 5); // Playing is tiring
        System.out.println(petName + " had a blast! Happiness is now " + happiness + ", health is " + health + ".");
    }

    // Affect stats by healing
    public void healPet() {
        if (isGhost) {
            hauntOtherPets("heal");
            return;
        }
        health = Math.min(100, health + 20);
        happiness = Math.max(0, happiness - 5); // Pets don't love medicine
        System.out.println(petName + " feels a little better. Health is now " + health + ".");
    }

    // Simulate the passage of a day
    public void simulateDay() {
        if (isGhost) return;

        age++;
        int randomChange = new Random().nextInt(10) - 5; // A number between -5 and 4
        happiness += randomChange;
        health += randomChange;

        // Clamp stats to a valid range [0, 100]
        happiness = Math.max(0, Math.min(100, happiness));
        health = Math.max(0, Math.min(100, health));

        System.out.println("--- " + petName + "'s Day " + age + " ---");
        System.out.println("Stats after a day: Happiness=" + happiness + ", Health=" + health);

        checkStatus();
        evolvePet();
    }

    // Check if pet becomes a ghost
    private void checkStatus() {
        if (health <= 0 && !isGhost) {
            isGhost = true;
            happiness = 0;
            System.out.println(petName + " health reached 0. They have become a Ghost!");
        }
    }

    // Handle haunting behavior
    private void hauntOtherPets(String action) {
        System.out.println(petName + " the Ghost tries to join in the " + action + ", but just fazes through the other pets!");
    }
    
    // Get the current evolution stage
    public String getPetStatus() {
        if (isGhost) {
            return "Ghost";
        }
        return EVOLUTION_STAGES[evolutionStageIndex];
    }

    // Provide a comprehensive status report
    public String getFullStatus() {
        if (isGhost) {
            return "ID: " + petId + ", Name: " + petName + ", Species: " + species + ", Status: Ghost";
        }
        return "ID: " + petId + ", Name: " + petName + ", Species: " + species +
                ", Age: " + age + ", Stage: " + getPetStatus() +
                ", Happiness: " + happiness + ", Health: " + health;
    }

    // --- f. main method ---
    public static void main(String[] args) {
        System.out.println("Welcome to the Virtual Pet Daycare!");

        // Create a pet daycare with multiple pets
        VirtualPet pet1 = new VirtualPet("Sparky"); // Name only constructor -> Baby
        VirtualPet pet2 = new VirtualPet(); // Default constructor -> Egg
        VirtualPet pet3 = new VirtualPet("Shadow", "Ghostly Cat"); // Name and species constructor -> Child

        System.out.println("\n--- Daycare Roster ---");
        System.out.println("Total pets created: " + totalPetsCreated);
        System.out.println(pet1.getFullStatus());
        System.out.println(pet2.getFullStatus());
        System.out.println(pet3.getFullStatus());

        // Simulate several days
        System.out.println("\n--- Simulating 5 Days ---");
        for (int day = 1; day <= 5; day++) {
            System.out.println("\n*** Day " + day + " ***");
            pet1.simulateDay();
            pet2.simulateDay();
            pet3.simulateDay();

            // Care for pets
            if (day % 2 == 0) {
                pet1.playWithPet();
            } else {
                pet1.feedPet();
            }
            pet2.healPet();
        }
        
        System.out.println("\n--- End of Simulation Status ---");
        System.out.println(pet1.getFullStatus());
        System.out.println(pet2.getFullStatus());
        System.out.println(pet3.getFullStatus());
    }
}
