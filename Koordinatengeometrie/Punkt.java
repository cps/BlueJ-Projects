
/**
 * Stellt einen Punkt im Koordinatensystem da.
 * 
 * Stand nach Aufgabe 4
 * 
 * @author Christoph Schueler
 * @version 0.4a4
 */
public class Punkt
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    double x;
    double y;

    /**
     * Feste Anfangswerte für den Punkt.
     */
    public Punkt()
    {
       x = 1;
       y = 1;
    }
    
    /**
     * Werte für die Koordinaten des Punktes können angegeben werden.
     */
    public Punkt(double nX, double nY){
        x = nX;
        y = nY;
    }

    /**
     * Gibt x zurück.
     */
    public double getX()
    {
        return x;
    }
    
    /**
     * Gibt y zurück.
     */
    public double getY()
    {
        return y;
    }
    
    /**
     * Neuen x-Wert setzen.
     */
    public void setX(double nX)
    {
        x = nX;
    }
    
    /**
     * Neuen y-Wert setzen. 
     */
    public void setY(double nY)
    {
        y = nY;
    }
    
    /**
     * Gibt den Abstand zu einem anderen Punkt als double zurück.
     */
    public double abstandPunkt(Punkt p)
    {
        double x1 = p.getX();
        double y1 = p.getY();
        double d = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
        return d;
    }
    
    /**
     * Berechnet den Abstand zu einer als Parameter mitgegebenen Gerade.
     * Hierzu wird die entsprechnde Methode der Geraden-Klasse verwendet.
     */
    public double abstandGerade(Gerade g)
    {
       double abstand = g.abstandPunkt(x, y);
       return abstand;
    }
    
    
    
    
}
