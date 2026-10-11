import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final Random random = new Random();

    private int playerScore = 0;
    private int computerScore = 0;
    private int ties = 0;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("=== Rock Paper Scissors ===");

        boolean playing = true;
        while (playing) {
            playRound();
            printScore();
            playing = askPlayAgain();
        }

        System.out.println("****************");
        System.out.println("Thanks for playing!");
        System.out.println("****************");
    }

    private void playRound() {
        Move player = askPlayerMove();
        Move computer = Move.values()[random.nextInt(Move.values().length)];
        System.out.println("Computer chose: " + computer);

        if (player == computer) {
            System.out.println("It's a tie!");
            ties++;
        } else if (player.beats(computer)) {
            System.out.println("You win!");
            playerScore++;
        } else {
            System.out.println("You lose!");
            computerScore++;
        }
    }

    private Move askPlayerMove() {
        while (true) {
            System.out.print("Enter your choice (rock/paper/scissors or r/p/s): ");
            Move move = Move.fromInput(scanner.nextLine());
            if (move != null) {
                return move;
            }
            System.out.println("Invalid choice, please try again.");
        }
    }

    private boolean askPlayAgain() {
        while (true) {
            System.out.print("Play again? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y") || answer.equals("yes")) {
                return true;
            }
            if (answer.equals("n") || answer.equals("no")) {
                return false;
            }
            System.out.println("Please type y or n.");
        }
    }

    private void printScore() {
        System.out.println("Score -> You: " + playerScore
                + " | Computer: " + computerScore
                + " | Ties: " + ties);
    }
}
