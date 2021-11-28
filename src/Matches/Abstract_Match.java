package Matches;

import Board.*;
import EventsHistory.Events_History;
import EventsHistory.Move;
import Figures.*;
import ServingClasses.*;
import MatchPresets.*;

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
    protected Events_History events_history;

    Abstract_Match(Abstract_Match_Preset match_preset){

        this.match_preset = match_preset;
        first_player_timer = this.match_preset.getFirstPlayerTime();
        second_player_timer = this.match_preset.getSecondPlayerTime();
        board = this.match_preset.getBoard();
        game_state = Game_state.START_GAME;
        events_history = new Events_History();

    }

    Abstract_Match(Abstract_Match abstract_match) throws CloneNotSupportedException{

        this.first_player_state = abstract_match.first_player_state;
        this.second_player_state = abstract_match.second_player_state;
        this.board = abstract_match.board.clone();
        this.game_state = abstract_match.game_state;
        this.match_preset = abstract_match.match_preset.clone();
        this.first_player_timer = abstract_match.first_player_timer;
        this.second_player_timer = abstract_match.second_player_timer;
        this.first_player_сastling = abstract_match.first_player_сastling;
        this.second_player_сastling = abstract_match.second_player_сastling;
        this.events_history = abstract_match.events_history.clone();

    }

    abstract public Abstract_Match clone() throws CloneNotSupportedException;

    abstract protected Coordinates findFigure(Figure figure);

    abstract protected boolean checkForCheck(Color color) throws CloneNotSupportedException;
    
    abstract protected boolean checkForMate(Color color) throws CloneNotSupportedException;

    abstract protected boolean checkForStalemate(Color color);

    abstract protected boolean checkForDraw(); 

    abstract protected void addFigure(Coordinates coordinates, Figure figure);

    abstract protected void deleteFigure(Coordinates coordinates);

    abstract protected void pawnTrasformation(Move move, Figure figure);

    abstract protected boolean checkMove(Coordinates start, Coordinates finish, Color color) throws CloneNotSupportedException;

    abstract protected void move(Coordinates start, Coordinates finish);

    public Game_state getGameState(){

        return game_state;

    }

    public void setGameState(Game_state game_state){

        this.game_state = game_state;

    }

    public Player_state getFirstPlayerState(){

        return first_player_state;

    }

    public Player_state getSecondPlayerState(){

        return second_player_state;

    }

    public Board getBoard(){

        return board;

    }

    public Abstract_Match_Preset getAbstractMatchPreset(){

        return match_preset;

    }

    public int getFirstPlayerTimer(){

        return first_player_timer;

    }

    public int getSecondPlayerTimer(){

        return second_player_timer;

    }

    public Events_History getEventsHistory(){

        return events_history;

    }
}
