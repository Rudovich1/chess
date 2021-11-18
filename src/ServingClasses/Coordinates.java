package ServingClasses;

public class Coordinates implements Cloneable {

    private Pair<Character,Integer> coordinates = null;

    public Coordinates(Character letter, Integer number){
       
        coordinates = new Pair<Character,Integer>(letter, number);
    
    }

    public Coordinates clone() throws CloneNotSupportedException{

        return new Coordinates(toIterator().first, toIterator().second);

    }

    public Coordinates(Integer number1, Integer number2){

        coordinates = new Pair<Character,Integer>((char)(number1+'a'), number2);

    }

    public Pair<Integer,Integer> toIterator(){

        if (coordinates == null){
            
            return null;

        }
        
        return new Pair<Integer,Integer>(coordinates.first.charValue()-'a', coordinates.second - 1);
    
    }

    public String toString(){

        if (coordinates == null){
            
            return null;

        }

        return new String(coordinates.first.toString() + coordinates.second);
    
    }

    
}
