import java.util.Random;
import java.util.Scanner;

public class numbergame {
    private static final int MAX_ATTEMPTS = 10;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playAgain = false;
            int randomNumber = generateRandomNumber(1, 100);
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number: " + randomNumber);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + randomNumber);
            } else {
                score += (MAX_ATTEMPTS - attempts + 1); // Score based on remaining attempts
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                playAgain = true;
            }

        } while (playAgain);

        System.out.println("Thank you for playing! Your final score: " + score);
        scanner.close();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
