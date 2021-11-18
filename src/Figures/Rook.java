package Figures;

import java.util.ArrayList;
import ServingClasses.Colour;
import ServingClasses.Coordinates;

public class Rook extends Figure{

    public boolean сastling;
    
    public Rook(Colour colour) {

        super(colour);
        value = 4;
        сastling = true;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new Rook(getColour());
        
    }

    @Override
    public int id(){

        if(this.getColour() == Colour.WHITE){
       
            return 6;
       
        } else {
       
            return 7;
       
        }

    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
       
        int X = coordinates.toIterator().first;
        int Y = coordinates.toIterator().second;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();

        if (7-Y != 0){
           
            array_of_available_coordinates.add(7-Y, new ArrayList<Coordinates>());
            
            for (int i = 1;i<=7-Y;++i){
       
                array_of_available_coordinates.get(0).add(new Coordinates(X, Y+i));
       
            }

        }

        if (X != 0){
           
            array_of_available_coordinates.add(X, new ArrayList<Coordinates>());
            
            for (int i = 1;i<=X;++i){
       
                array_of_available_coordinates.get(1).add(new Coordinates(X-i, Y));
       
            }

        }

        if (Y != 0){
           
            array_of_available_coordinates.add(Y, new ArrayList<Coordinates>());
            
            for (int i = 1;i<=Y;++i){
       
                array_of_available_coordinates.get(2).add(new Coordinates(X, Y-i));
       
            }

        }

        if (7-X != 0){
           
            array_of_available_coordinates.add(7-X, new ArrayList<Coordinates>());
            
            for (int i = 1;i<=7-X;++i){
       
                array_of_available_coordinates.get(3).add(new Coordinates(X+i, Y));
       
            }

        }

        return array_of_available_coordinates;
    
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToAttack(Coordinates coordinates) {

        return CoordinatesToMove(coordinates);

    }

    @Override
    public String toString() {
        
        return "R";

    }

}