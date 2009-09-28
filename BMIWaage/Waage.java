/**
 * Personenwaage: Personen werden gewogen, gemessen und der
 * BMI wird berechnet.
 */
public class Waage {
    private double gewicht;
    private double groesse;
    private double bmi;
    private String geschlecht;
    
    /**
     * Zwei Konstruktoren: 1. Mit Eingabe beider Werte,
     *                     2. Ohne Eingabe von Werten.
     */
    public Waage(double neuesGewicht, double neueGroesse, String neuesGeschlecht) {
        gewicht = neuesGewicht;
        groesse = neueGroesse;
        bmi = 0;
        geschlecht = neuesGeschlecht;
    }

    public Waage() {
        gewicht = 0;
        groesse = 0;
        bmi = 0;
        geschlecht = "";
    }

    /**
     * Gibt Gewicht zurück.
     */
    public double gibGewicht() {
        return gewicht;
    }

    /**
     * Gibt Groesse zurück.
     */
    public double gibGroesse() {
        return groesse;
    }

    /**
     * Verändert Gewicht
     */
    public void setzeGewicht(double neuesGewicht) {
        gewicht = neuesGewicht;
    }

    /**
     * Verändert Größe.
     */
    public void setzeGroesse(double neueGroesse) {
        groesse = neueGroesse;
    }
    
    /**
     * Setzt ein neues Geschlecht.
     */
    public void setzeGeschlecht(String neuesGeschlecht)
    {
        if (neuesGeschlecht.equals("m") || neuesGeschlecht.equals("w")){
        geschlecht = neuesGeschlecht;
        } else {
        		  System.out.println("Fehler: Das Geschlecht muss \"m\" oder \"f\" sein.");
        }
    }
    
    

    /**
     * Berechnet den BMI aus den vorher eingegeben Werten, falls sie gesetzt und gültig sind.
     */
    public double bodyMassIndex() {
        if (groesse != 0 && gewicht != 0) {
            double quadrat = groesse * groesse;
            double preBMI = gewicht / quadrat;
            bmi = preBMI * 10000;
            return bmi;
        }
        else {
            System.out.println("##############");
            System.out.println("Mindestens eine Angabe zum Berechnen des BMI fehlt.");
            System.out.println("##############");
            System.out.println("");
            return 0;
        }
    }

    /**
     * Gibt alle Werte auf der Konsole aus.
     */
    public void detailAusgabe() {
        bmi = bodyMassIndex();
        System.out.println("##############");
        if (geschlecht.equals("w")) {
        System.out.println("Geschlecht: Weiblich");
        } else {
        System.out.println("Geschlecht: Männlich");
        }
        System.out.println("Größe: " + groesse + "cm.");
        System.out.println("Gewicht: " + gewicht + "kg.");
        System.out.println("BMI: " + bmi);
        if (bmi < 18.5) {
            System.out.println("Achtung, wahrscheinlich bist du untergewichtig!");
        }
        else if (bmi >= 18.5 && bmi <= 25) {
                System.out.println("Dein Gewicht ist genau im richtigen Bereich. Sehr gut!");
            }
            else if (bmi > 25) {
                    System.out.println("Achtung, wahrscheinlich bist du übergewichtig!");
                }
        System.out.println("##############");
        System.out.println("");
    }

}