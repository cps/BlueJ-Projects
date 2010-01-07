/**
 * Berechnungen zur Zahlentheorie
 * 
 * @author Christoph Schüler
 * @version 0.1a3
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
	public static boolean istPrimzahl(int m) {
		int moeglTeiler = 2;
		while (moeglTeiler < m) {
			if (Zahlentheorie.teilt(moeglTeiler, m)) {
				return false;
			}
			moeglTeiler++;
		}

		return true;
	}

	/**
	 * Methode, die durch den ersten besprochenen Algorithmus das ggT von zwei
	 * mitgegebenen Zahlen bestimmt.
	 */
	public static int berechneGgT1(int m, int n) {
		int laufzahl;
		boolean gefunden;
		if (m < n) {
			laufzahl = m;
		}
		else {
			laufzahl = n;
		}
		gefunden = false;
		while (!gefunden) {
			if (Zahlentheorie.teilt(laufzahl, m)
					&& Zahlentheorie.teilt(laufzahl, n)) {
				gefunden = true;
			}
			else {
				laufzahl--;
			}
		}
		return laufzahl;
	}

	/**
	 * Methode, die durch den zweiten besprochenen Algorithmus das ggT von zwei
	 * mitgegebenen Zahlen bestimmt.
	 */
	public static int berechneGgT2(int m, int n) {
		int aktuellerRest = (n % m);
		while (aktuellerRest != 0) {
			n = m;
			m = aktuellerRest;
			aktuellerRest = (n % m);
		}
		return m;
	}

	/**
	 * Methode, die durch den dritten Algorithmus (vom Blatt) das ggT von zwei
	 * mitgegebenen Zahlen bestimmt.
	 */
	public static int berechneGgT3(int a, int b) {
		while (a != b) {
			if (a < b) {
				b = b - a;
			}
			else {
				a = a - b;
			}
		}
		return a;
	}

	/**
	 * Gibt alle Teiler einer Zahl auf der Konsole aus. (Einzelstrings)
	 */
	public static void teiler(int m) {
		int laufzahl = m;
		System.out.println("Folgende Zahlen teilen " + m + ":");
		while (laufzahl > 0) {
			if (Zahlentheorie.teilt(laufzahl, m)) {
				System.out.println(laufzahl);
			}
			laufzahl--;
		}
	}

	/**
	 * Die Teiler einer Zahl werden als ein String auf der Konsole ausgegeben.
	 */
	public static void teilerEinString(int m) {
		int laufzahl = m;
		String ausgabe = "Folgende Zahlen teilen " + m + ": ";
		while (laufzahl > 0) {
			if (Zahlentheorie.teilt(laufzahl, m)) {
				if (laufzahl != 1) {
					ausgabe += laufzahl + ", ";
				}
				else {
					ausgabe += laufzahl;
				}
			}
			laufzahl--;
		}
		System.out.println(ausgabe);
	}

}