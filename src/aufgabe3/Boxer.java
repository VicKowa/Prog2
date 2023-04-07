package aufgabe3;

public class Boxer extends Person {
	
	private int gewicht;
	
	public Boxer(String name, String vorname, int gewicht) {
		
		super(name, vorname);
		this.gewicht = gewicht;
	}
	
	
	public int getGewicht() {
		
		return gewicht;
	}
	
	public boolean equals(Person p) {
		Boxer b = null;

		if(p instanceof Boxer) {
			b = (Boxer) p;
		}
		assert b != null;
		return (super.equals(p) & this.gewicht == b.getGewicht());


	}
}
