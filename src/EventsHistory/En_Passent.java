package EventsHistory;

import Figures.Figure;

public class En_Passent extends Capture {
    

    public En_Passent(Move move, Figure slain_figure) {
        
        super(move, slain_figure);
    
    }

    @Override
    public String toString(){

        return (super.toString() + "e.p");

    }
    
}
