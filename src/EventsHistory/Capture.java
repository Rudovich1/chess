package EventsHistory;

import Figures.Figure;
import ServingClasses.Coordinates;

public class Capture extends Move {

    Figure slain_figure;
    
    public Capture(Coordinates start, Coordinates finish, Figure figure, Figure slain_figure) {
        
        super(start, finish, figure);
        this.slain_figure = slain_figure;
        
    }

    public Capture(Move move, Figure slain_figure){

        super(move.getMove().first.first, move.getMove().first.second, move.getMove().second);
        this.slain_figure = slain_figure;

    }

    @Override
    public Move clone() throws CloneNotSupportedException {
        
        return new Capture(super.clone(),slain_figure.clone());

    }

    @Override
    public String toString() {

        return (getMove().second.toString() + getMove().first.first + "x" + getMove().first.second);

    }
    
}
