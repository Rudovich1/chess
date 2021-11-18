public class Board{
    class Cage{
        private Figure figure;
        Cage(Figure figure){
            this.figure = figure;
        }
        Cage(){
            figure = null;
        }
        public void setFigure(Figure figure){
            this.figure = figure;
        }
        public Figure getFigure(){
            return this.figure;
        }
    }
    private Cage[][] board;

    Board(){
        board = new Cage[8][8];
        for (Cage i : board[1]){
            i.figure = new Pawn(Colour.WHITE);
        }
        for (Cage i : board[7]){
            i.figure = new Pawn(Colour.BLACK);
        }
        board[0][0].figure = new Rook(Colour.WHITE);
        board[0][7].figure = new Rook(Colour.WHITE);
        board[0][1].figure = new Knight(Colour.WHITE);
        board[0][6].figure = new Knight(Colour.WHITE);
        board[0][2].figure = new Bishop(Colour.WHITE);
        board[0][5].figure = new Bishop(Colour.WHITE);
        board[0][3].figure = new Queen(Colour.WHITE);
        board[0][4].figure = new King(Colour.WHITE);

        board[7][0].figure = new Rook(Colour.BLACK);
        board[7][7].figure = new Rook(Colour.BLACK);
        board[7][1].figure = new Knight(Colour.BLACK);
        board[7][6].figure = new Knight(Colour.BLACK);
        board[7][2].figure = new Bishop(Colour.BLACK);
        board[7][5].figure = new Bishop(Colour.BLACK);
        board[7][3].figure = new Queen(Colour.BLACK);
        board[7][4].figure = new King(Colour.BLACK);
    }

    Board(Cage[][] board){
        this.board = board;
    }

    public Cage getCage(Coordinates coordinates){
        return board[coordinates.first][coordinates.second];
    }

    public Cage getCage(int X, int Y){
        return board[X][Y];
    }

    public void setCage(Coordinates coordinates, Figure figure){
        board[coordinates.first][coordinates.second].figure = figure;
    }

    public void setCage(int X, int Y, Figure figure){
        board[X][Y].figure = figure;
    }

}
