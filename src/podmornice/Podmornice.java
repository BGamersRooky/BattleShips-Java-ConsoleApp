
package podmornice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Podmornice {

    public static void main(String[] args) throws IOException, InterruptedException{
        
        Start();
        
        //Poslednja provera check
        
        //start igre (crtanje mape bez oznaka)
        
        //do while petlja koja ce da prati zivote brodova 
        //ukoliko su svi pogodjeni prekida se i igra je gotova
        
    }
    
    
    public static void crtanje(Tabla t, boolean ready) throws IOException, InterruptedException{
        System.out.println(t.nacrtajTablu(t, ready));        
    }
    public static Ship[] shipPlace(String type, Tabla t, boolean ready) throws IOException, InterruptedException{
        String o;
        Scanner obj = new Scanner(System.in);
        Ship[] Brodovi = new Ship[5];
        
        while(true){
            if (type == "carrier") {
                System.out.println("Napisite pocetnu poziciju broda \'Carrier\' kao i njegovu orijentaciju (primer: f4 x): ");                
            }else if(type == "battleship"){
                System.out.println("Napisite pocetnu poziciju broda \'Battleship\' kao i njegovu orijentaciju (primer: f4 x): ");                
            }else if(type == "destroyer"){
                System.out.println("Napisite pocetnu poziciju broda \'Destroyer\' kao i njegovu orijentaciju (primer: f4 x): ");                
            }else if(type == "submarine"){
                System.out.println("Napisite pocetnu poziciju broda \'Submarine\' kao i njegovu orijentaciju (primer: f4 x): ");                
            }else{
                System.out.println("Napisite pocetnu poziciju broda \'Patrol Boat\' kao i njegovu orijentaciju (primer: f4 x): ");                
            }
        o = obj.nextLine();
            if (o.length() == 4){
                if ((o.charAt(0) >= 'a' && o.charAt(0) <= 'j') && 
                     (o.charAt(1) >= '0' && o.charAt(1) <= '9') &&
                      (o.charAt(2)== ' ') && (o.charAt(3) == 'x' || o.charAt(3) == 'y')) {
                    break;
                }
            }
        }
        if(type == "carrier"){
            System.out.println("Crtam " + type);
            Carrier c = new Carrier(o.charAt(0), o.charAt(1), o.charAt(3));
            Brodovi[0] = c;
            if(c.drawShip(c, t)){
                crtanje(t, ready);            
            }else{
                shipPlace(type, t, ready);                
            }
        }else if(type == "battleship"){
            System.out.println("Crtam " + type);            
            Battleship c = new Battleship(o.charAt(0), o.charAt(1), o.charAt(3));
            Brodovi[1] = c;
            if(c.drawShip(c, t)){
                crtanje(t, ready);                            
            }else{
                shipPlace(type, t, ready);                
            }            
        }else if(type == "destroyer"){
            System.out.println("Crtam " + type);            
            Destroyer c = new Destroyer(o.charAt(0), o.charAt(1), o.charAt(3));
            Brodovi[2] = c;
            if(c.drawShip(c, t)){
                crtanje(t, ready);                            
            }else{
                shipPlace(type, t, ready);                
            }           
        }else if(type == "submarine"){
            System.out.println("Crtam " + type);        
            Submarine c = new Submarine(o.charAt(0), o.charAt(1), o.charAt(3));
            Brodovi[3] = c;
            if(c.drawShip(c, t)){
                crtanje(t, ready);                            
            }else{
                shipPlace(type, t, ready);                
            }           
        }else{
            System.out.println("Crtam " + type);            
            PatrolBoat c = new PatrolBoat(o.charAt(0), o.charAt(1), o.charAt(3));
            Brodovi[4] = c;
            if(c.drawShip(c, t)){
                crtanje(t, ready);                            
            }else{
                shipPlace(type, t, ready);                
            }            
        }
        
        return Brodovi;
    }
    public static void Start() throws IOException, InterruptedException{
        Tabla t = new Tabla();
        Scanner obj = new Scanner(System.in);
        String o;
        int[] life = {5, 4, 3, 3, 2};
        int potopljeni = 0;
        int brpot = 0;
        boolean ready = false;
        boolean game = true;

        crtanje(t, ready);
                
        shipPlace("carrier", t, ready);
        shipPlace("battleship", t, ready);
        shipPlace("destroyer", t, ready);
        shipPlace("submarine", t, ready);
        shipPlace("patrolboat", t, ready);
        
        System.out.println("Jeste li zadovoljni pozicijom brodova? (da / ne)");
        do{
            o = obj.nextLine();            
        }while(o == "da" || o == "ne");
        if(o.equals("da")){                        
            System.out.println("Počinjemo!");
            crtanje(t, true);
            System.out.println("");
            System.out.println("Napisite koordinate polje koje bi ste da gadjate (x osa: a-j, y osa: 0-9, npr. b4):");            
            ready = true;
            do {
                PlayGame(t, ready, life);
                //System.out.println("Zivoti: " + life[0] + " " + life[1] + " " + life[2] + " " + life[3] + " " + life[4]);
                brpot++;
                for (int i = 0; i < life.length; i++) {                    
                    if (life[i] == 0) {
                        potopljeni++;
                    }
                    if (potopljeni == 5) {
                        crtanje(t, ready);
                        System.out.println("Cestitamo pobedili ste! Broj potrebnih poteza: " + brpot);
                        try (FileWriter fw = new FileWriter("GameLog.txt", true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter out = new PrintWriter(bw)){
                            GregorianCalendar danas = new GregorianCalendar();
                            
                            int sat = danas.get(GregorianCalendar.HOUR_OF_DAY);
                            int min = danas.get(GregorianCalendar.MINUTE);
                            int dan = danas.get(GregorianCalendar.DAY_OF_MONTH);
                            int mesec = danas.get(GregorianCalendar.MONTH);
                            int godina = danas.get(GregorianCalendar.YEAR);
                            
                            out.println(dan + ". " + mesec + ". " + godina + ". " + sat + ":" + min + " - Broj potrebnih poteza: " + brpot);
                        } catch (IOException e) {
                            //System.out.println("GRESKA u pisanju u datoteku");
                            e.printStackTrace();
                        }

                        game = false;                        
                        break;
                    }
                }
                potopljeni = 0;

            } while (game);            
        }else{
            Start();
        }
    }
    
    public static void PlayGame(Tabla t, boolean ready, int[] life) throws IOException, InterruptedException{
        Scanner obj = new Scanner(System.in);
        String o;
        String chk = "";
                
        do{
            o = obj.nextLine();
            if(o.length() == 2){
                if ((o.charAt(0) >= 'a' && o.charAt(0) <= 'j')
                    && (o.charAt(1) >= '0' && o.charAt(1) <= '9')
                    && (o.length() == 2)) {
                    System.out.println("Pravilno upisano polje");
                    if(t.Shoot(t, o, life)){
                        chk = "Brod potopljen!";
                    }
                    break;
                }else{
                    System.out.println("Nepravilno uneto polje!");
                }
            }else{
                System.out.println("Nepravilno uneto polje!");
            }
        }while(true);
        crtanje(t, ready);
        
        System.out.println(chk);
        System.out.println("Napisite koordinate polje koje bi ste da gadjate (x osa: a-j, y osa: 0-9, npr. b4):");

    }
}