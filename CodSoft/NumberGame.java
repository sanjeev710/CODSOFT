import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int totalRounds = 0;  
        int totalScore = 0;  

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            int computerNumber = rand.nextInt(100) + 1;  
            int attempts = 0;   
            int maxAttempts = 5; 
            boolean hasGuessedCorrectly = false;
            totalRounds++;

            System.out.println("I've picked a number between 1 and 100. You have " + maxAttempts + " attempts to guess it!");

            
            for (int i = 0; i < maxAttempts; i++) {
                System.out.print("Enter your guess: ");
                int userGuess = scan.nextInt();
                attempts++;

                if (userGuess == computerNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess > computerNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                int remainingAttempts = maxAttempts - attempts;
                if (remainingAttempts > 0) {
                    System.out.println("You have " + remainingAttempts + " attempts left.");
                } else {
                    System.out.println("You've used all your attempts. The correct number was: " + computerNumber);
                }
            }

            
            if (hasGuessedCorrectly) {
                totalScore += attempts;
            } else {
                totalScore += maxAttempts;  
            }

            
            System.out.print("Do you want to play another round? (yes/no): ");
            scan.nextLine();  
            String response = scan.nextLine().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Your total score (lower is better): " + totalScore);

        scan.close();
    }
}
