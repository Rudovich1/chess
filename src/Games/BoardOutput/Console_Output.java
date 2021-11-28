package Games.BoardOutput;

import Board.Board;
import ServingClasses.Coordinates;

public class Console_Output {

    public final static void clearConsole(){
    try{
       
        final String os = System.getProperty("os.name");

        if (os.contains("Windows")){

            Runtime.getRuntime().exec("cls");
        
        }
        else{

            Runtime.getRuntime().exec("clear");
        
        }
    }
    
    catch (final Exception e){
        
    }
}
    
    public static void output(Board board){

        clearConsole();

        for (int i = 0; i < 53; ++i){

            System.out.print("#");

        }
        System.out.print('\n');

        System.out.print("# ");
        for (int i = 0; i < 8; ++i){

            System.out.print(" ");
            for (int j = 0; j < 5;++j){

                System.out.print("_");

            }

        }
        System.out.println("  #");

        for (int i = 8;i>=1;--i){

            for (int l = 0; l < 3; ++l){

                System.out.print("# ");
                for (int j = 1;j<=8;++j){
                    
                    System.out.print("|");
                    if (l == 0 || l == 2){

                        if ((i+j) % 2 == 0){

                            System.out.print("     ");

                        } else {

                            System.out.print("█████");

                        }

                    } else if (l == 1){

                        if ((i+j) % 2 == 0){

                            System.out.print("  ");
                            if (board.getCage(new Coordinates(i, j)).getFigure() == null){

                                System.out.print(" ");    
                                
                            } else {

                                System.out.print(board.getCage(new Coordinates(i, j)).getFigure().toString());

                            }
                            System.out.print("  ");

                        } else {

                            System.out.print("█");
                            if (board.getCage(new Coordinates(i, j)).getFigure() == null){

                                System.out.print("███");    
                                
                            } else {

                                System.out.print("▌" + board.getCage(new Coordinates(i, j)).getFigure().toString() + "▐");

                            }
                            System.out.print("█");

                        }

                    }
                    

                }
                System.out.println("| #");
            
            }
        }

        System.out.print("# ");
        for (int i = 0; i < 8; ++i){

            System.out.print(" ");
            for (int j = 0; j < 5;++j){

                System.out.print("▔");

            }

        }
        System.out.println("  #");

        for (int i = 0; i < 53; ++i){

            System.out.print("#");

        }
        System.out.println();
    }
}
// ##############
//  _____ _____ _____ _____ _____ _____ _____ _____
// |     |█████|     |█████|     |█████|     |█████|
// |  A  |█▌A▐█|  A  |█▌A▐█|  A  |█▌A▐█|  A  |█▌A▐█|
// |     |█████|     |█████|     |█████|     |█████|
// |█████|     |█████|     |█████|     |█████|     |
// |█▌A▐█|  A  |█▌A▐█|  A  |█▌A▐█|  A  |█▌A▐█|  A  |
// |█████|     |█████|     |█████|     |█████|     |
// |     |█████|     |█████|     |█████|     |█████|
// |     |█████|     |█████|     |█████|     |█████|
// |     |█████|     |█████|     |█████|     |█████|
// |█████|     |█████|     |█████|     |█████|     |
// |█████|     |█████|     |█████|     |█████|     |
// |█████|     |█████|     |█████|     |█████|     |
// |     |█████|     |█████|     |█████|     |█████|
// |     |█████|     |█████|     |█████|     |█████|
// |     |█████|     |█████|     |█████|     |█████|
// |█████|     |█████|     |█████|     |█████|     |
// |█████|     |█████|     |█████|     |█████|     |
// |█████|     |█████|     |█████|     |█████|     |
// |     |█████|     |█████|     |█████|     |█████|
// |  A  |█▌A▐█|  A  |█▌A▐█|  A  |█▌A▐█|  A  |█▌A▐█|
// |     |█████|     |█████|     |█████|     |█████|
// |█████|     |█████|     |█████|     |█████|     |
// |█▌A▐█|  A  |█▌A▐█|  A  |█▌A▐█|  A  |█▌A▐█|  A  |
// |█████|     |█████|     |█████|     |█████|     |
 // ▔▔▔▔▔ ▔▔▔▔▔ ▔▔▔▔▔ ▔▔▔▔▔ ▔▔▔▔▔ ▔▔▔▔▔ ▔▔▔▔▔ ▔▔▔▔▔
