
public class Stos<T> implements Stack<T>{
	private int size;
	private Element head=new Element(null);
	
	public Stos() {
		size=0;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public T pop() throws EmptyStackException {
		Element el=head;
		if(isEmpty()) {
			throw new EmptyStackException();
		}else {
			for(int i=0;i<size-1;i++) {
				el=el.getNext();
			}
			el.setNext(null);
			size--;
			return (T)head.getValue();
		}
	}

	@Override
	public void push(T elem) throws FullStackException {
		Element element = new Element(elem);
		if(size == 0) {
			head.setNext(element);
		}else {
			Element prev = head.getNext();
			for(int i=0; i < size - 1; i++) {
				prev = prev.getNext();
			}
			prev.setNext(element);
			
		}
		++size;
	}

	@Override
	public int size() {
		return size;
	}
	
	public void Wyswietl() {
		Element e=head;
		while(e.getNext()!=null) {
			e=e.getNext();
			System.out.println(e.getValue()+" "+size);
		}
	}
	
	private static class Element{
		Object value;
		Element next;

		public Element(Object value){
			this.value = value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Object getValue() {
			return value;
		}

		public void setNext(Element next){
			this.next = next;
		}

		public Element getNext() {
			return next;
		}
	}
	
	public static void main(String args[]) throws Exception {
		Stos s=new Stos();
		s.push("cos");
		s.push("tak");
		s.push("nie");
		s.Wyswietl();
		System.out.println();
		s.pop();
		s.Wyswietl();
		System.out.println();
		s.pop();
		s.Wyswietl();
		System.out.println();
		s.pop();
	}
}
