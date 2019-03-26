
public class Towar {
	protected String nazwa;
	protected int ilosc;
	protected double cena;
	protected double wartosc;
	public Towar(String nazwa,int ilosc,double cena) {
		this.nazwa=nazwa;
		this.ilosc=ilosc;
		this.cena=cena;
		this.wartosc=ilosc*cena;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void setNazwa(String nazwa) {
		this.nazwa=nazwa;
	}
	
	public int getIlosc() {
		return ilosc;
	}
	
	public void setIlosc(int ilosc) {
		this.ilosc=ilosc;
	}
	
	public double getCena() {
		return cena;
	}
	
	public void setCena(double cena) {
		this.cena=cena;
	}
	
	public double getWartosc() {
		return wartosc;
	}
	
	public String toString() {
		return nazwa+"\t"+ilosc+"\t"+cena+"\t"+wartosc;
	}
}