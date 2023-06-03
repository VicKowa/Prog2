package woche9;

import Woche1.aufgabe3.Person;

public class Boxer extends Person implements Comparable<Boxer> {
	
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

		if(p instanceof Boxer & p != null) {
			b = (Boxer) p;
			return (super.equals(p) & this.gewicht == b.getGewicht());
		} else {
			return false;
		}

	}

	@Override
	public int compareTo(Boxer o) {
		int gewichtComp = this.getGewicht() - o.getGewicht();
		int nameComp = this.getName().compareTo(o.getName());

		if(gewichtComp != 0) {
			return gewichtComp;
		}
		if (nameComp != 0) {
			return nameComp;
		}
		return this.getVorname().compareTo(o.getVorname());
	}
}
