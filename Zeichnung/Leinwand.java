import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Leinwand ist eine Klasse, die einfache Zeichenoperationen auf einer
 * leinwandartigen Zeichenfläche ermöglicht.
 * Sie ist eine vereinfachte Version der Klasse Canvas (englisch für 
 * Leinwand) des JDK und wurde speziell für das Projekt "Figuren"
 * geschrieben.
 * 
 *
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 * @author: Axel Schmolitzky
 *
 * @version: 1.6 
 */
public class Leinwand
{
  // Hinweis: Die Implementierung dieser Klasse (insbesondere die
  // Verwaltung der Farben und Identitäten der Figuren) ist etwas
  // komplizierter als notwendig. Dies ist absichtlich so, weil damit 
  // die Schnittstellen und Exemplarvariablen der Figuren-Klassen
  // für den Lernanspruch dieses Projekts einfacher und klarer
  // sein können.

  private static Leinwand leinwandSingleton;

  /**
   * Fabrikmethode, die eine Referenz auf das einzige Exemplar
   * dieser Klasse zurückliefert. Wenn es von einer Klasse nur
   * genau ein Exemplar gibt, wird dieses als 'Singleton'
   * bezeichnet.
   */
  public static Leinwand gibLeinwand()
  {
    if (leinwandSingleton == null)
    {
      leinwandSingleton =
        new Leinwand("BlueJ Figuren Demo", 300, 300, Color.white);
    }
    leinwandSingleton.setzeSichtbarkeit(true);
    return leinwandSingleton;
  }

  //  ----- Exemplarvariablen -----

  private JFrame fenster;
  private Zeichenflaeche zeichenflaeche;
  private Graphics2D graphic;
  private Color hintergrundfarbe;
  private Image leinwandImage;
  private List figuren;
  private Map figurZuShape; // Abbildung von Figuren zu Shapes

  /**
   * Erzeuge eine Leinwand.
   * @param titel  Titel, der im Rahmen der Leinwand angezeigt wird
   * @param breite  die gewünschte Breite der Leinwand
   * @param hoehe  die gewünschte Höhe der Leinwand
   * @param grundfarbe die Hintergrundfarbe der Leinwand
   */
  private Leinwand(String titel, int breite, int hoehe, Color grundfarbe)
  {
    fenster = new JFrame();
    zeichenflaeche = new Zeichenflaeche();
    fenster.setContentPane(zeichenflaeche);
    fenster.setTitle(titel);
    zeichenflaeche.setPreferredSize(new Dimension(breite, hoehe));
    hintergrundfarbe = grundfarbe;
    fenster.pack();
    figuren = new ArrayList();
    figurZuShape = new HashMap();
  }

  /**
   * Setze, ob diese Leinwand sichtbar sein soll oder nicht. Wenn die
   * Leinwand sichtbar gemacht wird, wird ihr Fenster in den
   * Vordergrund geholt. Diese Operation kann auch benutzt werden, um 
   * ein bereits sichtbares Leinwandfenster in den Vordergrund (vor
   * andere Fenster) zu holen.
   * @param sichtbar boolean für die gewünschte Sichtbarkeit: 
   * true für sichtbar, false für nicht sichtbar.
   */
  public void setzeSichtbarkeit(boolean sichtbar)
  {
    if (graphic == null)
    {
      // erstmaliger Aufruf: erzeuge das Bildschirm-Image und fülle
      // es mit der Hintergrundfarbe
      Dimension size = zeichenflaeche.getSize();
      leinwandImage = zeichenflaeche.createImage(size.width, size.height);
      graphic = (Graphics2D) leinwandImage.getGraphics();
      graphic.setColor(hintergrundfarbe);
      graphic.fillRect(0, 0, size.width, size.height);
      graphic.setColor(Color.black);
    }
    fenster.setVisible(sichtbar);
  }

