package Figures;

import java.util.ArrayList;
import ServingClasses.Color;
import ServingClasses.Coordinates;

public abstract class Figure implements Cloneable{

    private Color figure_Color;
    static int value;

    Figure(Color Color){

        this.figure_Color = Color;
    
    }

    abstract public Figure clone() throws CloneNotSupportedException;

    public Color getColor(){

        return figure_Color;
    
    }

    abstract public int id();
    abstract public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates);
    abstract public ArrayList<ArrayList<Coordinates>> CoordinatesToAttack(Coordinates coordinates);
    abstract public String toString();
}

