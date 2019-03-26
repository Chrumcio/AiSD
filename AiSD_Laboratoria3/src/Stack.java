public interface Stack <E>{
	boolean isEmpty();
	E pop() throws EmptyStackException;
	void Push(E element) throws FullStackException;
	int size();
	E top() throws EmptyStackException;
}
