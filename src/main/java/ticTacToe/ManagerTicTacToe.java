package ticTacToe;

public class ManagerTicTacToe {
    private Board board;
    private Player player;
    private CheckIfGameIsFinished checkIfGameIsOver;
    private ArtificialPlayer artificialPlayer;
    private DisplayBoard displayBoard;


    public ManagerTicTacToe(String playerXorPlayerO) {
        this.board = new Board();
        this.player = new Player(playerXorPlayerO);

        if(playerXorPlayerO.equals("X")){
            this.artificialPlayer = new ArtificialPlayer("O", board);
        }else {
            this.artificialPlayer = new ArtificialPlayer("X", board);
        }

        this.checkIfGameIsOver = new CheckIfGameIsFinished();

    }

    public void setBoard(Board board) {
        this.artificialPlayer.setBoard(board);
        this.board = board;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

    public CheckIfGameIsFinished getCheckIfGameIsOver() {
        return checkIfGameIsOver;
    }

    public ArtificialPlayer getArtificialPlayer() {
        return artificialPlayer;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setArtificialPlayer(ArtificialPlayer artificialPlayer) {
        this.artificialPlayer = artificialPlayer;
    }

    public void playGame(String coordinates) {

        //player
        String[] coordinatesStringArray = coordinates.split(",");
        int[] coordinatesIntArray = {Integer.parseInt(coordinatesStringArray[0]), Integer.parseInt(coordinatesStringArray[1])};
        if (makeMove(coordinatesIntArray, this.player)) return;

        //artificialPlayer
        int[] coordinatesArtificialPlayer = artificialPlayer.chooseCoordinates();
        if (makeMove(coordinatesArtificialPlayer, this.artificialPlayer)) return;

    }

    private boolean makeMove(int[] coordinatesIntArray, PlayersInterface currentPlayer) {
        board.markField(currentPlayer, coordinatesIntArray[0], coordinatesIntArray[1]);
        displayBoard.refreshBoard(currentPlayer.getXorO(), coordinatesIntArray[0], coordinatesIntArray[1]);
        String isWinner = checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard());
        if(!" ".equals(isWinner)) {
            WinningFields winningFields = checkIfGameIsOver.chooseWinningFields(this.board.getMyBoard());
            displayBoard.markWinningFields(winningFields);
            displayBoard.changeText("The winner is " + isWinner + " !!!" + " Game is over !");
            return true;
        }
        boolean isGameOver = checkIfGameIsOver.checkAreAllFieldsTaken(this.board.getMyBoard());
        if(isGameOver) {
            displayBoard.changeText("Game is over !");
            return true;
        }
        return false;
    }

    public void restartGame() {
        board.setEmptyFieldsOnBoard();
        displayBoard.resetButtons();
    }


}
