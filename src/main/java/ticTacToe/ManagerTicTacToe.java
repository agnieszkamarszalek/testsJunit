package ticTacToe;

public class ManagerTicTacToe {
    private Board board;
    private Player player;
    private CheckIfGameIsOver checkIfGameIsOver;
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

        this.checkIfGameIsOver = new CheckIfGameIsOver();
        this.displayBoard = new DisplayBoard(board);

    }

    public void setBoard(Board board) {
        this.artificialPlayer.setBoard(board);
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

    public CheckIfGameIsOver getCheckIfGameIsOver() {
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

    public void playGame(){
        displayBoard.showBoardWhenPlay();
        while (true){
            System.out.println("Your move");
            takeMoveFromPlayer();
            displayBoard.showBoardWhenPlay();
                if(!(" ").equals(checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard()))){
                    String isWinner = checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard());
                    System.out.println("The winner is " + isWinner);
                    return;
                }
                if(checkIfGameIsOver.checkAreAllFieldsTaken(this.board.getMyBoard())){
                    System.out.println("Game over.");
                    return;
                }
            System.out.println("Artificial player ");
            takeMovesFromArtificialPlayer();
            displayBoard.showBoardWhenPlay();
                if(!(" ").equals(checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard()))){
                    String isWinner = checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard());
                    System.out.println("The winner is " + isWinner);
                    return;
                }
                if(checkIfGameIsOver.checkAreAllFieldsTaken(this.board.getMyBoard())){
                    System.out.println("Game over.");
                    return;
                }
        }
    }

    public void takeMovesFromArtificialPlayer(){
        int[] xYtable = artificialPlayer.chooseField();
        int x = xYtable[0];
        int y = xYtable[1];
        board.takeField(this.artificialPlayer, x, y);
        System.out.println("Artificial player tooks " + x + "," + y);
    }

    public void takeMoveFromPlayer(){

        boolean isChosenField = false;
        do {
            int[] xYtable = player.chooseField();
            int x = xYtable[0];
            int y = xYtable[1];
            isChosenField = board.takeField(this.player, x, y);
        }while (!isChosenField);
    }
}
