import java.util.Iterator;

public class FilterIterator<T> implements Iterator<T>{
	private Iterator<T> itr;
	private Predykator<T> pred;
	
	private T elemNext=null;
	private boolean bHasNext=true;
	
	public FilterIterator(Iterator<T> itr,Predykator <T> pred) {
		this.itr=itr;
		this.pred=pred;
		findNextValid();
	}
	
	private void findNextValid() {
		while (itr.hasNext()) {
		elemNext = itr.next();
		if (pred.accept(elemNext)) {
		return;
		}
		}
		bHasNext=false;
		elemNext=null;
		}
	
	public boolean hasNext() {
		return bHasNext;
		}
	
	public T next() {
		T nextValue = elemNext;
		findNextValid();
		return nextValue;
		}
	
}
