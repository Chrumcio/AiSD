
public class Ilosc implements Predykator{

	public boolean accept(Object arg) {
		return ((Towar)arg).ilosc==0;
	}

}
