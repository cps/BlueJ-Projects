import java.awt.geom.Ellipse2D;

/**
 * Ein Oval, der manipuliert werden kann und sich selbst auf einer
 * Leinwand zeichnet.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 1.0  (7. Februar 2003)
 */

public class Oval
{
  private int durchmesser;
  private int hoehe;
  private int xPosition;
  private int yPosition;
  private String farbe;
  private boolean istSichtbar;

  /**
   * Erzeuge einen neuen Oval an einer Standardposition mit
   * einer Standardfarbe.
   */
  public Oval()
  {
    durchmesser = 30;
    hoehe = 30;
    xPosition = 20;
    yPosition = 60;
    farbe = "blau";
    istSichtbar = false;
  }

  /**
   * Mache diesen Oval sichtbar. Wenn es bereits sichtbar ist, tue
   * nichts.
   */
  public void sichtbarMachen()
  {
    istSichtbar = true;
    zeichnen();
  }

  /**
   * Mache diesen Oval unsichtbar. Wenn es bereits unsichtbar ist, tue
   * nichts.
   */
  public void unsichtbarMachen()
  {
    loeschen();
    istSichtbar = false;
  }

  /**
   * Bewege diesen Oval einige Bildschirmpunkte nach rechts.
   */
  public void nachRechtsBewegen()
  {
    horizontalBewegen(20);
  }

  /**
   * Bewege diesen Oval einige Bildschirmpunkte nach links.
   */
  public void nachLinksBewegen()
  {
    horizontalBewegen(-20);
  }

  /**
   * Bewege diesen Oval einige Bildschirmpunkte nach oben.
   */
  public void nachObenBewegen()
  {
    vertikalBewegen(-20);
  }

  /**
   * Bewege diesen Oval einige Bildschirmpunkte nach unten.
   */
  public void nachUntenBewegen()
  {
    vertikalBewegen(20);
  }

  /**
   * Bewege diesen Oval horizontal um 'entfernung' Bildschirmpunkte.
   */
  public void horizontalBewegen(int entfernung)
  {
    loeschen();
    xPosition += entfernung;
    zeichnen();
  }

  /**
   * Bewege diesen Oval vertikal um 'entfernung' Bildschirmpunkte.
   */
  public void vertikalBewegen(int entfernung)
  {
    loeschen();
    yPosition += entfernung;
    zeichnen();
  }

  /**
   * Bewege diesen Oval langsam horizontal um 'entfernung'
   * Bildschirmpunkte.
   */
  public void langsamHorizontalBewegen(int entfernung)
  {
    int delta;

    if (entfernung < 0)
    {
      delta = -1;
      entfernung = -entfernung;
    }
    else
    {
      delta = 1;
    }

    for (int i = 0; i < entfernung; i++)
    {
      xPosition += delta;
      zeichnen();
    }
  }

  /**
   * Bewege diesen Oval langsam vertikal um 'entfernung'
   * Bildschirmpunkte.
   */
  public void langsamVertikalBewegen(int entfernung)
  {
    int delta;

    if (entfernung < 0)
    {
      delta = -1;
      entfernung = -entfernung;
    }
    else
    {
      delta = 1;
    }

    for (int i = 0; i < entfernung; i++)
    {
      yPosition += delta;
      zeichnen();
    }
  }

  /**
   * Ändere den Durchmesser dieses Kreises in 'neuerDurchmesser'
   * (Angabe in Bildschirmpunkten).
   * 'neuerDurchmesser' muss größer gleich Null sein.
   */
  public void groesseAendern(int neuerDurchmesser, int neueHoehe)
  {
    loeschen();
    durchmesser = neuerDurchmesser;
    hoehe = neueHoehe;
    zeichnen();
  }

  /**
   * Ändere die Farbe dieses Kreises in 'neueFarbe'.
   * Gültige Angaben sind "rot", "gelb", "blau", "gruen",
   * "lila" und "schwarz".
   */
  public void farbeAendern(String neueFarbe)
  {
    farbe = neueFarbe;
    zeichnen();
  }

  /*
   * Zeichne diesen Oval mit seinen aktuellen Werten auf den Bildschirm.
   */
  private void zeichnen()
  {
    if (istSichtbar)
    {
      Leinwand leinwand = Leinwand.gibLeinwand();
      leinwand.zeichne(
        this,
        farbe,
        new Ellipse2D.Double(xPosition, yPosition, durchmesser, hoehe));
      leinwand.warte(10);
    }
  }

  /*
   * Lösche diesen Oval vom Bildschirm.
   */
  private void loeschen()
  {
    if (istSichtbar)
    {
      Leinwand leinwand = Leinwand.gibLeinwand();
      leinwand.entferne(this);
    }
  }

}
