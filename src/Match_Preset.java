public class Match_Preset {
    final private int first_player_timer, second_player_timer;
    final private Colour first_player_colour;
    final private Board start_position; 
    Match_Preset(int first_player_timer, int second_player_timer, Colour first_player_colour){
        this.first_player_colour = first_player_colour;
        this.first_player_timer = first_player_timer;
        this.second_player_timer = second_player_timer;
        start_position = new Board();
    }
    /* --Загрузка кастомной позиции--

    Match_Preset(int first_player_timer, int second_player_timer, Colour first_player_colour, Board start_posirion){
        this.first_player_colour = first_player_colour;
        this.first_player_timer = first_player_timer;
        this.second_player_timer = second_player_timer;
        start_position = new Board();
    }
    */
    public int setFirst_player_timer(){
        return first_player_timer;
    }
    public int setSecond_player_timer(){
        return second_player_timer;
    }
    public Colour setFirst_player_colour(){
        return first_player_colour;
    }
    public Board setBoard(){
        return start_position;
    }
}
