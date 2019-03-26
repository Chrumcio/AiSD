import java.util.Comparator;
import java.util.List;

public class InsertSort<T> implements ListSorter<T> {
	private Comparator<T> _comparator;
	public InsertSort(Comparator<T> comparator){
		_comparator = comparator;
	}
	
	@Override
	public List<T> sort(List<T> list) {
		for (int i = 1; i < list.size(); ++i) {
			T value = list.get(i),temp;
			int j;
			for (j = i; j > 0&& _comparator.compare(value, temp=list.get(j - 1))< 0; --j)
				list.set(j,temp);
			list.set(j, value);
		}
		return list;
	}
}