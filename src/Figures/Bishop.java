package Figures;

import java.util.ArrayList;
import ServingClasses.Colour;
import ServingClasses.Coordinates;

public class Bishop extends Figure{

    public Bishop(Colour colour) {

        super(colour);
        value = 3;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new Bishop(getColour());
        
    }

    @Override
    public int id(){
    
        if(this.getColour() == Colour.WHITE){
         
            return 4;
        
        } else {
        
            return 5;
        
        }
    
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
        
        int X = coordinates.toIterator().first;
        int Y = coordinates.toIterator().second;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();

        if (Math.min(7-Y,X) != 0){
           
            array_of_available_coordinates.add(Math.min(7-Y,X), new ArrayList<Coordinates>());
            
            for (int i = 1;i<=Math.min(7-Y,X);++i){
         
                array_of_available_coordinates.get(0).add(new Coordinates(X-i, Y+i));
         
            }

        }

        if (Math.min(Y,X) != 0){
           
            array_of_available_coordinates.add(Math.min(Y,X), new ArrayList<Coordinates>());
           
            for (int i = 1;i<=Math.min(Y,X);++i){
         
                array_of_available_coordinates.get(1).add(new Coordinates(X-i, Y-i));
         
            }

        }

        if (Math.min(Y,7-X) != 0){
           
            array_of_available_coordinates.add(Math.min(Y,7-X), new ArrayList<Coordinates>());
           
            for (int i = 1;i<=Math.min(Y,7-X);++i){
         
                array_of_available_coordinates.get(2).add(new Coordinates(X+i, Y-i));
         
            }

        }

        if (Math.min(7-Y,7-X) != 0){
           
            array_of_available_coordinates.add(Math.min(7-Y,7-X), new ArrayList<Coordinates>());
           
            for (int i = 1;i<=Math.min(7-Y,7-X);++i){
         
                array_of_available_coordinates.get(3).add(new Coordinates(X+i, Y+i));
         
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
        
        return "B";

    }

}
