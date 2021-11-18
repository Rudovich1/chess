package MoveHistory;

import java.util.ArrayList;

public class Move_History implements Cloneable{
    
    ArrayList<Move> move_history = new ArrayList<>();

    public Move_History(){}

    public Move_History(ArrayList<Move> move_history){

        this.move_history = move_history;

    }

    public Move_History clone() throws CloneNotSupportedException{

        ArrayList<Move> new_array = new ArrayList<>();

        for (Move i : move_history){

            new_array.add(i.clone());

        }

        return (new Move_History(new_array));

    }

    public void push(Move move){
        move_history.add(move);
    }

    public String toString(){
        
        String str = new String();
        
        for (Move i : move_history){
        
            str = i.toString() + '\n';
        
        }

        return str;

    }

    public Move getLastMove(){

        if (move_history.size() == 0){

            return null;

        }

        return move_history.get(move_history.size()-1);

    }

}
