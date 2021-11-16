import javax.lang.model.type.NullType;

abstract class Abstract_Match {
    Board board;
    enum Player_state{
        CHECK,
        MATE,
        STALEMATE,
        NORMAL;
    }
    Player_state first_player_state;
    Player_state second_player_state;
    enum Game_state{
        WHITE_MOVE,
        BLACK_MOVE,
        END_GAME,
        START_GAME;
    }
    Game_state game_state;
    Match_Preset match_preset;
    int first_player_timer;
    int second_player_timer;

    Abstract_Match(Match_Preset match_preset){
        this.match_preset = match_preset;
        first_player_timer = match_preset.setFirst_player_timer();
        second_player_timer = match_preset.setSecond_player_timer();
        board = match_preset.setBoard();
        game_state = Game_state.START_GAME;
    }

    private Coordinates find_figure(Figure figure){
        for (int i = 0;i<8;++i){
            for (int j = 0;j<8;++j){
                if (board.getCage(i,j).getFigure().id() == figure.id()){
                    return (new Coordinates(i, j));
                }
            }
        }
        return null;
    }

    private boolean check_for_check() {
        if (game_state == Game_state.WHITE_MOVE){

            Coordinates king_coordinates = find_figure(new King(Colour.BLACK));

            int X = king_coordinates.first, Y = king_coordinates.second;
            if (Y-1 >= 0 && ((X-1 >= 0 && board.getCage(X-1,Y-1).getFigure().id() == 0) || (X+1 < 8 && board.getCage(X+1,Y-1).getFigure().id() == 0))){
                return true;
            }
            
            if ((Y+2 < 8 && ((X-1 >= 0 && board.getCage(X-1,Y+2).getFigure().id() == 2) || (X+1 < 8 && board.getCage(X+1,Y+2).getFigure().id() == 2))) ||
                (Y-2 >= 0 && ((X-1 >= 0 && board.getCage(X-1,Y-2).getFigure().id() == 2) || (X+1 < 8 && board.getCage(X+1,Y-2).getFigure().id() == 2))) || 
                (X-2 >= 0 && ((Y-1 >= 0 && board.getCage(X-2,Y-1).getFigure().id() == 2) || (Y+1 < 8 && board.getCage(X-2,Y+1).getFigure().id() == 2))) || 
                (X+2 < 8 && ((Y-1 >= 0 && board.getCage(X+2,Y-1).getFigure().id() == 2) || (Y+1 < 8 && board.getCage(X+2,Y+1).getFigure().id() == 2)))){
                return true;
            }

            int temp_X = X - 1;
            while(temp_X >= 0){
                if (board.getCage(temp_X,Y).getFigure() != null){
                    if (board.getCage(temp_X,Y).getFigure().id() == 6 || board.getCage(temp_X,Y).getFigure().id() == 8){
                        return true;
                    } else {
                        break;
                    }
                }
                --temp_X;
            }
            
            temp_X = X + 1;
            while(temp_X < 8){
                if (board.getCage(temp_X,Y).getFigure() != null){
                    if (board.getCage(temp_X,Y).getFigure().id() == 6 || board.getCage(temp_X,Y).getFigure().id() == 8){
                        return true;
                    } else {
                        break;
                    }
                }
                ++temp_X;
            } 
            
            int temp_Y = Y - 1;
            while(temp_Y >= 0){
                if (board.getCage(X,temp_Y).getFigure() != null){
                    if (board.getCage(X,temp_Y).getFigure().id() == 6 || board.getCage(X,temp_Y).getFigure().id() == 8){
                        return true;
                    } else {
                        break;
                    }
                }
                --temp_Y;
            } 
           
            temp_Y = Y + 1;
            while(temp_Y < 8){
                if (board.getCage(X,temp_Y).getFigure() != null){
                    if (board.getCage(X,temp_Y).getFigure().id() == 6 || board.getCage(X,temp_Y).getFigure().id() == 8){
                        return true;
                    } else {
                        break;
                    }
                }
                ++temp_Y;
            }
           
            temp_X = X + 1; temp_Y = Y + 1;
            while(temp_Y < 8 && temp_X < 8){
                if (board.getCage(temp_X,temp_Y).getFigure() != null){
                    if (board.getCage(temp_X,temp_Y).getFigure().id() == 4 || board.getCage(temp_X,temp_Y).getFigure().id() == 8){
                        return true;
                    } else {
                        break;
                    }
                }
                ++temp_X;
                ++temp_Y;
            }

            temp_X = X + 1; temp_Y = Y - 1;
            while(temp_Y >= 0 && temp_X < 8){
                if (board.getCage(temp_X,temp_Y).getFigure() != null){
                    if (board.getCage(temp_X,temp_Y).getFigure().id() == 4 || board.getCage(temp_X,temp_Y).getFigure().id() == 8){
                        return true;
                    } else {
                        break;
                    }
                }
                ++temp_X;
                --temp_Y;
            }

            temp_X = X - 1; temp_Y = Y + 1;
            while(temp_Y < 8 && temp_X >= 0){
                if (board.getCage(temp_X,temp_Y).getFigure() != null){
                    if (board.getCage(temp_X,temp_Y).getFigure().id() == 4 || board.getCage(temp_X,temp_Y).getFigure().id() == 8){
                        return true;
                    } else {
                        break;
                    }
                }
                --temp_X;
                ++temp_Y;
            }
        
            temp_X = X - 1; temp_Y = Y - 1;
            while(temp_Y >= 0 && temp_X >= 0){
                if (board.getCage(temp_X,temp_Y).getFigure() != null){
                    if (board.getCage(temp_X,temp_Y).getFigure().id() == 4 || board.getCage(temp_X,temp_Y).getFigure().id() == 8){
                        return true;
                    } else {
                        break;
                    }
                }
                --temp_X;
                --temp_Y;
            }
        
        } else if (game_state == Game_state.BLACK_MOVE){

            Coordinates king_coordinates = find_figure(new King(Colour.WHITE));
            int X = king_coordinates.first, Y = king_coordinates.second;
            if (Y-1 >= 0 && ((X-1 >= 0 && board.getCage(X-1,Y-1).getFigure().id() == 1) || (X+1 < 8 && board.getCage(X+1,Y-1).getFigure().id() == 1))){
                return true;
            }
            
            if ((Y+2 < 8 && ((X-1 >= 0 && board.getCage(X-1,Y+2).getFigure().id() == 3) || (X+1 < 8 && board.getCage(X+1,Y+2).getFigure().id() == 3))) ||
                (Y-2 >= 0 && ((X-1 >= 0 && board.getCage(X-1,Y-2).getFigure().id() == 3) || (X+1 < 8 && board.getCage(X+1,Y-2).getFigure().id() == 3))) || 
                (X-2 >= 0 && ((Y-1 >= 0 && board.getCage(X-2,Y-1).getFigure().id() == 3) || (Y+1 < 8 && board.getCage(X-2,Y+1).getFigure().id() == 3))) || 
                (X+2 < 8 && ((Y-1 >= 0 && board.getCage(X+2,Y-1).getFigure().id() == 3) || (Y+1 < 8 && board.getCage(X+2,Y+1).getFigure().id() == 3)))){
                return true;
            }

            int temp_X = X - 1;
            while(temp_X >= 0){
                if (board.getCage(temp_X,Y).getFigure() != null){
                    if (board.getCage(temp_X,Y).getFigure().id() == 7 || board.getCage(temp_X,Y).getFigure().id() == 9){
                        return true;
                    } else {
                        break;
                    }
                }
                --temp_X;
            }
            
            temp_X = X + 1;
            while(temp_X < 8){
                if (board.getCage(temp_X,Y).getFigure() != null){
                    if (board.getCage(temp_X,Y).getFigure().id() == 7 || board.getCage(temp_X,Y).getFigure().id() == 9){
                        return true;
                    } else {
                        break;
                    }
                }
                ++temp_X;
            } 
            
            int temp_Y = Y - 1;
            while(temp_Y >= 0){
                if (board.getCage(X,temp_Y).getFigure() != null){
                    if (board.getCage(X,temp_Y).getFigure().id() == 7 || board.getCage(X,temp_Y).getFigure().id() == 9){
                        return true;
                    } else {
                        break;
                    }
                }
                --temp_Y;
            } 
           
            temp_Y = Y + 1;
            while(temp_Y < 8){
                if (board.getCage(X,temp_Y).getFigure() != null){
                    if (board.getCage(X,temp_Y).getFigure().id() == 7 || board.getCage(X,temp_Y).getFigure().id() == 9){
                        return true;
                    } else {
                        break;
                    }
                }
                ++temp_Y;
            }
           
            temp_X = X + 1; temp_Y = Y + 1;
            while(temp_Y < 8 && temp_X < 8){
                if (board.getCage(temp_X,temp_Y).getFigure() != null){
                    if (board.getCage(temp_X,temp_Y).getFigure().id() == 5 || board.getCage(temp_X,temp_Y).getFigure().id() == 9){
                        return true;
                    } else {
                        break;
                    }
                }
                ++temp_X;
                ++temp_Y;
            }

            temp_X = X + 1; temp_Y = Y - 1;
            while(temp_Y >= 0 && temp_X < 8){
                if (board.getCage(temp_X,temp_Y).getFigure() != null){
                    if (board.getCage(temp_X,temp_Y).getFigure().id() == 5 || board.getCage(temp_X,temp_Y).getFigure().id() == 9){
                        return true;
                    } else {
                        break;
                    }
                }
                ++temp_X;
                --temp_Y;
            }

            temp_X = X - 1; temp_Y = Y + 1;
            while(temp_Y < 8 && temp_X >= 0){
                if (board.getCage(temp_X,temp_Y).getFigure() != null){
                    if (board.getCage(temp_X,temp_Y).getFigure().id() == 5 || board.getCage(temp_X,temp_Y).getFigure().id() == 9){
                        return true;
                    } else {
                        break;
                    }
                }
                --temp_X;
                ++temp_Y;
            }
        
            temp_X = X - 1; temp_Y = Y - 1;
            while(temp_Y >= 0 && temp_X >= 0){
                if (board.getCage(temp_X,temp_Y).getFigure() != null){
                    if (board.getCage(temp_X,temp_Y).getFigure().id() == 5 || board.getCage(temp_X,temp_Y).getFigure().id() == 9){
                        return true;
                    } else {
                        break;
                    }
                }
                --temp_X;
                --temp_Y;
            }
        
        }
        return false;
    }
    private void check_for_mate() {
        //...
    }
    private void check_for_stalemate() {
        //...
    }
    private void check_for_draw() {
        //...
    }
    private boolean add_figure(Coordinates coordinates, Figure figure){
        if (board.getCage(coordinates) != null){
            return false;
        }
        board.setCage(coordinates, figure);
        return true;
    }
    private boolean check_move(Coordinates start, Coordinates finish){
        //...
        return true;
    }
    private boolean move(Coordinates start, Coordinates finish){
        if (!check_move(start,finish)){
            return false;
        }
        //...
        return true;
    }

}
