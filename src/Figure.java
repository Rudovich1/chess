public abstract class Figure {
    private Colour figure_colour;
    
    static int value; 

    Figure(Colour colour){
        this.figure_colour = colour;
    }

    public Colour getColour(){
        return figure_colour;
    }

    abstract public int id();

}
class Rook extends Figure{
    
    Rook(Colour colour) {
        super(colour);
        value = 4;
    }

    public int id(){
        if(this.getColour() == Colour.WHITE){
            return 6;
        } else {
            return 7;
        }
    }
}
class Pawn extends Figure{
    
    Pawn(Colour colour) {
        super(colour);
        value = 1;
    }
    
    public int id(){
        if(this.getColour() == Colour.WHITE){
            return 0;
        } else {
            return 1;
        }
    }
}
class King extends Figure{
   
    King(Colour colour) {
        super(colour);
        value = 0;
    }

    public int id(){
        if(this.getColour() == Colour.WHITE){
            return 10;
        } else {
            return 11;
        }
    }
}
class Queen extends Figure{

    Queen(Colour colour) {
        super(colour);
        value = 9;
    }

    public int id(){
        if(this.getColour() == Colour.WHITE){
            return 8;
        } else {
            return 9;
        }
    }
}
class Knight extends Figure{

    Knight(Colour colour) {
        super(colour);
        value = 3;
    }

    public int id(){
        if(this.getColour() == Colour.WHITE){
            return 2;
        } else {
            return 3;
        }
    }
}
class Bishop extends Figure{

    Bishop(Colour colour) {
        super(colour);
        value = 3;
    }

    public int id(){
        if(this.getColour() == Colour.WHITE){
            return 4;
        } else {
            return 5;
        }
    }
}

