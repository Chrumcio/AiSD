
public class Kolejka<T> implements Queue<T>{
	private Element head=new Element(null);
	private int size;
	public Kolejka() {
		clear();
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if(isEmpty())throw new EmptyQueueException();
		Element el=head.getNext();
		head.setNext(el.getNext());
		--size;
		return (T)el.getValue();
	}

	@Override
	public void enqueue(Object elem) {
		Element e=new Element(elem);
		if(size==0) {
			head.setNext(e);
		}else {
			Element next=head.getNext();
			for(int i=0;i<size-1;i++) {
				next=next.getNext();
			}
			next.setNext(e);
			
		}
		++size;
		
	}

	@Override
	public int size() {
		return size;
	}
	
	public void clear() {
		size=0;
	}
	
	public void wyswietl() {
		Element e=head;
		while(e.getNext()!=null) {
			e=e.getNext();
			System.out.println(e.getValue());
		}
		
	}
	
	private class Element{
		Object value;
		Element next;
		
		public Element(Object value) {
			this.value=value;
		}
		
		public Object getValue() {
			return value;
		}
		
		public void setValue(Object value) {
			this.value=value;
		}
		
		public Element getNext() {
			return next;
		}
		
		public void setNext(Element next) {
			this.next=next;
		}
	}
	public static void main(String args[]) throws Exception {
		Kolejka k=new Kolejka();
		k.enqueue("cos");
		k.enqueue("jak to");
		k.enqueue("dodaj");
		k.wyswietl();
		System.out.println();
		k.dequeue();
		k.wyswietl();
	}

}