package Matches;

import java.util.ArrayList;

import EventsHistory.*;
import Figures.*;
import MatchPresets.*;
import ServingClasses.*;

public class Classic_Сhess_Match extends Abstract_Match {
    
    public Classic_Сhess_Match(Abstract_Match_Preset match_preset) {
        
        super(match_preset);
        
    }

    public Coordinates findFigure(Figure figure){
        
        for (int i = 1;i<=8;++i){
            for (int j = 1;j<=8;++j){
                
                Coordinates current_coordinates = new Coordinates(j, i);
                if (board.getCage(current_coordinates).getFigure() != null && (board.getCage(current_coordinates).getFigure().id() == figure.id())){
                
                    return current_coordinates;
                
                }

            }
        }

        return null;
    
    }
    
    @Override
    public Classic_Сhess_Match clone() throws CloneNotSupportedException {
        
        Classic_Сhess_Match clone_match = new Classic_Сhess_Match(match_preset);
        clone_match.first_player_state = this.first_player_state;
        clone_match.second_player_state = this.second_player_state;
        clone_match.board = this.board.clone();
        clone_match.game_state = this.game_state;
        clone_match.match_preset = this.match_preset.clone();
        clone_match.first_player_timer = this.first_player_timer;
        clone_match.second_player_timer = this.second_player_timer;
        clone_match.first_player_сastling = this.first_player_сastling;
        clone_match.second_player_сastling = this.second_player_сastling;
        clone_match.events_history = events_history.clone();

        return clone_match;

    }

    @Override
    public boolean checkForCheck(Color color) throws CloneNotSupportedException {
        
        Coordinates king_coordinates;

        if (color == Color.BLACK){
            
            king_coordinates = findFigure(new King(Color.BLACK));
            
            ArrayList<Coordinates> available_coordinates_to_attack = new ArrayList<>();

            for (int i = 1;i<=8;++i){
                for (int j = 1;j<=8;++j){
                    
                    Coordinates current_coordinates = new Coordinates(i, j);
                    if (board.getCage(current_coordinates).getFigure() != null && board.getCage(current_coordinates).getFigure().getColor() == Color.WHITE){

                        available_coordinates_to_attack = board.availableCoordinatesToAttack(current_coordinates, events_history.getLastEvent());

                        for (Coordinates k : available_coordinates_to_attack){

                            if (k.equals(king_coordinates) && checkMove(current_coordinates, king_coordinates, Color.WHITE)){
                                
                                return true;
    
                            }
    
                        }
                    } 
                }
            }

        } else if (color == Color.WHITE){
            
            king_coordinates = findFigure(new King(Color.WHITE));
            
            ArrayList<Coordinates> available_coordinates_to_attack = new ArrayList<>();

            for (int i = 1;i<=8;++i){
                for (int j = 1;j<=8;++j){
                    
                    Coordinates current_coordinates = new Coordinates(j, i);
                    if (board.getCage(current_coordinates).getFigure() != null && board.getCage(current_coordinates).getFigure().getColor() == Color.BLACK){

                        available_coordinates_to_attack = board.availableCoordinatesToAttack(current_coordinates, events_history.getLastEvent());

                        for (Coordinates k : available_coordinates_to_attack){

                            if (k.equals(king_coordinates) && checkMove(k, king_coordinates, Color.BLACK)){
                                
                                return true;
    
                            }
    
                        }
                    } 
                }
            }
        }  
        
        return false;
    
    }

