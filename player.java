import java.util.ArrayList;

class player {
    private ArrayList<String> playerNames;

    public player() {
        this.playerNames = new ArrayList<>();
    }

    public void addPlayer(String playerName) {
        this.playerNames.add(playerName);
    }

    public ArrayList<String> getPlayerNames() {
        return this.playerNames;
    }
}
