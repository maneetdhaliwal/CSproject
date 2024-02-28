import java.util.ArrayList;
import java.util.HashMap;

class Player {
    private ArrayList<String> playerNames;
    private HashMap<String, Integer> playerTrophies;

    public Player() {
        this.playerNames = new ArrayList<>();
        this.playerTrophies = new HashMap<>();
    }

    public void addPlayer(String playerName) {
        this.playerNames.add(playerName);
        this.playerTrophies.put(playerName, 0); // Initialize trophies for each player to 0
    }

    public ArrayList<String> getPlayerNames() {
        return this.playerNames;
    }

    public int getPlayerTrophies(String playerName) {
        return playerTrophies.getOrDefault(playerName, 0);
    }

    public void setPlayerTrophies(String playerName, int trophies) {
        playerTrophies.put(playerName, trophies);
    }
}
