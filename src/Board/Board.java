package Board;

import java.util.ArrayList;

import EventsHistory.Event;
import EventsHistory.Move;
import Figures.*;
import ServingClasses.Color;
import ServingClasses.Coordinates;

public class Board implements Cloneable{

    private Cage[][] board;

    public Board(){

        board = new Cage[8][8];
        
        for (int i = 0;i<8;++i){
            for (int j = 0;j<8;++j){

                board[i][j] = new Cage();

            }
        }
        
        for (Cage i : board[1]){

            i.setFigure(new Pawn(Color.WHITE));
        
        }
        
        for (Cage i : board[6]){
        
            i.setFigure(new Pawn(Color.BLACK));
        
        }
        
        board[0][0].setFigure(new Rook(Color.WHITE));
        board[0][7].setFigure(new Rook(Color.WHITE));
        board[0][1].setFigure(new Knight(Color.WHITE));
        board[0][6].setFigure(new Knight(Color.WHITE));
        board[0][2].setFigure(new Bishop(Color.WHITE));
        board[0][5].setFigure(new Bishop(Color.WHITE));
        board[0][3].setFigure(new Queen(Color.WHITE));
        board[0][4].setFigure(new King(Color.WHITE));

        board[7][0].setFigure(new Rook(Color.BLACK));
        board[7][7].setFigure(new Rook(Color.BLACK));
        board[7][1].setFigure(new Knight(Color.BLACK));
        board[7][6].setFigure(new Knight(Color.BLACK));
        board[7][2].setFigure(new Bishop(Color.BLACK));
        board[7][5].setFigure(new Bishop(Color.BLACK));
        board[7][3].setFigure(new Queen(Color.BLACK));
        board[7][4].setFigure(new King(Color.BLACK));
    }

    public Board clone() throws CloneNotSupportedException{

        Cage[][] clone_board = new Cage[8][8];

        for (int i = 0;i<8;++i){
            for (int j = 0;j<8;++j){

                clone_board[i][j] = board[i][j].clone();

            }
        }

        return new Board(clone_board);

    }

    public Board(Cage[][] board){
    
        this.board = board;
    
    }

    public Cage getCage(Coordinates coordinates){
        
        return board[coordinates.toIterator().first - 1][coordinates.toIterator().second - 1];
    
    }

    public void setCage(Coordinates coordinates, Figure figure){
        
        getCage(coordinates).setFigure(figure);

    }

    public ArrayList<Coordinates> availableCoordinatesToAttack(Coordinates coordinates, Event last_event){
        
        ArrayList<ArrayList<Coordinates>> coordinates_to_attack = getCage(coordinates).getFigure().CoordinatesToAttack(coordinates);
        ArrayList<Coordinates> available_coordinates_to_attack = new ArrayList<Coordinates>();

        if (getCage(coordinates).getFigure().getClass() == Pawn.class && last_event != null && last_event.getClass() == Move.class && ((Move)last_event).getMove().second.getClass() == Pawn.class
            && ((Move)last_event).getMove().first.second.toIterator().second == coordinates.toIterator().second){
            
            if (((Move)last_event).getMove().first.second.toIterator().first == coordinates.toIterator().first - 1){

                available_coordinates_to_attack.add(new Coordinates(coordinates.toIterator().first - 1, coordinates.toIterator().second));

            } else if (((Move)last_event).getMove().first.second.toIterator().first == coordinates.toIterator().first + 1){

                available_coordinates_to_attack.add(new Coordinates(coordinates.toIterator().first + 1, coordinates.toIterator().second));

            }
        
        }

        for (ArrayList<Coordinates> i : coordinates_to_attack){
            for (Coordinates j : i){

                if (getCage(j).getFigure() != null){
                    
                    if (getCage(j).getFigure().getColor() != getCage(coordinates).getFigure().getColor()){
                
                        available_coordinates_to_attack.add(j); 
                
                    }
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
