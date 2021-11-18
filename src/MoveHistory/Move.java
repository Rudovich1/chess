package MoveHistory;

import Figures.*;
import ServingClasses.*;

public class Move implements Cloneable{
    
    private Pair<Pair<Coordinates,Coordinates>,Figure> move;

    Move(Coordinates start, Coordinates finish, Figure figure){

        move = new Pair<Pair<Coordinates,Coordinates>,Figure>(new Pair<Coordinates, Coordinates>(start,finish), figure);

    }

    public Move clone() throws CloneNotSupportedException{

        return (new Move(move.first.first.clone(),move.first.second.clone(),move.second.clone()));

    }

    public Pair<Pair<Coordinates,Coordinates>,Figure> getMove(){
        
        return move;

    }

    public String toString(){

        return new String(move.second.toString() + move.first.first.toString() + "-" + move.first.second.toString());

    }

}
