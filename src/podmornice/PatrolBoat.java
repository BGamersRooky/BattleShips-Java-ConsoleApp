package podmornice;

import java.util.Arrays;

public class PatrolBoat extends Ship{
    private String id;
    private int squares;
    
    public PatrolBoat(char coordX, char coordY, char orientation){
        super(coordX, coordY, orientation);
        this.id = "PB";
        this.squares = 2;
    }
    
    @Override
    String[] Position(PatrolBoat o){
        int duzina = o.getSquares();
        char x = o.getCoordX();
        char y = o.getCoordY();
        String[] koordinate = new String[duzina];
        
        
        koordinate[0] = x + "" + y;
        if(o.getOrientation() == 'y'){
            for(int i = 1; i < duzina; i++){
                koordinate[i] = (char)(x + i) + "" + y;
            }
        }else{
            for(int i = 1; i < duzina; i++){
                koordinate[i] = x + "" + (char)(y + i);
            }           
        }
        
        return koordinate;
    }
    
    @Override
    boolean drawShip(PatrolBoat o, Tabla t){
        final String[] koordinate = Position(o);
        String[][] tabla = t.getTabla();
        final String[][] pomocna = new String[tabla.length][];
        for (int i = 0; i < tabla.length; i++) {
            pomocna[i] = Arrays.copyOf(tabla[i], tabla[i].length);
        }
        int br = 0;
        
        for (String koordinate1 : koordinate) {
            outerloop:
            for (int j = 0; j < pomocna[0].length; j++) {
                for (int k = 0; k < pomocna[0].length; k++) {
                    if (koordinate1.equals(pomocna[k][j])) {
                        pomocna[k][j] = o.id;
                        br++;
                        break outerloop;
                    }
                }
            }
        }
        if(br == o.getSquares()){
            t.setTabla(pomocna);
            return true;
        }else{
            System.out.println("Greška, pokušajte ponovo!");
            return false;
        }
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the squares
     */
    public int getSquares() {
        return squares;
    }

    /**
     * @param squares the squares to set
     */
    public void setSquares(int squares) {
        this.squares = squares;
    }

    @Override
    String[] Position(Carrier o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String[] Position(Battleship o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String[] Position(Destroyer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String[] Position(Submarine o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean drawShip(Carrier o, Tabla t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean drawShip(Battleship o, Tabla t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean drawShip(Destroyer o, Tabla t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean drawShip(Submarine o, Tabla t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}