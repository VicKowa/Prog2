package aufgabe3;

public class Person {
	
	private String name;
	private String vorname;
	
	public Person(String name, String vorname ) {
		this.name = name;
		this.vorname = vorname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getVorname() {
		return vorname;
	}
	

	public String toString() {
		return name + ", " + vorname;
	}
	
	public boolean equals(Person p) {
		if (p != null) {
			return this.name.equals(p.getName()) &
					this.vorname.equals(p.getVorname());
		} else return false;


	}
}
