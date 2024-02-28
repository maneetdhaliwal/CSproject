import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class GameUI {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    Player players = new Player();
    Turn turn = new Turn(players);

    public void startGame() {
        int input = 0;
        while (input != -1) {
            System.out.println("4 players, one dice, 6 different possibilities, first one to 6 trophies win");
            System.out.println("Press 1 to begin. -1 to exit");
            input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Enter the names of 4 players (one name per line):");
                for (int i = 0; i < 4; i++) {
                    String playerName = scanner.next();
                    players.addPlayer(playerName);
                }
                System.out.println("The names of the players are:");
                ArrayList<String> playerNames = players.getPlayerNames();
                for (String playerName : playerNames) {
                    System.out.println(playerName);
                }
                while (true) { // do-loop instead 
                    for (String playerName : playerNames) {
                        System.out.println(playerName + ", it's your turn. Enter 1 to roll the die:");
                        int input2 = scanner.nextInt();
                        if (input2 == 1) {
                            int currentPlayerTrophies = turn.getCurrentPlayerTrophies();
                            int diceroll = rand.nextInt(7) - 3; // \ a 6-sided die + ONE TO CANCLE OUT 0
                            System.out.println("You rolled a " + diceroll + "! It is added to your number of trophies.");
                            int totalTrophies = currentPlayerTrophies + diceroll; // take out turn next and create playerloopinstead
                            turn.setCurrentPlayerTrophies(totalTrophies);
                            System.out.println("Your total trophies now: " + totalTrophies);
                            if (totalTrophies >= 6) {
                                System.out.println(playerName + " has won the game!");
                                return;
                            }
                            turn.nextTurn();
                        }
                    }
                }
            }
        }
    }
}

// TODO: rewrite inner loop to continue for all players
// successfully update player's trophies (.setCurrentPlayerTrophies)
// Might have to use HashMaps
// end when any trophies greater than 6