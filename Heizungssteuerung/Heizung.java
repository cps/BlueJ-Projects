/**
 * .
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Heizung {
	// Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
	double temperatur;

	/**
	 * Konstruktor f�r Objekte der Klasse Heizung
	 */
	public Heizung() {
		temperatur = 15.5;
	}

	/**
	 * Pr�ft ob die Temperatur im Intervall ist.
	 */
	public boolean pruefeTemperatur(double temp) {
		if (temp >= 0 && temp <= 45) {
			return true;
		}
		else {
			System.out
					.println("Fehler: Die Temperatur befindet sich nicht im korrekten Bereich von 0-45 Grad!");
			return false;
		}
	}

	/**
	 * Macht alles w�rmer (siehe Klimawandel).
	 */
	public void waermer() {
		if (pruefeTemperatur(temperatur + 0.5)) {

			temperatur += 0.5;
		}
	}

	/**
	 * Macht alles k�hler (siehe Eiszwerg). 
	 */
	public void kuehler() {
		if (pruefeTemperatur(temperatur - 0.5)) {
			temperatur -= 0.5;
		}
	}

	/**
	 * Macht alles total warm.
	 */
	public void schnellWaermer() {
		if (pruefeTemperatur(temperatur + 5)) {
			temperatur += 5;
		}
	}

	/**
	 * Macht alles total kalt (macht im K�hlschrank das Licht aus, Freund vom Eiszwerg).
	 */
	public void schnellKuehler() {
		if (pruefeTemperatur(temperatur - 5)) {
			temperatur -= 5;
		}
	}

	/**
	 * Gibt die aktuelle Temperatur zur�ck.
	 */
	public double gibTemperatur() {
		return temperatur;
	}

	/**
	 * Drucke falsch gerundete Temperatur auf der Konsole.
	 */
	public void druckeTemperatur() {
		System.out.println("Die aktuelle Temperatur betr�gt: "
				+ (int) temperatur + " Grad Celsius.");
	}

	/**
	 * Gibt die Temperatur in einer improvisiert grafischen Anzeige in der Konsole aus.
	 */
	public void druckeThermometer() {
		System.out.println("###############");
		druckeTemperatur();
		for (int z = 1; z <= (int) gibTemperatur(); z++) {
			System.out.print("0");
		}
		System.out.println("\n0||||5|||10||||15|||20|||25|||30|||35|||40|||45");
		System.out.println("###############");
	}

}