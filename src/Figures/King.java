package Figures;

import java.util.ArrayList;
import ServingClasses.Color;
import ServingClasses.Coordinates;

public class King extends Figure{

    public boolean сastling;
   
    public King(Color Color) {
        
        super(Color);
        value = 0;
        сastling = true;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new King(getColor());
        
    }

    @Override
    public int id(){
       
        if(this.getColor() == Color.WHITE){
       
            return 10;
       
        } else {
       
            return 11;
       
        }
    
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
        
        int X = coordinates.toIterator().second;
        int Y = coordinates.toIterator().first;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();
        
        if (Y+1 <= 8){
       
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+1, X));
       
        }

        if (Y+1 <= 8 && X+1 <= 8){
       
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+1, X+1));
       
        }

        if (X+1 <= 8){
       
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y, X+1));
       
        }

        if (Y-1 >= 1 && X+1 <= 8){
       
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-1, X+1));
       
        }

        if (Y-1 >= 1){
       
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-1, X));
       
        }

        if (Y-1 >= 1 && X-1 >= 1){
       
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-1,X-1));
       
        }

        if (X-1 >= 1){
       
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y, X-1));
       
        }

        if (Y+1 <= 8 && X-1 >= 1){
       
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+1, X-1));
       
        }

        return array_of_available_coordinates;
    
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToAttack(Coordinates coordinates) {

        return CoordinatesToMove(coordinates);
    
    }

    @Override
    public String toString() {
       
        if (this.getColor() == Color.WHITE){

            return "K";

        } else {

            return "k";

        }

    }

}