    @Override
    public boolean checkForMate(Color color) throws CloneNotSupportedException {

        if (color == Color.WHITE){
            
            if (!checkForCheck(color)){

                return false;

            }

            ArrayList<Coordinates> available_coordinates_to_move = new ArrayList<>();

            for (int i = 1;i<=8;++i){
                for (int j = 1;j<=8;++j){

                    Coordinates current_coordinates = new Coordinates(j, i);
                    if (board.getCage(current_coordinates).getFigure() != null && board.getCage(current_coordinates).getFigure().getColor() == Color.WHITE){

                        available_coordinates_to_move = board.availableCoordinatesToMove(current_coordinates);

                        for (Coordinates k : available_coordinates_to_move){

                            if (checkMove(current_coordinates, k, Color.WHITE)){
                                
                                return false;

                            }

                        }

                    }

                }
            }

        } else if (color == Color.BLACK){
            
            if (!checkForCheck(color)){

                return false;

            }

            ArrayList<Coordinates> available_coordinates_to_move = new ArrayList<>();

            for (int i = 1;i<=8;++i){
                for (int j = 1;j<=8;++j){

                    Coordinates current_coordinates = new Coordinates(j, i);
                    if (board.getCage(current_coordinates).getFigure() != null && board.getCage(current_coordinates).getFigure().getColor() == Color.BLACK){

                        available_coordinates_to_move = board.availableCoordinatesToMove(current_coordinates);

                        for (Coordinates k : available_coordinates_to_move){

                            if (checkMove(current_coordinates, k, Color.BLACK)){
                                
                                return false;

                            }

                        }

                    }

                }
            }
        }  
        
        return true;
        
    }

    @Override
    public boolean checkForStalemate(Color color) {
        
        // :)

        return false;
    }

    @Override
    public boolean checkForDraw() {
        
        // :)

        return false;
    }

    @Override
    public void addFigure(Coordinates coordinates, Figure figure) {

        board.getCage(coordinates).setFigure(figure);

    }

    @Override
    public void deleteFigure(Coordinates coordinates){

        board.getCage(coordinates).setFigure(null);

    }

    @Override
    public void pawnTrasformation(Move move, Figure figure){
        
        deleteFigure(move.getMove().first.second);
        addFigure(move.getMove().first.second, figure);
        events_history.push(new Promotion(move, figure));

    }

    @Override
    public boolean checkMove(Coordinates start, Coordinates finish, Color color) throws CloneNotSupportedException {
        
        if (board.getCage(start).getFigure() == null){

            return false;

        }

        if (board.getCage(start).getFigure().getColor() != color){

            return false;

        }

        if (board.getCage(finish).getFigure() != null && (board.getCage(finish).getFigure().getColor() == board.getCage(start).getFigure().getColor())){

            return false;
        
        }

        for (Coordinates i : board.availableCoordinatesToMove(start)){

            if (i.equals(finish)){

                Classic_Сhess_Match test_match = this.clone();
                test_match.move(start, finish);
                
                boolean check = true;
                if (board.getCage(start).getFigure().getColor() == Color.WHITE){

                    check = test_match.checkForCheck(Color.WHITE);

                } else if (board.getCage(start).getFigure().getColor() == Color.BLACK){

                    check = test_match.checkForCheck(Color.BLACK);

                }

                return (!check);

            }

        }

        for (Coordinates i : board.availableCoordinatesToAttack(start, events_history == null ? null : events_history.getLastEvent())){

            if (i.equals(finish)){

                Classic_Сhess_Match test_match = this.clone();
                test_match.move(start, finish);
                
                boolean check = true;
                if (board.getCage(start).getFigure().getColor() == Color.WHITE){

                    check = test_match.checkForCheck(Color.WHITE);

                } else if (board.getCage(start).getFigure().getColor() == Color.BLACK){

                    check = test_match.checkForCheck(Color.BLACK);

                }

                return (!check);

            }

        }

        return false;
    }

    @Override
    public void move(Coordinates start, Coordinates finish) {
        
        if (board.getCage(finish).getFigure() == null){

            events_history.push(new Move(start,finish,board.getCage(start).getFigure()));
            addFigure(finish, board.getCage(start).getFigure());
            deleteFigure(start);

        } else {

            events_history.push(new Capture(start,finish,board.getCage(start).getFigure(), board.getCage(finish).getFigure()));
            deleteFigure(finish);
            addFigure(finish, board.getCage(start).getFigure());
            deleteFigure(start);

        }

        if (board.getCage(finish).getFigure().getClass() == Pawn.class && Math.abs(start.toIterator().first - finish.toIterator().first) == 2){

            ((Pawn) board.getCage(finish).getFigure()).setLongMove();

        }

    }


}
