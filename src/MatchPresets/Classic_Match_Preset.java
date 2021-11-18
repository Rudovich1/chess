package MatchPresets;

import Board.Board;
import ServingClasses.Colour;

public class Classic_Match_Preset extends Abstract_Match_Preset{

    Classic_Match_Preset(){

        first_player_time = -1;
        second_player_time = -1;
        first_player_colour = Colour.WHITE;
        start_position = new Board();
        first_player_сastling = true;
        second_player_castling = true;
    
    }

    @Override
    public Abstract_Match_Preset clone() throws CloneNotSupportedException {
        
        return (new Classic_Match_Preset());

    }

    

}