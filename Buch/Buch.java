/**
 * Eine Klasse, deren Exemplare Informationen Ã¼ber ein Buch halten.
 * Dies kÃ¶nnte Teil einer grÃ¶ÃŸeren Anwendung sein, einer
 * Bibliothekssoftware beispielsweise.
 *
 * @author (Ihren Namen hier eintragen.)
 * @version (das heutige Datum eintragen.)
 */
class Buch {
	// Exemplarvariablen
	private String autor;
	private String titel;
	private int seiten;
	private String signatur;
	private int ausgeliehen;
	private int ausleihzeit;

	/**
	 * Setze den Autor und den Titel, wenn ein Exemplar erzeugt wird.
	 */
	public Buch(String buchautor, String buchtitel, int seitenzahl) {
		autor = buchautor;
		titel = buchtitel;
		seiten = seitenzahl;
		signatur = "";
		ausgeliehen = 0;
		ausleihzeit = 2;
	}

	/**
	 * Gib den Autor des Buches zurÃ¼ck.
	 */
	public String gibAutor() {
		return autor;
	}

	/**
	 * Gid den Titel des Buches zurÃ¼ck.
	 */
	public String gibTitel() {
		return titel;
	}

	/**
	 * Der Titel des Buches wird auf der Konsole ausgegeben.
	 */
	public void schreibTitel() {
		System.out.println("##############");
		System.out.println("Titel: " + titel);
		System.out.println("##############");
		System.out.println();
	}

	/**
	 * Der Autor des Buches wird auf der Konsole ausgegeben.
	 */
	public void schreibAutor() {
		System.out.println("##############");
		System.out.println("Autor: " + autor);
		System.out.println("##############");
		System.out.println();
	}

	/**
	 * Gibt alle Details eine Buches auf der Konsole aus.
	 */
	public void detailAusgabe() {
		System.out.println("##############");
		System.out.println("Autor: " + autor);
		System.out.println("Titel: " + titel);
		System.out.println("Seiten: " + seiten);
		if (signatur != "") {
			System.out.println("Signatur: " + signatur);
		}
		else {
			System.out.println("Signatur: Unbekannt");
		}
		System.out.println("Anzahl der Entleihungen:" + ausgeliehen);
		switch (ausleihzeit) {
			case 0:
				System.out.println("Ausleihzeit: Keine Ausleihe möglich");
			case 1:
				System.out.println("Ausleihzeit: Über das Wochenende");
			case 2:
				System.out.println("Ausleihzeit: 7 Tage");
		}
		System.out.println("##############");
		System.out.println();
	}

	/**
	 * Setzt neue Signatur aus Parameter.
	 */
	public void setzeSignatur(String neueSignatur) {
		int laenge = neueSignatur.length();
		if (laenge == 10) {
			signatur = neueSignatur;
		}
		else {
			System.out.println("##############");
			System.out.println("Die Signatur muss genau 10 Zeichen lang sein!");
			System.out.println("##############");
			System.out.println();
		}
	}

	/**
	 * Gibt die aktuelle Signatur zurÃ¼ck.
	 */
	public String gibSignatur() {
		return signatur;
	}

	/**
	 * Gibt aus, wie oft das Buch bereits ausgeliehen wurde.
	 */
	public int gibAusgeliehen() {
		return ausgeliehen;
	}

	/**
	 * Erhöht den "Ausgeliehen"-Zähler um 1.
	 */
	public void ausleihen() {
		ausgeliehen += 1;
	}

	/**
	 * Gibt den Zahlencode für die Ausleihzeit aus.
	 */
	public int gibAusleihzeit() {
		return ausleihzeit;
	}

	/**
	 * Setzt eine neue Ausleihzeit, wenn sie einem gültigen Wert entspricht
	 */
	public void setzeAusleihzeit(int neueAusleihzeit) {
		if (neueAusleihzeit == 0 || neueAusleihzeit == 1
				|| neueAusleihzeit == 2) {
			ausleihzeit = neueAusleihzeit;
		}
		else {
			System.out.println("##############");
			System.out
					.println("Der Wert für die  Ausleihzeit muss 0,1 oder 2 betragen.");
			System.out.println("##############");
			System.out.println();
		}
	}

}