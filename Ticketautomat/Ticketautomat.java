/**
 * Die Klasse Ticketautomat modelliert einfache Ticketautomaten,
 * die Tickets zu einem Einheitspreis herausgeben.
 * Der Preis f¸r die Tickets eines Automaten kann ¸ber den Konstruktor
 * festgelegt werden.
 * Ein Ticketautomat ist insofern 'naiv', dass er seinen Benutzern
 * vertraut, dass sie gen¸gend Geld einwerfen, bevor sie sich ein Ticket
 * ausdrucken lassen.
 * Auﬂerdem nimmt er an, dass sinnvolle Betr‰ge eingeworfen werden.
 *
 * @author David J. Barnes und Michael Kˆlling
 * @version 2003.05.15
 */
public class Ticketautomat 
{
    // Der Preis eines Tickets dieses Automaten.
    private int preis;
    // Der Betrag, der bisher vom Automatenbenutzer eingeworfen wurde.
    private int bisherGezahlt;
    // Die Geldsumme, die bisher von diesem Automaten eingenommen wurde.
    private int gesamtsumme;

    /**
     * Erzeuge eine Maschine, die Tickets zum angegebenen Preis
     * (in Cent) ausgibt.
     * Zu beachten: Der Preis muss grˆﬂer als Null sein,
     * der Automat ¸berpr¸ft dies jedoch nicht.
     * Edit: Der Preis wird jetzt direkt auf 200 festgelegt.
     * Er ist über die entsprechende Methode zu ändern.
     */
    public Ticketautomat()
    {
        preis = 200;
        bisherGezahlt = 0;
        gesamtsumme = 0;
    }

    /**
     * Liefere den Preis eines Tickets dieses Automaten (in Cent).
     */
    public int gibPreis()
    {
        return preis;
    }

    /**
     * Liefere die Hˆhe des Betrags, der f¸r das n‰chste Ticket bereits
     * eingeworfen wurde.
     */
    public int gibBisherGezahltenBetrag()
    {
        return bisherGezahlt;
    }

    /**
     * Nimm den angegebenen Betrag (in Cent) als Anzahlung f¸r das
     * n‰chste Ticket.
     */
    public void geldEinwerfen(int betrag)
    {
       if (betrag > 0) {
        bisherGezahlt += betrag;
        } else {
        	System.out.println("Bitte nur positive Betr√§ge verwenden!");
        }
    }
   

    /**
    *Gib den bisher insgesamt Gezahlten Betrag aus.
    */
    public int gibGesamtsumme()
    {
        return gesamtsumme;
    }
    
    /**
     * Leere den Automaten, in dem die Gesamtsumme auf Null gesetzt wird.
     */
    public void leereAutomat()
    {
        gesamtsumme = 0;
    }
    
    /**
     * Ändere den Ticketpreis. Neuen Ticketpreis in Cent eingeben.
     */
   public void aenderePreis(int neuerPreis)
   {
        preis = neuerPreis; 
   }
   
   /**
    * Gib den aktuellen Kassenstand (gesamtsumme) auf dem Bildschirm aus.
    */
   public void kassenstandDrucken()
   {
       System.out.println("##################"); 
       System.out.println("Kassenbestand: " + gesamtsumme + " Cent");
       System.out.println("##################");
       System.out.println();
   }

   /**
    * Wenn zu viel gezahlt wurde, wird das Wechselgeld von der Methode zur√ºckgegeben
	* und der eingeworfene Betrag zur√ºckgesetzt, sonst wird 0 zur√ºckgegeben.
    */
   public int wechselgeldAusgabe(){
     if (bisherGezahlt >= preis) {
     int wechselgeld;
     wechselgeld = bisherGezahlt - preis;
     bisherGezahlt = 0;
     return wechselgeld; 
    } else {
        return 0;
    	}
    }
    
   
    /**
     * Drucke ein Ticket.
     * Aktualisiere die eingenommene Gesamtsumme und setze den gezahlten
     * Betrag auf Null.
     */
    public void ticketDrucken()
    {
        if (bisherGezahlt >= preis) {
        	// Den Ausdruck eines Tickets simulieren.
	        System.out.println("##################");
	        System.out.println("# Die BlueJ-Linie");
	        System.out.println("# Ticket");
	        System.out.println("# " + preis + " Cent.");
	        System.out.println("##################");
	        System.out.println();

	        // Die Gesamtsumme mit dem eingezahlten Betrag aktualisieren.
	        gesamtsumme += bisherGezahlt;
       
	        // Wechsele Geld
	        int wechselgeld;
	        wechselgeld = wechselgeldAusgabe();
	        System.out.println("Wechselgeld:" + wechselgeld + " Cent");
	        System.out.println();
	        // Die bisherige Bezahlung zur√ºcksetzen.
	        bisherGezahlt = 0;
		} else {
       	 	int fehlt;
	        fehlt =  preis - bisherGezahlt;
	     	System.out.println("Es fehlen noch " + fehlt + " Cent!");
	     	System.out.println();
    		}
    	}
}
