package Woche2.aufgabe5;
public class GenericsFehler{
	public static void main(String[] args){
		MyObject mo = new MyObject();//ein neues Object der Klasse MyObject wird erstellt
		MyGeneric<String> mg = new MyGeneric<>(); //ein neues Object der Klasse MyGeneric mit dem Parameter String wird erstellt

		String s1 = "Hallo";//String variable deklarierung + initialisierung
		Integer i1 = 42;//Integer variable deklarierung + initialisierung

		mo.set(i1);// dem Object wird ein Integer zugewiesen
		mo.set(s1);// dem Object wird ein String zugewiesen
		String s2 = (String) mo.get(); //mo.get liefert ein object, indem Fall das String object welches dann gecastet wird
	 //       Integer i2 = (Integer) mo.get();//mo liefert ein object, welches, indem Fall ein string enthält, welches dann zum Integer gecastet wird was nicht möglich ist
		

		mg.set(s1);//dem GenericObject mit String als parameter wird ein String gesetzt (Möglich)
	//	mg.set(i1);//dem GenericObject mit String als parameter wird ein Integer zugewiesen nicht möglich
		String s3 = mg.get();// einer String variable wird ein Stringobject des Generic Objects zugewiesen

		//Integer i3 = (Integer)mg.get();// einer Integer varible wird versucht ein String zuzuweisen geht nicht String kann nicht zu integer gecastet werden


	}
}

/** This class is a simplified 'container' for objects of type Object
    thus all subtypes of Object can be stored
    so in Java every kind of type   */
class MyObject{
	private Object o;
	public void set(Object o){
		this.o = o;
	}
	public Object get(){
		return o;
	}
}

/** This is a simple container for storing an object of a generic type
    so any given type (and it's subclasses) */
class MyGeneric<T>{
	private T o;
	public void set(T o){
		this.o = o;
	}
	public T get(){
		return o;
	}
}
