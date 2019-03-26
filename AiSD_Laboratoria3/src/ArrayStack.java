
public class ArrayStack<E> implements Stack<E>{

	private static final int DEFAULT_CAPACITY =1;
	E array[];
	int topIndex;
	
	@SuppressWarnings("unchecked")
	public ArrayStack (int initialSize){
	array=(E[])(new Object[initialSize]);
	topIndex=0;
	}
	
	public ArrayStack (){
		this(DEFAULT_CAPACITY);
	}
	
	
	@Override
	public boolean isEmpty() {
		return topIndex==0;
	}

	@Override
	public E pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		if(topIndex<0.2*array.length) {
			int size=array.length/2;
			Resize(size);
		}
		return array[--topIndex];
	}

	@Override
	public void Push(E element) throws FullStackException {
		if(topIndex>0.8*array.length) {
			int size=2*array.length;
			Resize(size);
			array[topIndex++]=element;
		}else {
			array[topIndex++]=element;
		}
	}
	
	@Override
	public int size() {
		return array.length;
	}

	@Override
	public E top() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
			return array[topIndex-1];
			
	}
	
	public void Resize(int size) {
		E array1[]=(E[])(new Object[size]);
		for(int i=0;i<topIndex;i++) {
			array1[i]=array[i];
		}
		array=array1;
	}
}
