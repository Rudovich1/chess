package Figures;

import java.util.ArrayList;
import ServingClasses.Colour;
import ServingClasses.Coordinates;

public abstract class Figure implements Cloneable{

    private Colour figure_colour;
    static int value;

    Figure(Colour colour){

        this.figure_colour = colour;
    
    }

    abstract public Figure clone() throws CloneNotSupportedException;

    public Colour getColour(){

        return figure_colour;
    
    }

    abstract public int id();
    abstract public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates);
    abstract public ArrayList<ArrayList<Coordinates>> CoordinatesToAttack(Coordinates coordinates);
    abstract public String toString();
}

