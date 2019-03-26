import java.util.Comparator;

public class Samochod{
	private String marka;
	private String kolor;
	private int rokprodukcji;
	
	public Samochod(String marka,String kolor,int rokprodukcji) {
		this.marka=marka;
		this.kolor=kolor;
		this.rokprodukcji=rokprodukcji;
	}
	
	public String toString() {
		return marka+" "+kolor+" "+rokprodukcji;
	}

	public static final Comparator<Samochod> Po_Marce=(s1,s2)->s1.marka.compareTo(s2.marka);
	public static final Comparator<Samochod> Po_Kolorze=(s1,s2)->s1.kolor.compareTo(s2.kolor);
	public static final Comparator<Samochod> Po_Rokprodukcji=(s1,s2)->s1.rokprodukcji - s2.rokprodukcji;
	public static final Comparator<Samochod> Zbiorczy=new Comparator<Samochod>() {

		@Override
		public int compare(Samochod s1, Samochod s2) {
			if(Po_Marce.compare(s1, s2)!=0) {
				return Po_Marce.compare(s1, s2);
			}
			
			if(Po_Kolorze.compare(s1, s2)!=0) {
				return Po_Kolorze.compare(s1, s2);
			}
			return Po_Rokprodukcji.compare(s1, s2);
		}
		
	};
}
