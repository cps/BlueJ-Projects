/**
 * Berechnungen zur Zahlentheorie
 * 
 * @author Christoph Schüler
 * @version 0.1a1
 */
public class Zahlentheorie {
	// Keine Datenfelder, weil statische Klasse.

	// Kein Konstruktor, weil statische Klasse.

	/**
	 * Methode, die prüft, ob m n teilt. 
	 */
	public static boolean teilt(int m, int n) {
		if (n % m == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}