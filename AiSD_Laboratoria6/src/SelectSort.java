import java.util.Comparator;
import java.util.List;

public class SelectSort<T> implements ListSorter<T> {
	private final Comparator<T> _comparator;
	public SelectSort(Comparator<T> comparator) {
		_comparator = comparator;
	}
	
	@Override
	public List<T> sort(List<T> list) {
		for (int i = 0; i < list.size() - 1; ++i) {
			int poczatkowy = i;
			for (int j = i + 1; j < list.size(); ++j)
				if (_comparator.compare(list.get(j), list.get(poczatkowy)) < 0)
					poczatkowy = j;
			zamien(list, poczatkowy, i);
		}
		return list;
	}
	private void zamien(List<T> list, int left, int right) {
		if (left != right) {
			T temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
		}
	}
}