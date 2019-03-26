import java.util.Iterator;

public interface List <T>{
	void insert(int index,T element);
	T get(int index);
	int size();
	void clear();
	void WyswietlListe();
	boolean delete(T element);
	boolean  contains(T element);
	int indexOf(T element);
	T set(int index,T element);
	Iterator<T> iterator();
}