  /**
   * Zeichne für das gegebene Figur-Objekt eine Java-Figur (einen Shape)
   * auf die Leinwand.
   * @param  figur  das Figur-Objekt, für das ein Shape gezeichnet
   *                 werden soll
   * @param  farbe  die Farbe der Figur
   * @param  shape  ein Objekt der Klasse Shape, das tatsächlich
   *                 gezeichnet wird
   */
  public void zeichne(Object figur, String farbe, Shape shape)
  {
    figuren.remove(figur); // entfernen, falls schon eingetragen
    figuren.add(figur); // am Ende hinzufügen
    figurZuShape.put(figur, new ShapeMitFarbe(shape, farbe));
    erneutZeichnen();
  }

  /**
   * Entferne die gegebene Figur von der Leinwand.
   * @param  figur  die Figur, deren Shape entfernt werden soll
   */
  public void entferne(Object figur)
  {
    figuren.remove(figur); // entfernen,falls schon eingetragen
    figurZuShape.remove(figur);
    erneutZeichnen();
  }

  /**
   * Setze die Zeichenfarbe der Leinwand.
   * @param  farbname der Name der neuen Zeichenfarbe.
   */
  public void setzeZeichenfarbe(String farbname)
  {
    if (farbname.equals("rot"))
      graphic.setColor(Color.red);
    else if (farbname.equals("schwarz"))
      graphic.setColor(Color.black);
    else if (farbname.equals("blau"))
      graphic.setColor(Color.blue);
    else if (farbname.equals("gelb"))
      graphic.setColor(Color.yellow);
    else if (farbname.equals("gruen"))
      graphic.setColor(Color.green);
    else if (farbname.equals("lila"))
      graphic.setColor(Color.magenta);
    else if (farbname.equals("weiss"))
      graphic.setColor(Color.white);
    else
      graphic.setColor(Color.black);
  }

  /**
   * Warte für die angegebenen Millisekunden.
   * Mit dieser Operation wird eine Verzögerung definiert, die
   * für animierte Zeichnungen benutzt werden kann.
   * @param  millisekunden die zu wartenden Millisekunden
   */
  public void warte(int millisekunden)
  {
    try
    {
      Thread.sleep(millisekunden);
    }
    catch (Exception e)
    {
      // Exception ignorieren
    }
  }

  /**
   * Zeichne erneut alle Figuren auf der Leinwand.
   */
  private void erneutZeichnen()
  {
    loeschen();
    for (Iterator i = figuren.iterator(); i.hasNext();)
    {
      ((ShapeMitFarbe) figurZuShape.get(i.next())).draw(graphic);
    }
    zeichenflaeche.repaint();
  }

  /**
   * Lösche die gesamte Leinwand.
   */
  private void loeschen()
  {
    Color original = graphic.getColor();
    graphic.setColor(hintergrundfarbe);
    Dimension size = zeichenflaeche.getSize();
    graphic.fill(new Rectangle(0, 0, size.width, size.height));
    graphic.setColor(original);
  }

  /************************************************************************
   * Interne Klasse Zeichenflaeche - die Klasse für die GUI-Komponente,
   * die tatsächlich im Leinwand-Fenster angezeigt wird. Diese Klasse
   * definiert ein JPanel mit der zusätzlichen Möglichkeit, das auf ihm
   * gezeichnet Image aufzufrischen (erneut zu zeichnen).
   */
  private class Zeichenflaeche extends JPanel
  {
    public void paint(Graphics g)
    {
      g.drawImage(leinwandImage, 0, 0, null);
    }
  }

  /************************************************************************
   * Interne Klasse ShapeMitFarbe - Da die Klasse Shape des JDK nicht auch
   * eine Farbe mitverwalten kann, muss mit dieser Klasse die Verknüpfung
   * modelliert werden.
   */
  private class ShapeMitFarbe
  {
    private Shape shape;
    private String farbe;

    public ShapeMitFarbe(Shape shape, String farbe)
    {
      this.shape = shape;
      this.farbe = farbe;
    }

    public void draw(Graphics2D graphic)
    {
      setzeZeichenfarbe(farbe);
      graphic.fill(shape);
    }
  }

}
