/**
 * Drei Zahlen sortieren.
 * 
 * @author CPS
 * @version 0.1b1
 */
public class Zahlentripel {
	private int x_1;
	private int x_2;
	private int x_3;
	private int sp;

	/**
	 * Konstruktor, der alle Zahlen auf 0 setzt.
	 */
	public Zahlentripel() {
		x_1 = 0;
		x_2 = 0;
		x_3 = 0;
	}

	/**
	 * Konstruktor, der nach drei Zahlen fragt und den Rest alleine erledigt.
	 */
	public Zahlentripel(int x1, int x2, int x3) {
		setzeZahlen(x1, x2, x3);
		sortieren();
		zahlenAusgeben();
	}

	/**
	 * Zahlen eingeben und auf die jeweiligen Felder setzen.
	 *
	 * @param  x   Drei Zahlen, jeweils int
	 */
	public void setzeZahlen(int x1, int x2, int x3) {
		x_1 = x1;
		x_2 = x2;
		x_3 = x3;
	}

	/**
	 * An example of a method - replace this comment with your own
	 *
	 * @param  y   a sample parameter for a method
	 * @return     the sum of x and y
	 */
	public void zahlenAusgeben() {
		System.out.println("##############");
		System.out.println("x_1 \t" + x_1);
		System.out.println("x_2 \t" + x_2);
		System.out.println("x_3 \t" + x_3);
		System.out.println("##############");
	}

	/**
	 * Die drei Zahlen werden durch drei if-Schleifen sortiert.
	 */
	public void sortieren() {

		if (x_2 >= x_3) {
			sp = x_3;
			x_3 = x_2;
			x_2 = sp;
		}

		if (x_1 >= x_3) {
			sp = x_3;
			x_3 = x_1;
			x_1 = sp;
		}

		if (x_1 >= x_2) {
			sp = x_2;
			x_2 = x_1;
			x_1 = sp;
		}

	}
}