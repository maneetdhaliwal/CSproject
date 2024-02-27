class turn {
    private int currentTurn = 0;
    private int currentPlayersTrophies = 0;
    private player players;

    public turn(player players) {
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
        return this.currentPlayersTrophies;
    }

    public void setCurrentPlayerTrophies(int trophies) {
        this.currentPlayersTrophies = trophies;
    }
}