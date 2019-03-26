
public class Student {
	protected String indeks,nazwisko,imie,ocena;
	public Student(String indeks,String nazwisko,String imie,String ocena) {
		this.indeks=indeks;
		this.nazwisko=nazwisko;
		this.imie=imie;
		this.ocena=ocena;
	}
	
	public String getIndesk() {
		return indeks;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public String getImie() {
		return imie;
	}
	
	public String getOcena() {
		return ocena;
	}

	public String toString() {
		return indeks+" "+nazwisko+" "+imie+" "+ocena;
	}
}
