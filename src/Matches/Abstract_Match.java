package Matches;

import Board.*;
import Figures.*;
import ServingClasses.*;
import MatchPresets.*;
import MoveHistory.Move;
import MoveHistory.Move_History;

abstract class Abstract_Match implements Cloneable{

    protected Player_state first_player_state;
    protected Player_state second_player_state;
    protected Board board;
    protected Game_state game_state;
    protected Abstract_Match_Preset match_preset;
    protected int first_player_timer;
    protected int second_player_timer;
    protected boolean first_player_сastling;
    protected boolean second_player_сastling;
    protected Move_History move_history;

    Abstract_Match(Abstract_Match_Preset match_preset){

        this.match_preset = match_preset;
        first_player_timer = this.match_preset.getFirstPlayerTime();
        second_player_timer = this.match_preset.getSecondPlayerTime();
        board = this.match_preset.getBoard();
        game_state = Game_state.START_GAME;

    }

    abstract public Abstract_Match clone() throws CloneNotSupportedException;

    abstract protected Coordinates find_figure(Figure figure);

    abstract protected boolean check_for_check();
    
    abstract protected void check_for_mate();

    abstract protected void check_for_stalemate();

    abstract protected void check_for_draw(); 

    abstract protected boolean add_figure(Coordinates coordinates, Figure figure);

    abstract protected boolean check_move(Move move);

    abstract protected boolean move(Move move);

}
