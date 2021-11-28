package Games;

import Matches.Classic_Сhess_Match;
import ServingClasses.Color;
import ServingClasses.Coordinates;
import ServingClasses.Game_state;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import EventsHistory.Event;
import Games.BoardOutput.Console_Output;
import MatchPresets.Classic_Match_Preset;

public class Classic_Chess_Game extends Abstract_Game {
    
    Classic_Сhess_Match classic_chess_match = null;
    
   BufferedReader input_movements; //-------------------------------------------------------------------------------------------------- DEBUG

    public  Classic_Chess_Game(){

        classic_chess_match = new Classic_Сhess_Match(new Classic_Match_Preset());

    }

    public Classic_Chess_Game(BufferedReader input_movements){ //---------------------------------------------------------------------------- DEBUG

        classic_chess_match = new Classic_Сhess_Match(new Classic_Match_Preset());
        this.input_movements = input_movements;

    }

    private boolean processMove(String move) throws CloneNotSupportedException{

        if (move.equals("0-0") || move.equals("0-0-0")){

            //....

        }
        if (move.length() != 5){
            
            return true;
        
        }
        if (move.charAt(0) < 'a' || move.charAt(0) > 'h' || move.charAt(1) < '1' || move.charAt(1) > '8' ||
            move.charAt(3) < 'a' || move.charAt(3) > 'h' || move.charAt(4) < '1' || move.charAt(4) > '8' || move.charAt(2) != '-'){
            
            return true;

        }

        Coordinates start = new Coordinates(move.charAt(0), move.charAt(1)-'0');
        Coordinates finish = new Coordinates(move.charAt(3), move.charAt(4)-'0');
        if (classic_chess_match.checkMove(start, finish, classic_chess_match.getGameState() == Game_state.WHITE_MOVE ? Color.WHITE : Color.BLACK)){

            classic_chess_match.move(start, finish);
            return false;

        }

        return true;

    }

    public void processGame() throws CloneNotSupportedException{

        while(classic_chess_match.getGameState() == Game_state.START_GAME || 
              classic_chess_match.getGameState() == Game_state.WHITE_MOVE || 
              classic_chess_match.getGameState() == Game_state.BLACK_MOVE){

            if (classic_chess_match.getGameState() == Game_state.START_GAME){


                if (classic_chess_match.getAbstractMatchPreset().getFirstPlayerColor() == Color.WHITE){

                    // ... Первый играет белыми 

                } else {

                    // ... Второй играет белыми

                }
                
                classic_chess_match.setGameState(Game_state.WHITE_MOVE); 

            } else {
                
                if (input_movements != null){
                    try {

                        String move;
                        do{
                    
                            move = input_movements.readLine();
                            if (move == null){

                                throw new IOException();

                            }
                            System.out.println(move);
                        } while(processMove(move));
                    
                    } catch (IOException e) {
                        
                        input_movements = null;
                        
                    }

                }
                if (input_movements == null){
                    
                    Scanner in;
                    String move;

                    do{
                    
                        in = new Scanner(System.in);
                        move = in.next();
                    
                    }while(processMove(move));

                }

                if (classic_chess_match.getGameState() == Game_state.BLACK_MOVE){

                    classic_chess_match.setGameState(Game_state.WHITE_MOVE);

                } else if (classic_chess_match.getGameState() == Game_state.WHITE_MOVE){

                    classic_chess_match.setGameState(Game_state.BLACK_MOVE);
                
                }

                if (classic_chess_match.checkForMate(classic_chess_match.getGameState() == Game_state.WHITE_MOVE ? Color.WHITE : Color.BLACK)){ //... Мат 

                    if (classic_chess_match.getGameState() == Game_state.WHITE_MOVE){

                        classic_chess_match.setGameState(Game_state.BlACK_VICTORY);

                    }else {

                        classic_chess_match.setGameState(Game_state.WHITE_VICTORY);

                    }

                }

                if (classic_chess_match.checkForDraw()){    //...  Ничья  

                    classic_chess_match.setGameState(Game_state.END_GAME);

                }

                if (classic_chess_match.checkForStalemate(classic_chess_match.getGameState() == Game_state.WHITE_MOVE ? Color.WHITE : Color.BLACK)){ //... Пат

                    classic_chess_match.setGameState(Game_state.STALEMATE);

                }

            }

            Console_Output.output(classic_chess_match.getBoard());

        }

        if (classic_chess_match.getGameState() == Game_state.WHITE_VICTORY){

            System.out.println(" White victory!");

        } else if (classic_chess_match.getGameState() == Game_state.BlACK_VICTORY){

            System.out.println(" Black victory!");

        }

        System.out.println(classic_chess_match.getEventsHistory().toString()); //---------------------------------------------------- DEBUG

    }

}
