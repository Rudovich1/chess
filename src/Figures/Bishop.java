package Figures;

import java.util.ArrayList;
import ServingClasses.Color;
import ServingClasses.Coordinates;

public class Bishop extends Figure{

    public Bishop(Color Color) {

        super(Color);
        value = 3;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new Bishop(getColor());
        
    }

    @Override
    public int id(){
    
        if(this.getColor() == Color.WHITE){
         
            return 4;
        
        } else {
        
            return 5;
        
        }
    
    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
        
        int X = coordinates.toIterator().second;
        int Y = coordinates.toIterator().first;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();

        if (Math.min(8-Y,X-1) != 0){
           
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            
            for (int i = 1;i<=Math.min(8-Y,X-1);++i){
         
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+i, X-i));
         
            }

        }

        if (Math.min(Y-1,X-1) != 0){
           
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
           
            for (int i = 1;i<=Math.min(Y-1,X-1);++i){
         
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-i, X-i));
         
            }

        }

        if (Math.min(Y-1, 8-X) != 0){
           
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
           
            for (int i = 1;i<=Math.min(Y-1, 8-X);++i){
         
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-i, X+i));
         
            }

        }

        if (Math.min(8-Y,8-X) != 0){
           
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
           
            for (int i = 1;i<=Math.min(8-Y,8-X);++i){
         
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+i, X+i));
         
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
        
        if (this.getColor() == Color.WHITE){

            return "B";

        } else {

            return "b";

        }

    }

}
