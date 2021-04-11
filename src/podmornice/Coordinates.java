
package podmornice;

public class Coordinates {
    private char coordX;
    private char coordY;
    
    public Coordinates(char coordX, char coordY){
        this.coordX = coordX;
        this.coordY = coordY;
    }

    /**
     * @return the coordX
     */
    public char getCoordX() {
        return coordX;
    }

    /**
     * @param coordX the coordX to set
     */
    public void setCoordX(char coordX) {
        this.coordX = coordX;
    }

    /**
     * @return the coordY
     */
    public char getCoordY() {
        return coordY;
    }

    /**
     * @param coordY the coordY to set
     */
    public void setCoordY(char coordY) {
        this.coordY = coordY;
    }    
}
