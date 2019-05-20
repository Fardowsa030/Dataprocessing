package P1;

import java.sql.Date;
import java.util.List;



public class Main {

	public static void main(String[] args) {

        //Twee reiziger objecten aanmaken
        Reiziger r1 = new Reiziger("Fardowsa", java.sql.Date.valueOf("1997-06-05"));
        Reiziger r2 = new Reiziger("Nur", java.sql.Date.valueOf("1996-03-02"));

        ReizigerDaoImpl i1 = new ReizigerDaoImpl();

        //Reizigers persisteren(save functie)
        i1.save(r1);
        i1.save(r2);
        
        System.out.println("De reizigers in de lijst: \n" + i1.findAll().toString());
        
        //Reiziger verwijderen(delete functie)
        if(i1.delete(r1)) {
        	i1.findAll().remove(r1);
        }

        System.out.println("De reizigers in database na het verwijderen van r1: \n" + i1.findAll().toString());

       
        //Reizigers met geboortedatum vinden
        List<Reiziger> vindenOpDatum = i1.findByGBdatum("1996-03-02");
        System.out.println("Reizigers met geboortedatum 03-02-1996:\n" + vindenOpDatum.toString()); 
        
        //Reiziger updaten
        r2.setNaam("Frank");
        i1.update(r2);
        System.out.println("na updaten: \n" + i1.findAll().toString());
        

    }
   
	}

        
       