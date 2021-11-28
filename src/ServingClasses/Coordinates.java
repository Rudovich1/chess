package ServingClasses;

public class Coordinates implements Cloneable {

    private Pair<Integer,Character> coordinates = null;

    public Coordinates(Character letter, Integer number){
       
        coordinates = new Pair<Integer,Character>(number, letter);
    
    }

    public Coordinates clone() throws CloneNotSupportedException{

        return new Coordinates(toIterator().first, toIterator().second);

    }

    public Coordinates(Integer number1, Integer number2){

        coordinates = new Pair<Integer,Character>(number1, (char)(number2 + 'a' - 1));

    }

    public Pair<Integer,Integer> toIterator(){

        if (coordinates == null){
            
            return null;

        }
        
        return new Pair<Integer,Integer>(coordinates.first, coordinates.second.charValue()-'a' + 1);
    
    }

    public String toString(){

        if (coordinates == null){
            
            return null;

        }

        return new String(coordinates.second.toString() + coordinates.first);
    
    }

    public boolean equals(Coordinates coordinates){

        return (coordinates.toIterator().first == this.toIterator().first && coordinates.toIterator().second == this.toIterator().second);

    }

    
}
