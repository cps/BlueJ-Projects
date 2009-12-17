/**
 * Berechnungen zur Zahlentheorie
 * 
 * @author Christoph Schüler
 * @version 0.1a2
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

	/**
	 * Statische Methode, die durch weitere Methodenaufrufe prüft, ob m eine 
	 * Primzahl ist und das Ergebniss als boolean zurückgibt.
	 */
	public static boolean istPrimzhal(int m) {
		int moeglTeiler = 2;
		while (moeglTeiler < m) {
			if (Zahlentheorie.teilt(moeglTeiler, m)) {
				return false;
			}
			moeglTeiler++;
		}

		return true;
	}

}