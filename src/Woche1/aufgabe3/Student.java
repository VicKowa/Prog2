package Woche1.aufgabe3;

public class Student extends Person{
	
	private int matrikelnummer;
	
	public Student(String name, String vorname, int manum) {
		super(name, vorname);
		this.matrikelnummer = manum;
		
	}
	
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	
	public String toString() {
		return super.toString() + " " + matrikelnummer;
	}
	
	public boolean equals(Person p) {

		Student s = null;

		if(p instanceof Student & p != null) {
			s = (Student) p;
			return super.equals(p) & this.matrikelnummer == s.getMatrikelnummer();
		} else return false;

	}
}
