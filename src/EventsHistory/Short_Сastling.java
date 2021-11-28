package EventsHistory;

public class Short_Сastling extends Event {

    

    @Override
    public Event clone() throws CloneNotSupportedException {

        return (new Short_Сastling());

    }

    @Override
    public String toString() {
        
        return "0-0";

    }
    
}
