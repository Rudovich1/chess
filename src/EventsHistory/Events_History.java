package EventsHistory;

import java.util.ArrayList;

public class Events_History implements Cloneable{
    
    ArrayList<Event> events_history;

    public Events_History(){

        events_history = new ArrayList<Event>();

    }

    public Events_History(ArrayList<Event> events_history){

        this.events_history = events_history;

    }

    public Events_History clone() throws CloneNotSupportedException{

        ArrayList<Event> new_events_history = new ArrayList<>();

        for (Event i : events_history){

            new_events_history.add(i.clone());

        }

        return (new Events_History(new_events_history));

    }

    public void push(Event event){

        events_history.add(event);
    
    }

    public String toString(){
        
        String str = new String();
        
        for (Event i : events_history){
        
            str += i.toString() + '\n';
        
        }

        return str;

    }

    public Event getLastEvent(){

        if (events_history.size() == 0){

            return null;

        }

        return events_history.get(events_history.size()-1);

    }

}
