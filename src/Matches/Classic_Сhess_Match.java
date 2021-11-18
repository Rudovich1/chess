package Matches;

import java.util.ArrayList;

import Figures.*;
import MatchPresets.*;
import MoveHistory.*;
import ServingClasses.*;
import ServingClasses.*;

public class Classic_Сhess_Match extends Abstract_Match {
    
    
    
    Classic_Сhess_Match(Abstract_Match_Preset match_preset) {
        
        super(match_preset);
        
    }

    public Coordinates find_figure(Figure figure){
        
        for (int i = 0;i<8;++i){
            for (int j = 0;j<8;++j){
                
                if ((board.getCage(new Coordinates(i, j)).getFigure().id() == figure.id())){
                
                    return (new Coordinates(i, j));
                
                }

            }
        }

        return null;
    
    }

    public boolean check_for_check() {
        
        Coordinates king_coordinates;

        if (game_state == Game_state.WHITE_MOVE){
            
            king_coordinates = find_figure(new King(Colour.BLACK));
            
            ArrayList<Coordinates> available_coordinates_to_attack = new ArrayList<>();

            for (int i = 0;i<8;++i){
                for (int j = 0;j<8;++j){
                    
                    if (board.getCage(new Coordinates(i, j)).getFigure() != null && board.getCage(new Coordinates(i, j)).getFigure().getColour() == Colour.WHITE){

                        available_coordinates_to_attack = board.availableCoordinatesToAttack(new Coordinates(i, j), move_history.getLastMove());

                    }

                    // Добавить проверку на получение шаха, при перестановке фигуры. 

                    for (Coordinates k : available_coordinates_to_attack){

                        if (k == king_coordinates){
                            


                        }

                    }

                }
            }
        }

        
        
        return false;
    }

    @Override
    public Abstract_Match clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void check_for_mate() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void check_for_stalemate() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void check_for_draw() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected boolean add_figure(Coordinates coordinates, Figure figure) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean check_move(Move move) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected boolean move(Move move) {
        // TODO Auto-generated method stub
        return false;
    }

}
