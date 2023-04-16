package Woche1.aufgabe3;

public class Boxer extends Person {
	
	private int gewicht;
	
	public Boxer(String name, String vorname, int gewicht) {
		
		super(name, vorname);
		this.gewicht = gewicht;
	}
	
	
	public int getGewicht() {
		
		return gewicht;
	}

	public String toString() {
		return super.toString() + ", " + gewicht;
	}
	
	public boolean equals(Person p) {
		Boxer b = null;

		if(p instanceof Boxer & p != null) {
			b = (Boxer) p;
			return (super.equals(p) & this.gewicht == b.getGewicht());
		} else {
			return false;
		}

	}
}
