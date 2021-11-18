package ServingClasses;

public class Pair<T1,T2> implements Cloneable{
    
    public T1 first;
    public T2 second;

    public Pair(T1 first, T2 second){
        
        this.first = first;
        this.second = second;
    
    }

    public Pair<T1,T2> clone() throws CloneNotSupportedException{

        return (new Pair<T1,T2>(first,second));

    }
}

