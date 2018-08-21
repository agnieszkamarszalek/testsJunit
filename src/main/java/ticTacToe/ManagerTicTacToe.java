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

    public String playGame(String coordinates) {
        //player
        String[] coordinatesStringArray = coordinates.split(",");
        int[] coordinatesIntArray = {Integer.parseInt(coordinatesStringArray[0]), Integer.parseInt(coordinatesStringArray[1])};
        board.markField(this.player, coordinatesIntArray[0], coordinatesIntArray[1]);
        displayBoard.refreshBoard(this.player.getXorO(), coordinatesIntArray[0], coordinatesIntArray[1]);
        String isWinner = checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard());
        if(!" ".equals(isWinner)) {
            return isWinner;
        }
        boolean isGameOver = checkIfGameIsOver.checkAreAllFieldsTaken(this.board.getMyBoard());
        if(isGameOver) {
            return "Game is over";
        }
        //artificialPlayer
        int[] coordinatesArtificialPlayer = artificialPlayer.chooseCoordinates();
        this.board.markField(artificialPlayer, coordinatesArtificialPlayer[0], coordinatesArtificialPlayer[1]);
        displayBoard.refreshBoard(artificialPlayer.getXorO(), coordinatesArtificialPlayer[0], coordinatesArtificialPlayer[1]);
        String isWinnerArtificialPlayer = checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard());
        if(!" ".equals(isWinner)) {
            return isWinner;
        }
        boolean isGameOver2 = checkIfGameIsOver.checkAreAllFieldsTaken(board.getMyBoard());
        if(isGameOver2) {
            return "Game is over";
        }



        return " ";
    }

//    public void playGame(){
//        displayBoard.showBoardWhenPlay();
//        while (true){
//            System.out.println("Your move");
//            takeMoveFromPlayer(this.player);
//            displayBoard.showBoardWhenPlay();
//                if(!(" ").equals(checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard()))){
//                    String isWinner = checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard());
//                    System.out.println("The winner is " + isWinner);
//                    return;
//                }
//                if(checkIfGameIsOver.checkAreAllFieldsTaken(this.board.getMyBoard())){
//                    System.out.println("Game over.");
//                    return;
//                }
//            System.out.println("Artificial player ");
//            takeMoveFromPlayer(this.artificialPlayer);
//            displayBoard.showBoardWhenPlay();
//                if(!(" ").equals(checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard()))){
//                    String isWinner = checkIfGameIsOver.checkIsTheWinner(this.board.getMyBoard());
//                    System.out.println("The winner is " + isWinner);
//                    return;
//                }
//                if(checkIfGameIsOver.checkAreAllFieldsTaken(this.board.getMyBoard())){
//                    System.out.println("Game over.");
//                    return;
//                }
//        }
//    }

    public void takeMoveFromPlayer(PlayersInterface player){

        boolean isChosenField = false;
        int[] xYtable = null;
        do {
            do { xYtable = player.chooseCoordinates(); }
            while(xYtable.length == 0);
            int x = xYtable[0];
            int y = xYtable[1];
            isChosenField = board.markField(player, x, y);
        }while (!isChosenField);
    }
}
