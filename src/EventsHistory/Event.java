package EventsHistory;

public abstract class Event implements Cloneable{

    abstract public Event clone() throws CloneNotSupportedException;
    abstract public String toString();

}
