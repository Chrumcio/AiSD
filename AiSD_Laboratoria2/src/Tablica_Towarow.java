
public class Tablica_Towarow {
	private Towar[] tab;
	private Towar[] tab1;
	public Tablica_Towarow() {
		tab=new Towar[5];
	}
	
	public void stworzTowary() {
		tab[0]=new Towar("Mleko",10,5.0);
		tab[1]=new Towar("Platki",100,7.5);
		tab[2]=new Towar("Jajka",360,0.1);
		tab[3]=new Towar("Jablka",0,2.5);
		tab[4]=new Towar("Gruszki",60,3.2);
	}
	
	public void wyswietlTowary() {
		ArrayIterator<Towar> it=new ArrayIterator<Towar>(tab);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void zmienCene(String nazwa, double cena) {
		ArrayIterator<Towar> it1=new ArrayIterator<Towar>(tab);
		while(it1.hasNext()) {
			Towar s=it1.next();
			if(s.nazwa.equals(nazwa)) {
				s.cena=cena;
			}
		}
	}
	
	public void wyswietlMniejsza() {
		Predykator<Towar> pred=new IloscZero();
		ArrayIterator<Towar> it1=new ArrayIterator<Towar>(tab);
		FilterIterator<Towar> itr=new FilterIterator<Towar>(it1,pred);
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	public void zliczTowary() {
		Predykator<Towar> pred=new Ilosc();
		ArrayIterator<Towar> it1=new ArrayIterator<Towar>(tab);
		FilterIterator<Towar> itr=new FilterIterator<Towar>(it1,pred);
		int i=0;
		while(itr.hasNext()) {
			itr.next();
			i++;
		}
		tab1=new Towar[i];
	}
	
	public void skopiujTowary() {
		Predykator<Towar> pred=new Ilosc();
		ArrayIterator<Towar> it1=new ArrayIterator<Towar>(tab);
		FilterIterator<Towar> itr=new FilterIterator<Towar>(it1,pred);
		int i=0;
		while(itr.hasNext()) {
			tab1[i]=itr.next();
			i++;
		}
	}
	
	public void wyswietlSkopiowana() {
		for(Towar t:tab1) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		Tablica_Towarow t=new Tablica_Towarow();
		t.stworzTowary();
		t.wyswietlTowary();
		t.zmienCene("Mleko", 2.75);
		System.out.println("Po zmianie ceny");
		t.wyswietlTowary();
		System.out.println();
		t.wyswietlMniejsza();
		t.zliczTowary();
		t.skopiujTowary();
		System.out.println();
		t.wyswietlSkopiowana();
	}
	
}
