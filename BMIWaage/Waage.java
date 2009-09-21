/**
 * Personenwaage: Personen werden gewogen, gemessen und der
 * BMI wird berechnet.
 */
public class Waage {
	private int gewicht;
	private int groesse;

	/**
	 * Zwei Konstruktoren: 1. Mit Eingabe beider Werte,
	 *                     2. Ohne Eingabe von Werten.
	 */
	public Waage(int neuesGewicht, int neueGroesse) {
		gewicht = neuesGewicht;
		groesse = neueGroesse;
	}

	public Waage() {
		gewicht = 0;
		groesse = 0;
	}

	/**
	 * Gibt Gewicht zurück.
	 */
	public int gibGewicht() {
		return gewicht;
	}

	/**
	 * Gibt Groesse zurück.
	 */
	public int gibGroesse() {
		return groesse;
	}

	/**
	 * Verändert Gewicht
	 */
	public void setzeGewicht(int neuesGewicht) {
		gewicht = neuesGewicht;
	}

	/**
	 * Verändert Größe.
	 */
	public void setzeGroesse(int neueGroesse) {
		groesse = neueGroesse;
	}

}