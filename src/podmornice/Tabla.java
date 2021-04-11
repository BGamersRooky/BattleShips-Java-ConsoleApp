
package podmornice;

import java.io.IOException;

public class Tabla implements UpravljanjeTablom{
    private String[][] tabla;
    private int x;
    private int y;

    public Tabla(){
        this.x = 10;
        this.y = 10;
        this.tabla = new String[y][x];
                
        char a = 'a';
        int a1 = a;
        
        for(int i = 0; i < x; i++){
          for(int j = 0; j < y; j++){
            tabla[j][i] = (char)(a1 + i) + "" + j;
          }
        }
    }
    
    public String[][] getTabla(){
        return tabla;
    }
    
    public void setTabla(String[][] novaTabla){
        this.tabla = novaTabla;
    }
    
    public String nacrtajTablu(Tabla t, boolean b) throws IOException, InterruptedException{
        String[] redovi = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String tbl = "";
        clearScreen();
        if(b){
            for(int i = 0; i < x; i++){
                tbl+="\n" + redovi[i] + " ";
                for(int j = 0; j < y; j++){
                    if (tabla[j][i] == "//") {
                        tbl += "| " + "//" + " |";
                    }else if(tabla[j][i] == "**"){
                        tbl += "| " + "**" + " |";                        
                    }else{
                        tbl += "| " + "--" + " |";                        
                    }
                }
            }            
        }else{
            for(int i = 0; i < x; i++){
                tbl+="\n";                
                for(int j = 0; j < y; j++){       
                    tbl += "| " + tabla[j][i] + " |";
                }
            }        
        }        
        return tbl;
    }
    
    public boolean Shoot(Tabla t, String c, int[] life){
        Tabla p = new Tabla();
        String[][] pomocna = p.getTabla();
        boolean chk = false;
        
        start:
        for (int i = 0; i < tabla[0].length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                if (c.equals(tabla[j][i])) {
                    tabla[j][i] = "//";
                    break start;
                }
                if ((c.equals(pomocna[j][i]) && tabla[j][i] == "CA") ||
                    (c.equals(pomocna[j][i]) && tabla[j][i] == "BS") ||
                    (c.equals(pomocna[j][i]) && tabla[j][i] == "DE") ||
                    (c.equals(pomocna[j][i]) && tabla[j][i] == "SU") ||
                    (c.equals(pomocna[j][i]) && tabla[j][i] == "PB")){
                    
                    switch(tabla[j][i]){
                        case "CA":
                            life[0]--;
                            if (life[0] == 0) {
                                System.out.println("Brod potopljen!");
                                chk = true;
                            }                            
                            break;
                        case "BS":
                            life[1]--;
                            if (life[1] == 0) {
                                System.out.println("Brod potopljen!");
                                chk = true;
                            }                            
                            break;
                        case "DE":
                            life[2]--;
                            if (life[2] == 0) {
                                System.out.println("Brod potopljen!");
                                chk = true;
                            }                            
                            break;
                        case "SU":
                            life[3]--;
                            if (life[3] == 0) {
                                System.out.println("Brod potopljen!");
                                chk = true;
                            }                            
                            break;
                        case "PB":
                            life[4]--;
                            if (life[4] == 0) {
                                System.out.println("Brod potopljen!");
                                chk = true;
                            }
                            break;                            
                    }
                    tabla[j][i] = "**";
                    break start;
                }
            }
        }
        return chk;
    }
    public static void clearScreen() throws IOException, InterruptedException {  
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }    
}
