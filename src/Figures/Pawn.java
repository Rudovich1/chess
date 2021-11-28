package Figures;

import java.util.ArrayList;
import ServingClasses.Color;
import ServingClasses.Coordinates;

public class Pawn extends Figure{

    boolean long_move = true;
    
    public Pawn(Color Color) {

        super(Color);
        value = 1;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new Pawn(getColor());
        
    }
    
    @Override
    public int id(){
        
        if(this.getColor() == Color.WHITE){
      
            return 0;
      
        } else {
      
            return 1;
      
        }
        
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
        
        int X = coordinates.toIterator().second;
        int Y = coordinates.toIterator().first;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();

        if (getColor() == Color.WHITE){
            
            if (Y+1 <= 8){
      
                array_of_available_coordinates.add(new ArrayList<Coordinates>());
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+1,X));
      
            }

            if (long_move){

                array_of_available_coordinates.add(new ArrayList<Coordinates>());
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+2, X));

            }

        } else if (getColor() == Color.BLACK){
            
            if (Y-1 >= 1){
      
                array_of_available_coordinates.add(new ArrayList<Coordinates>());
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-1, X));
      
            }

            if (long_move){

                array_of_available_coordinates.add(new ArrayList<Coordinates>());
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-2, X));

            }

        }

        return array_of_available_coordinates;
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToAttack(Coordinates coordinates) {
        
        int X = coordinates.toIterator().second;
        int Y = coordinates.toIterator().first;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();

        if (getColor() == Color.WHITE){
            
            if (Y+1 <= 8 && X+1 <= 8){
      
                array_of_available_coordinates.add(new ArrayList<Coordinates>());
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+1,X+1));
      
            }

            if (Y+1 <= 8 && X-1 >= 1){
      
                array_of_available_coordinates.add(new ArrayList<Coordinates>());
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+1, X-1));
      
            }

        } else if (getColor() == Color.BLACK){
            
            if (Y-1 <= 8 && X+1 <= 8){
      
                array_of_available_coordinates.add(new ArrayList<Coordinates>());
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-1, X+1));
      
            }

            if (Y-1 <= 8 && X-1 >= 1){
      
                array_of_available_coordinates.add(new ArrayList<Coordinates>());
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-1, X-1));
      
            }

        }

        return array_of_available_coordinates;
    
    }

    @Override
    public String toString() {
        
        if (this.getColor() == Color.WHITE){

            return "P";

        } else {

            return "p";

        }

    }

    public void setLongMove(){

        long_move = false;

    }

}