package MatchPresets;

import ServingClasses.*;
import Board.*;

public abstract class Abstract_Match_Preset implements Cloneable{

    protected int first_player_time, second_player_time;
    protected Colour first_player_colour;
    protected Board start_position; 
    protected boolean first_player_сastling;
    protected boolean second_player_castling;

    abstract public Abstract_Match_Preset clone() throws CloneNotSupportedException;
    
    public int getFirstPlayerTime(){
  
        return first_player_time;
  
    }
    public int getSecondPlayerTime(){
  
        return second_player_time;
  
    }
    public Colour getFirstPlayerColour(){
  
        return first_player_colour;
  
    }
    public Board getBoard(){
  
        return start_position;
  
    }

}