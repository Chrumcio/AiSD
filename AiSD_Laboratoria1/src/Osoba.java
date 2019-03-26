import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Osoba {
	protected String indeks,nazwisko,imie,ocena;
	private ArrayList<Student> lista=new ArrayList<Student>();
	private Iterator<Student> itr;
	public Osoba() {	
	}
	
	public Osoba(String indeks,String nazwisko,String imie,String ocena) {
		this.indeks=indeks;
		this.nazwisko=nazwisko;
		this.imie=imie;
		this.ocena=ocena;
	}
	
	public void StworzOsobe() throws Exception {
		File plik=new File("plik.txt");
		Scanner odczyt=new Scanner(plik);
		while(odczyt.hasNext()) {
			String tablica[]=odczyt.nextLine().split(" ");
			indeks=tablica[0];
			nazwisko=tablica[1];
			imie=tablica[2];
			ocena=tablica[3];
			Student s=new Student(indeks,nazwisko,imie,ocena);
			lista.add(s);
		}
		odczyt.close();
	}
	
	public void WyswietlListe() {
		itr=lista.iterator();
		while(itr.hasNext()) {
			Student s=itr.next();
			System.out.println(s);
		}
	}
	
	public void WpiszStudentowi(String id,String stopien) {
		for(Student s:lista) {
			if(s.indeks.equals(id)) {
				s.ocena=stopien;
			}
		}
	}
	
	public void SredniaOcen() {
		double suma=0;
		double srednia=0;
		int i=0;
		double liczba=0;
		for(Student s:lista) {
			try {
			liczba=Double.parseDouble(s.ocena);
			}catch(Exception e) {
				
			}
			if(liczba>=3) {
				suma=suma+liczba;
				i++;
			}
		}
		srednia=suma/i;
		System.out.println("Srednia ocen: "+srednia);
	}
	
	public void WyswietlOblanych() {
		double liczba=0;
		for(Student s:lista) {
			try {
				liczba=Double.parseDouble(s.ocena);
			}catch(Exception e) {
				
			}
			if(liczba<3) {
				System.out.println(s);
			}
		}
	}
	
	public void ZapiszPlik() throws Exception {
		BufferedWriter writer=new BufferedWriter(new FileWriter("plik2.txt"));
		for(Student s:lista) {
			writer.write(s.indeks+" ");
			writer.write(s.nazwisko+" ");
			writer.write(s.imie+" ");
			writer.write(s.ocena);
			writer.newLine();
		}
		writer.close();
	}
	public static void main(String[] args) throws Exception {
		Osoba o=new Osoba();
		o.StworzOsobe();
		o.WyswietlListe();
		o.WpiszStudentowi("242424", "4.0");
		System.out.println();
		o.WyswietlListe();
		o.SredniaOcen();
		o.WyswietlOblanych();
		o.ZapiszPlik();
	}
}
