
public class IloscZero implements Predykator{
	public boolean accept(Object arg) {
		return ((Towar)arg).cena<3.5;
	}

}
