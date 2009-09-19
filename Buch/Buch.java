/**
 * Eine Klasse, deren Exemplare Informationen über ein Buch halten.
 * Dies könnte Teil einer größeren Anwendung sein, einer
 * Bibliothekssoftware beispielsweise.
 *
 * @author (Ihren Namen hier eintragen.)
 * @version (das heutige Datum eintragen.)
 */
class Buch {
	// Exemplarvariablen
	private String autor;
	private String titel;

	/**
	 * Setze den Autor und den Titel, wenn ein Exemplar erzeugt wird.
	 */
	public Buch(String buchautor, String buchtitel) {
		autor = buchautor;
		titel = buchtitel;
	}

	/**
	 * Gib den Autor des Buches zurück.
	 */
	public String gibAutor() {
		return autor;
	}

	/**
	 * Gid den Titel des Buches zurück.
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
	public void schreibAutorl() {
		System.out.println("##############");
		System.out.println("Autor: " + autor);
		System.out.println("##############");
		System.out.println();
	}

}