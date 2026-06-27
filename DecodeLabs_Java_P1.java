import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundNumber = 0;
        String playAgain;

        System.out.println("==========================================");
        System.out.println("   WELCOME TO DECODELABS NUMBER GAME!   ");
        System.out.println("==========================================");

        // Multiple rounds - do-while loop
        do {
            roundNumber++;
            int targetNumber = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean won = false;

            System.out.println("\n--- ROUND " + roundNumber + " ---");
            System.out.println("Guess the number between 1 and 100!");
            System.out.println("You have " + maxAttempts + " attempts.");

            // Game loop - while(!win)
            while (attemptsUsed < maxAttempts) {
                System.out.print("\nAttempt " + (attemptsUsed + 1) + "/" + maxAttempts + " → Enter your guess: ");

                int guess = -1;

                // Input validation - try-catch for invalid input
                try {
                    guess = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("❌ Invalid input! Numbers only please.");
                    sc.nextLine(); // flush the buffer (Scanner Trap fix)
                    continue;
                }

                sc.nextLine(); // flush buffer after nextInt()
                attemptsUsed++;

                // Feedback logic
                if (guess == targetNumber) {
                    won = true;
                    int pointsEarned = (maxAttempts - attemptsUsed + 1) * 10;
                    totalScore += pointsEarned;
                    System.out.println("✅ CORRECT! You got it in " + attemptsUsed + " attempt(s)!");
                    System.out.println("🏆 Points earned this round: " + pointsEarned);
                    break;

                } else if (guess > targetNumber) {
                    System.out.println("📉 Too HIGH! Try lower.");
                } else {
                    System.out.println("📈 Too LOW! Try higher.");
                }

                // Remaining attempts hint
                int remaining = maxAttempts - attemptsUsed;
                if (remaining > 0) {
                    System.out.println("   (" + remaining + " attempts remaining)");
                }
            }

            // If ran out of attempts
            if (!won) {
                System.out.println("💀 Out of attempts! The number was: " + targetNumber);
            }

            System.out.println("\n🎯 Total Score so far: " + totalScore);

            // Play again prompt
            System.out.print("\nPlay again? (Y/N): ");
            playAgain = sc.nextLine().trim().toUpperCase();

        } while (playAgain.equals("Y"));

        // Final score display
        System.out.println("\n==========================================");
        System.out.println("         GAME OVER - FINAL SCORE: " + totalScore);
        System.out.println("         Total Rounds Played: " + roundNumber);
        System.out.println("==========================================");

        sc.close();
    }
}