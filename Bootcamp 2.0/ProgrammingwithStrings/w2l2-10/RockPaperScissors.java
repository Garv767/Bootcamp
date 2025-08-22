import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static String getComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        if (choice == 0) {
            return "rock";
        } else if (choice == 1) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "tie";
        } else if (userChoice.equals("rock")) {
            if (computerChoice.equals("scissors")) {
                return "user";
            } else {
                return "computer";
            }
        } else if (userChoice.equals("paper")) {
            if (computerChoice.equals("rock")) {
                return "user";
            } else {
                return "computer";
            }
        } else { // userChoice is scissors
            if (computerChoice.equals("paper")) {
                return "user";
            } else {
                return "computer";
            }
        }
    }

    public static String[][] calculateStats(int[] userWins, int[] computerWins, int numberOfGames) {
        String[][] stats = new String[3][2];
        int totalUserWins = 0;
        int totalComputerWins = 0;

        for (int i = 0; i < numberOfGames; i++) {
            totalUserWins += userWins[i];
            totalComputerWins += computerWins[i];
        }

        double userWinPercentage = (double) totalUserWins / numberOfGames * 100;
        double computerWinPercentage = (double) totalComputerWins / numberOfGames * 100;

        stats[0][0] = "User Wins";
        stats[0][1] = String.valueOf(totalUserWins);
        stats[1][0] = "Computer Wins";
        stats[1][1] = String.valueOf(totalComputerWins);
        stats[2][0] = "User Win %";
        stats[2][1] = String.format("%.2f", userWinPercentage) + "%";

        return stats;
    }

    public static void displayResults(String[] userChoices, String[] computerChoices, String[] results, String[][] stats, int numberOfGames) {
        System.out.println("\nGame Results:");
        System.out.println("--------------------------------------------------");
        System.out.println("Game\tUser Choice\tComputer Choice\tResult");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < numberOfGames; i++) {
            System.out.println((i + 1) + "\t" + userChoices[i] + "\t\t" + computerChoices[i] + "\t\t" + results[i]);
        }

        System.out.println("\nGame Stats:");
        System.out.println("--------------------");
        for (String[] row : stats) {
            System.out.println(row[0] + ": " + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of games to play: ");
        int numberOfGames = scanner.nextInt();
        scanner.nextLine();

        String[] userChoices = new String[numberOfGames];
        String[] computerChoices = new String[numberOfGames];
        String[] results = new String[numberOfGames];
        int[] userWins = new int[numberOfGames];
        int[] computerWins = new int[numberOfGames];

        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("Enter your choice (rock, paper, or scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();
            while (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors:");
                userChoice = scanner.nextLine().toLowerCase();
            }
            userChoices[i] = userChoice;
            String computerChoice = getComputerChoice();
            computerChoices[i] = computerChoice;
            String result = determineWinner(userChoice, computerChoice);
            results[i] = result;

            if (result.equals("user")) {
                userWins[i] = 1;
            } else if (result.equals("computer")) {
                computerWins[i] = 1;
            } else {
                userWins[i] = 0;
                computerWins[i] = 0;
            }
        }
        scanner.close();

        String[][] stats = calculateStats(userWins, computerWins, numberOfGames);
        displayResults(userChoices, computerChoices, results, stats, numberOfGames);
    }
}

