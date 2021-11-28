package EventsHistory;

import Figures.Figure;

public class Promotion extends Event{
    
    Move pawn_move;
    Figure new_figure;

    public Promotion(Move pawn_move, Figure new_figure){

        this.pawn_move = pawn_move;
        this.new_figure = new_figure;

    }

    @Override
    public Event clone() throws CloneNotSupportedException {
        
        return new Promotion(pawn_move.clone(), new_figure.clone());

    }

    @Override
    public String toString() {
        
        return pawn_move.toString() + new_figure.toString();

    }



}
