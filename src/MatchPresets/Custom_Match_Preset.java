package MatchPresets;

import Board.Board;
import ServingClasses.Color;

public class Custom_Match_Preset extends Abstract_Match_Preset{

    Custom_Match_Preset(int first_player_time, int second_player_time, Color first_player_Color,
    boolean first_player_сastling, boolean second_player_castling, Board start_position){

        this.first_player_time = first_player_time;
        this.second_player_time = second_player_time;
        this.first_player_Color = first_player_Color;
        this.start_position = start_position;
        this.first_player_сastling = first_player_сastling;
        this.second_player_castling = second_player_castling;

    }

    @Override
    public Abstract_Match_Preset clone() throws CloneNotSupportedException {
        
        return (new Custom_Match_Preset(first_player_time, second_player_time, first_player_Color, first_player_сastling, second_player_castling, start_position.clone()));

    }

}