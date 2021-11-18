package Figures;

import java.util.ArrayList;
import ServingClasses.Colour;
import ServingClasses.Coordinates;

public class Pawn extends Figure{
    
    public Pawn(Colour colour) {

        super(colour);
        value = 1;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new Pawn(getColour());
        
    }
    
    @Override
    public int id(){
        
        if(this.getColour() == Colour.WHITE){
      
            return 0;
      
        } else {
      
            return 1;
      
        }
        
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
        
        int X = coordinates.toIterator().first;
        int Y = coordinates.toIterator().second;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();

        if (getColour() == Colour.WHITE){
            
            if (Y+1 < 8){
      
                array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
                array_of_available_coordinates.get(0).add(new Coordinates(X,Y+1));
      
            }

        } else if (getColour() == Colour.BLACK){
            
            if (Y-1 >= 0){
      
                array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
                array_of_available_coordinates.get(0).add(new Coordinates(X,Y-1));
      
            }

        }

        return array_of_available_coordinates;
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToAttack(Coordinates coordinates) {
        
        int X = coordinates.toIterator().first;
        int Y = coordinates.toIterator().second;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();

        if (getColour() == Colour.WHITE){
            
            if (Y+1 < 8 && X+1 < 8){
      
                array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
                array_of_available_coordinates.get(0).add(new Coordinates(X+1,Y+1));
      
            }

            if (Y+1 < 8 && X-1 >= 0){
      
                array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
                array_of_available_coordinates.get(1).add(new Coordinates(X-1,Y+1));
      
            }

        } else if (getColour() == Colour.BLACK){
            
            if (Y-1 < 8 && X+1 < 8){
      
                array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
                array_of_available_coordinates.get(0).add(new Coordinates(X+1,Y-1));
      
            }

            if (Y-1 < 8 && X-1 >= 0){
      
                array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
                array_of_available_coordinates.get(1).add(new Coordinates(X-1,Y-1));
      
            }

        }

        return array_of_available_coordinates;
    
    }

    @Override
    public String toString() {
        
        return "";

    }

}