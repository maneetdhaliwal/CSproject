import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class gameUI {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    player players = new player();
    turn turn = new turn(players);
    public void startGame() {
        int input = 0;
            while (input != -1) {
                System.out.println("4 players, one dice, 6 different possibilites, first one to 9 trophies win");
                System.out.println("press 1 to begin. -1 to exit");
                input = scanner.nextInt();
                if ( input == 1 ) {
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
                    System.out.println("player that will go first is:" + turn.getCurrentPlayerName() + ". Enter 1 to roll the die!");
                    int input2 = scanner.nextInt();
                    if (input2 == 1) {
                        int currentPlayerTrophies = turn.getCurrentPlayerTrophies();
                        int diceroll = rand.nextInt(7) - 3;
                        System.out.println("You rolled a " + diceroll + "! It's added to your number of trophies."); // add to .getperson's trophies
                        turn.nextTurn();
                        turn.setCurrentPlayerTrophies(currentPlayerTrophies + diceroll);
                        System.out.println("Your total trophies now: " + turn.getCurrentPlayerTrophies());
                        if (turn.getCurrentPlayerTrophies() >= 6) {
                            System.out.println(turn.getCurrentPlayerName() + " has won the game with 6 trophies!");
                            break; // End the game
                        }
                        System.out.println("player that will go next is:" + turn.getCurrentPlayerName() + ". Enter 1 to roll the die!");
                        input2 = scanner.nextInt();
                    }
                }
            }
            scanner.close(); 
        }
}


// search the web for turn chooser function
// clean up display with nicer outputs
// continue on with start game function (roll die)
// find out how to update game stats