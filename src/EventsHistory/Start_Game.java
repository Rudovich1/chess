package EventsHistory;

public class Start_Game extends Event{

    @Override
    public Event clone() throws CloneNotSupportedException {
       
        return new Start_Game();
    
    }

    @Override
    public String toString() {
        
        return "Start Game!";
   
    }
    
}
