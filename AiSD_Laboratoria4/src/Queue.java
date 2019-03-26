
public interface Queue <E>{
	boolean isEmpty();
	E dequeue() throws EmptyQueueException;
	void enqueue(E elem) throws FullQueueException;
	int size();
	
}
