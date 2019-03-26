
public interface Stack <T>{
	boolean isEmpty();
	T pop() throws EmptyStackException;
	void push(T elem) throws FullStackException;
	int size(); 
}
