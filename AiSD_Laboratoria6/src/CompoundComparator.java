import java.util.Comparator;

public class CompoundComparator<T> implements Comparator<T>{
	
	private Comparator<T>[] comparators;
	
	
	public CompoundComparator(Comparator<T>...comparators) {
		this.comparators=comparators;
	}
	
	@Override
	public int compare(T o1, T o2) {
		for(Comparator<T> c:comparators) {
			if(c.compare(o1, o2)!=0) {
				return c.compare(o1, o2);
			}
		}
		return 0;
	}

}
