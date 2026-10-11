public enum Move {
    ROCK, PAPER, SCISSORS;

    /** Returns true if this move beats the other move. */
    public boolean beats(Move other) {
        return (this == ROCK && other == SCISSORS)
                || (this == PAPER && other == ROCK)
                || (this == SCISSORS && other == PAPER);
    }

    /** Converts user input to a Move, or returns null if the input is invalid. */
    public static Move fromInput(String input) {
        switch (input.trim().toLowerCase()) {
            case "rock":
            case "r":
                return ROCK;
            case "paper":
            case "p":
                return PAPER;
            case "scissors":
            case "s":
                return SCISSORS;
            default:
                return null;
        }
    }
}
