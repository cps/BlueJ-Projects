/**
 * Abbildung einer Geraden.
 * 
 * Stand nach Aufgabe 1: Konstruktoren gebaut.
 * Stand nach Aufgabe 2: Konstruktoren der Besprechung im Unterricht angepasst, Aufgabe zwei bearbeitet.
 * Stand nach Aufgabe 4.
 * Zusatzaufgabe: Wertetabelle in while-Schleife geändert.
 * 
 * @author Christoph Schueler
 * @version 0.5a4
 * 
 * @TODO Im Moment ist die Steigung für Geraden, die parallel zur x-Achse verlaufen falsch.
 */
public class Gerade {
	private double m; // Steigung 
	private double b; // y-Achsenabschnitt

	/**
	 * Konstruktor 1: Konstruktor der m = 1 und b = 0 setzt. 
	 */
	public Gerade() {
		m = 1;
		b = 0;
	}

	/**
	 * Konstruktor 2: Setzt m und b wie mitgegeben.
	 */
	public Gerade(double Steigung, double yAbschnitt) {
		m = Steigung;
		b = yAbschnitt;
	}

	/**
	 * Konstruktor 3: setzt m wie mitgegeben und berechnet b 
	 * mit der Punkt-Steigungs-Form.
	 */
	public Gerade(double x, double y, double Steigung) {
		m = Steigung;
		b = y - (m * x);
	}

	/**
	 * Konstruktor 4: Berechnet m und b mit der Zwei-Punkte-Form.
	 */
	public Gerade(double x1, double y1, double x2, double y2) {
		m = (y2 - y1) / (x2 - x1);
		b = y1 - (m * x1);
	}

	/**
	 * Getter für b.
	 */
	public double getB() {
		return b;
	}

	/**
	 * Getter für m.
	 */
	public double getM() {
		return m;
	}

	/**
	 * Nullstellen.
	 * @TODO Lösung für gerade Parallel zur x-Achse schaffen, mit Rückgabe von Double.NaN erstellen.
	 */
	public double nullStellen() {
		//0=mx+b
		//x=-(b/m)
		double ns = -(b / m);
		return ns;
	}

	/**
	 * Gibt den Funktionswert an einer Stelle x zurück.
	 */
	public double funktionswert(double x) {
		double y = (m * x) + b;
		return y;
	}

	/**
	 * Gibt die Funktionsgleichung in der Konsole aus.
	 */
	public void funktionsgleichung() {
		System.out.println("#########");
		System.out.print("Die aktuelle Funktionsgleichung ist: ");
		System.out.println("f(x)=" + m + "x+" + b + ".");
		System.out.println("#########");
		System.out.println("");
	}

	/**
	 * Wertetabelle mit übergebenen Parametern erstellen.
	 */
	public void wertetabelle(double start, double ende, int schrittweite) {
		System.out.println("#########");
		System.out.println("- Wertetabelle -");
		System.out.println("|\tWert \t|  Zugeordneter Wert");
		double i = start;
		while (i <= ende) {
			System.out.println("|\t" + i + "\t| " + funktionswert(i));
			i += schrittweite;
		}

	}

	/**
	 * Die Orthogonale steigung wird über den neg. Kehrwert berechnet und zurück gegeben.
	 */
	public double orthogonaleSteigung() {
		//Orthogonale Steigung = Negativer Kehrwert von m.
		double os = -(1 / m);
		return os;
	}

	/**
	 * Eine Gerade wird mit der Orthogonalen Steigung und durch einen Punkt erzeugt und das entsp. Objekt zurückgegeben.
	 */
	public Gerade orthogonaleGerade(double x, double y) {
		double os = orthogonaleSteigung();
		Gerade neu = new Gerade(x, y, os);
		return neu;
	}

	/**
	 * Gibt die x Koordinate des Schnittpunktes zweier Gerade zurück.
	 * Die Gerade die schneidet wird als Parameter mitgegeben.
	 */
	public double schnittstelle(Gerade g) {
		double schnittM = g.getM();
		double schnittB = g.getB();
		double pS = (schnittB - b) / (m - schnittM);
		return pS;
	}

	/**
	 * Berechnet den Abstand eines Punktes von der jeweiligen Geraden.
	 */
	public double abstandPunkt(double x, double y) {
		Gerade o = orthogonaleGerade(x, y);
		double x1 = schnittstelle(o);
		double y1 = funktionswert(x1);
		double d = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
		return d;
	}

}