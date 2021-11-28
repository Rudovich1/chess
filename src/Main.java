import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Games.Classic_Chess_Game;

public class Main {
    
    public static void main(String[] args) throws CloneNotSupportedException{

        BufferedReader input_movements = null;
        try {
            
            Scanner in = new Scanner(System.in);
            String file_name = in.nextLine();
            FileReader fr = new FileReader(file_name);
            input_movements = new BufferedReader(fr);

        } catch (Throwable e) {
            
            input_movements = null;

        }

        Classic_Chess_Game game = new Classic_Chess_Game(input_movements);
        game.processGame();

    }

}
