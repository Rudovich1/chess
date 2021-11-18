package Figures;

import java.util.ArrayList;
import ServingClasses.Colour;
import ServingClasses.Coordinates;

public class King extends Figure{

    public boolean сastling;
   
    public King(Colour colour) {
        
        super(colour);
        value = 0;
        сastling = true;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new King(getColour());
        
    }

    @Override
    public int id(){
       
        if(this.getColour() == Colour.WHITE){
       
            return 10;
       
        } else {
       
            return 11;
       
        }
    
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
        
        int X = coordinates.toIterator().first;
        int Y = coordinates.toIterator().second;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();
        
        if (Y+1 < 8){
       
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(0).add(new Coordinates(X,Y+1));
       
        }

        if (Y+1 < 8 && X+1 < 8){
       
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(1).add(new Coordinates(X+1,Y+1));
       
        }

        if (X+1 < 8){
       
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(2).add(new Coordinates(X+1,Y));
       
        }

        if (Y-1 >= 0 && X+1 < 8){
       
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(3).add(new Coordinates(X+1,Y-1));
       
        }

        if (Y-1 >= 0){
       
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(4).add(new Coordinates(X,Y-1));
       
        }

        if (Y-1 >= 0 && X-1 >= 0){
       
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(5).add(new Coordinates(X-1,Y-1));
       
        }

        if (X-1 >= 0){
       
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(6).add(new Coordinates(X-1,Y));
       
        }

        if (Y+1 < 8 && X-1 >= 0){
       
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(7).add(new Coordinates(X-1,Y+1));
       
        }

        return array_of_available_coordinates;
    
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToAttack(Coordinates coordinates) {

        return CoordinatesToMove(coordinates);
    
    }

    @Override
    public String toString() {
       
        return "K";

    }

}
