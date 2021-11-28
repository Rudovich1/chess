package Figures;

import java.util.ArrayList;
import ServingClasses.Color;
import ServingClasses.Coordinates;

public class Rook extends Figure{

    public boolean сastling;
    
    public Rook(Color Color) {

        super(Color);
        value = 4;
        сastling = true;
    
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        
        return new Rook(getColor());
        
    }

    @Override
    public int id(){

        if(this.getColor() == Color.WHITE){
       
            return 6;
       
        } else {
       
            return 7;
       
        }

    }

    @Override
    public ArrayList<ArrayList<Coordinates>> CoordinatesToMove(Coordinates coordinates) {
       
        int X = coordinates.toIterator().second;
        int Y = coordinates.toIterator().first;
        ArrayList<ArrayList<Coordinates>> array_of_available_coordinates = new ArrayList<ArrayList<Coordinates>>();

        if (8-Y != 0){
           
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            
            for (int i = 1;i<=8-Y;++i){
     
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y+i, X));
     
            }

        }

        if (X != 1){
           
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            
            for (int i = 1;i<=X-1;++i){
     
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y, X-i));
     
            }

        }

        if (Y != 1){
           
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            
            for (int i = 1;i<=Y-1;++i){
     
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y-i, X));
     
            }

        }

        if (8-X != 0){
           
            array_of_available_coordinates.add(new ArrayList<Coordinates>());
            
            for (int i = 1;i<=8-X;++i){
     
                array_of_available_coordinates.get(array_of_available_coordinates.size()-1).add(new Coordinates(Y, X+i));
     
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

            return "R";

        } else {

            return "r";

        }

    }

}