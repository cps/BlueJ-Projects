import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Die Klasse Laborkurs definiert Teilnehmerlisten von Laborkursen.
 * Ein Exemplar von Laborkurs hält Informationen über Zeit, Raum und 
 * alle Teilnehmer sowie über den Namen des Dozenten.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 1.0  (3. Januar 2003)
 */
public class Laborkurs
{
    private String dozent;
    private String raum;
    private String tagUndZeit;
    private List studenten;
    private int teilnehmergrenze;
    
    /**
     * Erzeuge einen Laborkurs mit einer Teilnehmerbegrenzung. Alle 
     * anderen Details werden mit Standardwerten vorbelegt.
     */
    public Laborkurs(int maximaleTeilnehmerzahl)
    {
        dozent = "N.N.";
        raum = "N.N.";
        tagUndZeit = "N.N.";
        studenten = new ArrayList();
        teilnehmergrenze = maximaleTeilnehmerzahl;
    }

    /**
     * Trage einen Studenten in diesen Kurs ein.
     */
    public void trageStudentEin(Student neuerStudent)
    {
        if(studenten.size() == teilnehmergrenze) {
            System.out.println("Der Kurs ist voll, keine Eintragung mehr möglich.");
        }
        else {
            studenten.add(neuerStudent);
        }
    }
    
    /**
     * Liefere die Anzahl der in diesen Kurs momentan eingetragenen Studenten.
     */
    public int anzahlStudenten()
    {
        return studenten.size();
    }
    
    /**
     * Setze den Raum für diesen Kurs.
     */
    public void setzeRaum(String raumnummer)
    {
        raum = raumnummer;
    }
    
    /**
     * Setze Wochentag und Anfangszeit für diesen Kurs. Der Parameter
     * sollte das Format "montags, 16 Uhr" haben.
     */
    public void setzeTermin(String tagUndZeit)
    {
        this.tagUndZeit = tagUndZeit;
    }
    
    /**
     * Setze den Namen des Dozenten für diesen Laborkurs.
     */
    public void setzeDozent(String dozentenname)
    {
        dozent = dozentenname;
    }
    
    /**
     * Gib eine Liste der Teilnehmer zusammen mit den weiteren Details
     * dieses Kurses auf die Konsole aus.
     */
    public void listeAusgeben()
    {
        System.out.println("Laborkurs: " + tagUndZeit);
        System.out.println("Dozent: " + dozent + "   Raum: " + raum);
        System.out.println("Teilnehmerliste:");
        Iterator i = studenten.iterator();
        while(i.hasNext()) {
            Student student = (Student)i.next();
            student.ausgeben();
        }
        System.out.println("Teilnehmeranzahl: " + anzahlStudenten());
    }
}
