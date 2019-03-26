import java.util.Iterator;

public class LinkedList<T> implements List<T>{
	private Element head=null;
	private int size;
	
	@Override
	public void insert(int index, T element) {
		Element el=new Element(element);
		if(head==null) {
			head=el;
		}else if(index>size || index<0) {
			throw new IndexOutOfBoundsException();
		}else if(index==0) {
			Element next=head;
			head=el;
			head.setNext(next);
		
		}else if(index==size) {
			Element next=head;
			while(next.getNext()!=null) {
				next=next.getNext();
			}
			next.setNext(el);
		}else {
			Element tempElem=head;
			Element actElem=head;
			while (index > 1) {
                actElem = actElem.next;
                index--;
            }
            tempElem=actElem.next;
            actElem.next=new Element(element);
            actElem.next.next=tempElem;
		}
		++size;
	}

	@Override
	public T get(int index) {
		Element el=head;
		for(int i=0;i<index;i++) {
			el=el.getNext();
		}
		return el.getValue();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head=null;
		size=0;
	}

	@Override
	public void WyswietlListe() {
		Element e=head;
		for(int i=0;i<size;i++) {
			System.out.println(e.getValue());
			e=e.getNext();
		}		
	}
	
	public Element delete(int index) {
		Element next=head;
		if(head==null) {
			return null;
		}else if(index==0) {
			Element el=head;
			head=next.getNext();
			--size;
			return el;
		}else if(index<0 || index>size) {
			throw new IndexOutOfBoundsException();
		}else{
			for(int i=1;i<index;i++) {
				next=next.getNext();
			}
			Element el=next.getNext();
			next.setNext(next.getNext().getNext());
			--size;
			return el;
		}
	}
	
	
	@Override
	public boolean delete(T element) {
		Element next=head;
		Element el=head;
		int ilosc=0;
		while(el.getNext()!=null) {
			if(el.getValue().equals(element)) {
				ilosc++;
			}
			el=el.getNext();
		}
		boolean zm=false;
		if(next.getValue().equals(element)) {
			head=next.getNext();			
			--size;
			zm=true;
		}else {
			for(int i=0;i<ilosc;i++) {
				while(next.getNext().getNext()!=null && !next.getNext().getValue().equals(element)) {
					next=next.getNext();
				}
				next.setNext(next.getNext().getNext());
				--size;
				zm=true;
			}
		}
		return zm;
	}

	@Override
	public boolean contains(T element) {
		return indexOf(element)>=0;
	}

	@Override
	public int indexOf(T element) {
		int pos=0;
		Element next=head;
		while(next!=null) {
			if(element.equals(next.getValue())) {
				return pos;
				
			}
			pos++;
			next=next.getNext();
		}
		return -1;
	}

	@Override
	public T set(int index, T element) {
		Element el=head;
		if(index==0) {
			head.setValue(element);
		}else {
			for(int i=0;i<index;i++) {
				el=el.getNext();
			}
			el.setValue(element);
		}
		return el.getValue();
	}	
	
	private class InnerIterator<T> implements Iterator<T>{
		Element actElem;
		public InnerIterator() {
		actElem=head;
		}
		@Override
		public boolean hasNext() {
		return actElem!=null;
		}
		@Override
		public T next() {
		T value=(T) actElem.getValue();
		actElem=actElem.getNext();
		return value;
		}
		}
		@Override
		public Iterator<T> iterator() {
		return new InnerIterator();
		}
	
	private class Element{
		T value;
		Element next;
		
		public Element(T value) {
			this.value=value;
		}
		
		public T getValue() {
			return value;
		}
		
		public void setValue(T value) {
			this.value=value;
		}
		
		public Element getNext() {
			return next;
		}
		
		public void setNext(Element next) {
			this.next=next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Towar> l=new LinkedList<Towar>();
		Towar t1=new Towar("Mleko",2,2.50);
		Towar t2=new Towar("Jajka",100,0.50);
		Towar t3=new Towar("Karton",2,2.50);
		Towar t4=new Towar("Cola",10,3.50);
		Towar t5=new Towar("Jablka",20,0.10);
		Towar t6=new Towar("Kasza",15,2.20);
		Towar t7=new Towar("Sprite",20,1.50);
		Towar t8=new Towar("Fanta",100,5.40);
		l.insert(0, t1);
		l.insert(1, t2);
		l.insert(0, t3);
		l.insert(3, t4);
		l.insert(2, t5);
		l.insert(3, t6);
		l.insert(5, t7);
		l.insert(7, t8);
		l.insert(4, t5);
		l.WyswietlListe();
		System.out.println();
		l.delete(t5);
		l.WyswietlListe();
		l.delete(5);
		//System.out.println(l.indexOf(t6));
		//System.out.println(l.contains(t4));
		System.out.println();
		Iterator<Towar> it=l.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
