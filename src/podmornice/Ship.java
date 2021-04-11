package podmornice;

abstract class Ship extends Coordinates{
    private char orientation;
    
    Ship(char coordX, char coordY, char orientation){
        super(coordX, coordY);
        this.orientation = orientation;
    }
    
    abstract String[] Position(Carrier o);
    abstract String[] Position(Battleship o);
    abstract String[] Position(Destroyer o);
    abstract String[] Position(Submarine o);
    abstract String[] Position(PatrolBoat o);
    abstract boolean drawShip(Carrier o, Tabla t);
    abstract boolean drawShip(Battleship o, Tabla t);
    abstract boolean drawShip(Destroyer o, Tabla t);
    abstract boolean drawShip(Submarine o, Tabla t);
    abstract boolean drawShip(PatrolBoat o, Tabla t);

    /**
     * @return the orientation
     */
    public char getOrientation() {
        return orientation;
    }

    /**
     * @param orientation the orientation to set
     */
    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
}