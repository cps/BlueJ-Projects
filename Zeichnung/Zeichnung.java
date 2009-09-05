
/**
 * Diese Klasse definiert eine einfache Zeichnung. Um die Zeichnung auf
 * dem Bildschirm anzeigen zu lassen, muss die zeichne-Operation auf
 * einem Exemplar aufgerufen werden.
 * Aber hier steckt mehr drin: Da es eine elektronische Zeichnung ist,
 * kann sie geändert werden. Man kann sie schwarz-weiß anzeigen lassen
 * und dann wieder in Farbe (nachdem sie gezeichnet wurde, ist ja klar).
 * 
 * Diese Klasse ist als frühes Java-Lehrbeispiel mit BlueJ gedacht.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 1.0  (3. Januar 2003)
 */
public class Zeichnung
{
    private Quadrat wand;
    private Quadrat fenster;
    private Dreieck dach;
    private Kreis sonne;
    private Rechteck tuer;
    private Oval wolke1;
    private Oval donnertroete;

    /**
     * Erzeuge ein Exemplar der Klasse Zeichnung
     */
    public Zeichnung()
    {
        // nichts zu tun hier, alle Exemplarvariablen werden automatisch
        // mit null initialisiert.
        wand = new Quadrat();
        wand.vertikalBewegen(80);
        wand.groesseAendern(100);

        fenster = new Quadrat();
        fenster.farbeAendern("schwarz");
        fenster.horizontalBewegen(20);
        fenster.vertikalBewegen(100);

        dach = new Dreieck();  
        dach.groesseAendern(50, 140);
        dach.horizontalBewegen(60);
        dach.vertikalBewegen(70);

        sonne = new Kreis();
        sonne.farbeAendern("gelb");
        sonne.horizontalBewegen(180);
        sonne.vertikalBewegen(-10);
        sonne.groesseAendern(60);
        
        tuer = new Rechteck();
        tuer.farbeAendern("gruen");
        tuer.horizontalBewegen(60);
        tuer.vertikalBewegen(120);
        tuer.groesseAendern(30,60);
        
        wolke1 = new Oval();
        wolke1.farbeAendern("blau");
        wolke1.groesseAendern(60,20);
        
        donnertroete = new Oval();
        donnertroete.farbeAendern("gelb");
        donnertroete.groesseAendern(60,20);
        donnertroete.vertikalBewegen(-20);
        donnertroete.horizontalBewegen(60);
        
    }

    /**
     * Zeichne die Zeichnung.
     */
    public void zeichne()
    {
        wand.sichtbarMachen();
        fenster.sichtbarMachen();
        dach.sichtbarMachen();
        sonne.sichtbarMachen();
        tuer.sichtbarMachen();
        wolke1.sichtbarMachen();
        donnertroete.sichtbarMachen();
    }

    /**
     * Ändere die Darstellung in schwarz-weiß.
     */
    public void inSchwarzWeissAendern()
    {
        if(wand != null)   // nur wenn schon gezeichnet wurde ...
        {
            wand.farbeAendern("schwarz");
            fenster.farbeAendern("weiss");
            dach.farbeAendern("schwarz");
            sonne.farbeAendern("schwarz");
        }
    }

    /**
     * Ändere die Darstellung in Farbe.
     */
    public void inFarbeAendern()
    {
        if(wand != null)   // nur wenn schon gezeichnet wurde ...
        {
            wand.farbeAendern("rot");
            fenster.farbeAendern("schwarz");
            dach.farbeAendern("gruen");
            sonne.farbeAendern("gelb");
        }
    }

}
