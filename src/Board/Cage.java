package Board;
import Figures.Figure;

public class Cage implements Cloneable{

    private Figure figure = null;
    
    public Cage(){

        this.figure = null;

    }

    public Cage(Figure figure){
   
        this.figure = figure;
   
    }

    public Cage clone() throws CloneNotSupportedException{

        return (new Cage(figure == null ? null : figure.clone()));

    }
    
    public void setFigure(Figure figure){
    
        this.figure = figure;
    
    }
    
    public Figure getFigure(){

        return figure;
    
    }
}