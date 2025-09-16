public class Workout {
    String activityName;
    int durationInMinutes;
    int caloriesBurned;

    // 1. Default constructor → "Walking", 30 mins, 100 calories.
    public Workout() {
        this.activityName = "Walking";
        this.durationInMinutes = 30;
        this.caloriesBurned = 100;
    }

    // 2. Constructor with activity name → assigns default duration.
    public Workout(String activityName) {
        this.activityName = activityName;
        this.durationInMinutes = 30; // Default duration
        // Assuming a default calorie burn for this constructor, or calculating based on default duration
        this.caloriesBurned = this.durationInMinutes * 5; // Using the rule from constructor 3 for consistency
    }

    // 3. Constructor with activity and duration → calculate caloriesBurned = duration × 5.
    public Workout(String activityName, int durationInMinutes) {
        this.activityName = activityName;
        this.durationInMinutes = durationInMinutes;
        this.caloriesBurned = durationInMinutes * 5;
    }

    // Method: displayWorkout() → prints activity details.
    public void displayWorkout() {
        System.out.println("Workout Details");
        System.out.println("Activity: " + activityName);
        System.out.println("Duration: " + durationInMinutes + " minutes");
        System.out.println("Calories Burned: " + caloriesBurned);
        System.out.println("");
    }

    public static void main(String[] args) {
        // Create different workouts

        // Using default constructor
        Workout workout1 = new Workout();
        workout1.displayWorkout();

        // Using constructor with activity name
        Workout workout2 = new Workout("Running");
        workout2.displayWorkout();

        // Using constructor with activity and duration
        Workout workout3 = new Workout("Cycling", 60);
        workout3.displayWorkout();

        // Another example with activity and duration
        Workout workout4 = new Workout("Weightlifting", 45);
        workout4.displayWorkout();

        // Another example using default constructor
        Workout workout5 = new Workout();
        workout5.activityName = "Yoga"; // Can manually change fields after creation
        workout5.displayWorkout();
    }
}
