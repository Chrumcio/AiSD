import java.awt.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		ArrayList<Samochod> samochody=new ArrayList<Samochod>();
		
		Samochod s1=new Samochod("Seat", "Niebieski", 2015);
		Samochod s2=new Samochod("Seat", "Niebieski", 2010);
		Samochod s3=new Samochod("Opel", "Czarny", 2000);
		Samochod s4=new Samochod("Opel", "Bia³y", 2010);
		Samochod s5=new Samochod("Skoda", "Czerwony", 2005);
		
		samochody.add(s1);
		samochody.add(s2);
		samochody.add(s3);
		samochody.add(s4);
		samochody.add(s5);
		
		System.out.println("Nieposortowane");
		wyswietl(samochody);
		/*
		InsertSort<Samochod> i1=new InsertSort<Samochod>(Samochod.Po_Marce);
		i1.sort(samochody);
		System.out.println("Sortowanie InsertSort (pojedynczy klucz po marce)");
		wyswietl(samochody);
		
		InsertSort<Samochod> i2=new InsertSort<Samochod>(Samochod.Po_Kolorze);
		i2.sort(samochody);
		System.out.println("Sortowanie InsertSort (pojedynczy klucz po kolorze)");
		wyswietl(samochody);
		
		System.out.println("Sortowanie InsertSort (pojedynczy klucz po roku produkcji)");
		InsertSort<Samochod> i3=new InsertSort<Samochod>(Samochod.Po_Rokprodukcji);
		i3.sort(samochody);
		wyswietl(samochody);
		
		
		InsertSort<Samochod> i4=new InsertSort<Samochod>(Samochod.Zbiorczy);
		i4.sort(samochody);
		System.out.println("Sortowanie InsertSort (komparator zbiorczy)");
		wyswietl(samochody);
		*/
		SelectSort<Samochod>ss1=new SelectSort<Samochod>(Samochod.Po_Marce);
		ss1.sort(samochody);
		System.out.println("Sortowanie SelectSort (pojedynczy klucz po marce)");
		wyswietl(samochody);
		System.out.println();
		
		SelectSort<Samochod>ss2=new SelectSort<Samochod>(Samochod.Zbiorczy);
		ss2.sort(samochody);
		System.out.println("Sortowanie komparator zbiorczy");
		wyswietl(samochody);
		
		
	}
	
	static void wyswietl(ArrayList<Samochod> lista){
		for(Samochod s:lista) {
			System.out.println(s);
		}
	}

}
