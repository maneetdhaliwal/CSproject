class Turn {
    private int currentTurn = 0;
    private Player players;

    public Turn(Player players) {
        this.players = players;
    }

    public int getCurrentTurn() {
        return this.currentTurn;
    }

    public void nextTurn() {
        this.currentTurn = (this.currentTurn + 1) % this.players.getPlayerNames().size();
    }

    public String getCurrentPlayerName() {
        return this.players.getPlayerNames().get(this.currentTurn);
    }

    public int getCurrentPlayerTrophies() {
        String currentPlayerName = getCurrentPlayerName();
        return players.getPlayerTrophies(currentPlayerName);
    }

    public void setCurrentPlayerTrophies(int trophies) {
        String currentPlayerName = getCurrentPlayerName();
        players.setPlayerTrophies(currentPlayerName, trophies);
    }
}
