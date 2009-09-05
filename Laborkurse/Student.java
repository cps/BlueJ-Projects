
/**
 * Diese Klasse definiert Studenten in einem Uni-Verwaltungssystem.
 * Sie beschreibt die Details von Studenten, die für unseren Kontext 
 * relevant sind.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 1.0  (3. Januar 2003)
 */
public class Student
{
    // der volle Name des Studierenden
    private String name;
    // seine Matrikelnummer
    private String matrikelnummer;
    // die Anzahl der bereits erworbenen Scheine
    private int scheine;

    /**
     * Erzeuge einen neuen Studenten mit Name und Matrikelnummer.
     */
    public Student(String vollerName, String matrNr)
    {
        name = vollerName;
        matrikelnummer = matrNr;
        scheine = 0;
    }

    /**
     * Liefere den vollen Namen dieses Studenten.
     */
    public String gibName()
    {
        return name;
    }

    /**
     * Trage einen neuen Namen ein.
     */
    public void nameAendern(String neuerName)
    {
        name = neuerName;
    }

    /**
     * Liefere die Matrikelnummer dieses Studenten.
     */
    public String gibMatrikelnummer()
    {
        return matrikelnummer;
    }

    /**
     * Erhöhe die Anzahl der erworbenen Scheine.
     */
    public void erhoeheScheinanzahl(int weitereScheine)
    {
        scheine += weitereScheine;
    }

    /**
     * Liefere die Anzahl der bereits erworbenen Scheine.
     */
    public int gibScheinanzahl()
    {
        return scheine;
    }

    /**
     * Liefere den Login-Namen. Der Login-Name ist eine Kombination der
     * ersten vier Buchstaben des Namens mit den ersten drei Ziffern der
     * Matrikelnummer.
     */
    public String gibLoginName()
    {
        return name.substring(0,4) + matrikelnummer.substring(0,3);
    }
    
    /**
     * Gib Name und Matrikelnummer auf der Konsole aus.
     */
    public void ausgeben()
    {
        System.out.println(name + " (" + matrikelnummer + ")");
    }
}
