package Figures;

import java.util.ArrayList;
import ServingClasses.Colour;
import ServingClasses.Coordinates;

public class Knight extends Figure{

    public Knight(Colour colour) {

        super(colour);
        value = 3;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new Knight(getColour());
        
    }

    @Override
    public int id(){
        
        if(this.getColour() == Colour.WHITE){
      
            return 2;
      
        } else {
      
            return 3;
      
        }

    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
        
        int X = coordinates.toIterator().first;
        int Y = coordinates.toIterator().second;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();
        
        if (Y+2 < 8 && X-1 >= 0){
      
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(0).add(new Coordinates(X-1,Y+2));
      
        }

        if (Y+2 < 8 && X+1 < 8){
      
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(1).add(new Coordinates(X+1,Y+2));
      
        }

        if (Y-2 >= 0 && X-1 >= 0){
      
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(2).add(new Coordinates(X-1,Y-2));
      
        }
        
        if (Y-2 >= 0 && X+1 < 8){
      
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(3).add(new Coordinates(X+1,Y-2));
      
        }
        
        if (Y+1 < 8 && X-2 >= 0){
      
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(4).add(new Coordinates(X-2,Y+1));
      
        }
        
        if (Y+1 < 8 && X+2 < 8){
      
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(5).add(new Coordinates(X+2,Y+1));
      
        }
        
        if (Y-1 >= 0 && X-2 >= 0){
      
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(6).add(new Coordinates(X-2,Y-1));
      
        }
        
        if (Y-1 >= 0 && X+2 < 8){
      
            array_of_available_coordinates.add(1,new ArrayList<Coordinates>());
            array_of_available_coordinates.get(7).add(new Coordinates(X+2,Y-1));
      
        }
        
        return array_of_available_coordinates;
    
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToAttack(Coordinates coordinates) {
        
        return CoordinatesToMove(coordinates);
    
    }

    @Override
    public String toString() {
        
        return "N";

    }
}
