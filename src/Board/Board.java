package Board;

import java.util.ArrayList;
import Figures.*;
import MoveHistory.Move;
import ServingClasses.Colour;
import ServingClasses.Coordinates;

public class Board implements Cloneable{

    private Cage[][] board;

    public Board(){

        board = new Cage[8][8];
        
        for (Cage i : board[1]){

            i.setFigure(new Pawn(Colour.WHITE));
        
        }
        
        for (Cage i : board[7]){
        
            i.setFigure(new Pawn(Colour.BLACK));
        
        }
        
        board[0][0].setFigure(new Rook(Colour.WHITE));
        board[0][7].setFigure(new Rook(Colour.WHITE));
        board[0][1].setFigure(new Knight(Colour.WHITE));
        board[0][6].setFigure(new Knight(Colour.WHITE));
        board[0][2].setFigure(new Bishop(Colour.WHITE));
        board[0][5].setFigure(new Bishop(Colour.WHITE));
        board[0][3].setFigure(new Queen(Colour.WHITE));
        board[0][4].setFigure(new King(Colour.WHITE));

        board[7][0].setFigure(new Rook(Colour.BLACK));
        board[7][7].setFigure(new Rook(Colour.BLACK));
        board[7][1].setFigure(new Knight(Colour.BLACK));
        board[7][6].setFigure(new Knight(Colour.BLACK));
        board[7][2].setFigure(new Bishop(Colour.BLACK));
        board[7][5].setFigure(new Bishop(Colour.BLACK));
        board[7][3].setFigure(new Queen(Colour.BLACK));
        board[7][4].setFigure(new King(Colour.BLACK));
    }

    public Board clone() throws CloneNotSupportedException{

        return (new Board(board.clone()));

    }

    public Board(Cage[][] board){
    
        this.board = board;
    
    }

    public Cage getCage(Coordinates coordinates){
    
        return board[coordinates.toIterator().first][coordinates.toIterator().second];
    
    }

    public void setCage(Coordinates coordinates, Figure figure){
        
        getCage(coordinates).setFigure(figure);

    }

    public ArrayList<Coordinates> availableCoordinatesToAttack(Coordinates coordinates, Move last_move){
        
        ArrayList<ArrayList<Coordinates>> coordinates_to_attack = getCage(coordinates).getFigure().CoordinatesToAttack(coordinates);
        ArrayList<Coordinates> available_coordinates_to_attack = new ArrayList<Coordinates>();

        if (getCage(coordinates).getFigure().getClass() == Pawn.class && last_move.getMove().second.getClass() == Pawn.class
            && last_move.getMove().first.second.toIterator().second == coordinates.toIterator().second){
            
            if (last_move.getMove().first.second.toIterator().first == coordinates.toIterator().first - 1){

                available_coordinates_to_attack.add(new Coordinates(coordinates.toIterator().first - 1, coordinates.toIterator().second));

            } else if (last_move.getMove().first.second.toIterator().first == coordinates.toIterator().first + 1){

                available_coordinates_to_attack.add(new Coordinates(coordinates.toIterator().first + 1, coordinates.toIterator().second));

            }
        
        }

        for (ArrayList<Coordinates> i : coordinates_to_attack){
            for (Coordinates j : i){

                if (getCage(j).getFigure() != null){
                    
                    available_coordinates_to_attack.add(j); 
                    break;
                
                }

            }
        }

        return available_coordinates_to_attack;
    }

    public ArrayList<Coordinates> availableCoordinatesToMove(Coordinates coordinates){

        ArrayList<ArrayList<Coordinates>> coordinates_to_move = getCage(coordinates).getFigure().CoordinatesToMove(coordinates);
        ArrayList<Coordinates> available_cages_to_move = new ArrayList<Coordinates>();
        
        for (ArrayList<Coordinates> i : coordinates_to_move){
            for (Coordinates j : i){

                if (getCage(j).getFigure() == null){
                
                    available_cages_to_move.add(j);
                
                } else {
                
                    break;
                
                }
            }
        }

        return available_cages_to_move;
    }

}
