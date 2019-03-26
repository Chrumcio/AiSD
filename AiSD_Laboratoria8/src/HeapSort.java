public class HeapSort { 
	    private int N;
	    public static int[]tab;
	    
	    public HeapSort(){
	    	this.tab=new int[0];
	    }
	    
	    public void wypiszTablice(){
	    	for(int i=0;i<tab.length;i++) {
	    		System.out.print(tab[i]+" ");
	    	}
	    	System.out.println();
	    }	    
	   
	    public void heapify(int arr[]){
	        N = arr.length-1;
	        for (int i = N/2; i >= 0; i--)
	            maxheap(arr, i);        
	    }
	    	     
	    public void maxheap(int arr[], int i){ 
	        int left = 2*i+1 ;
	        int right = 2*i+2;
	        int max = i;
	        if (left <= N && arr[left] < arr[i])
	            max = left;
	        if (right <= N && arr[right] < arr[max])        
	            max = right;
	 
	        if (max != i){
	            swap(arr, i, max);
	            maxheap(arr, max);
	        }
	    }    
	   
	    public static void swap(int arr[], int i, int j){
	        int tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp; 
	    }    
	    
	    public void enqueue(int wartosc){
	    	int[] tmp=new int[tab.length+1];
	    	for(int i=0;i<tab.length;i++) {
	    		tmp[i]=tab[i];
	    	}
	    	tmp[tab.length]=wartosc;
	    	tab=new int[tmp.length];
	    	for(int i=0;i<tmp.length;i++) {
	    		tab[i]=tmp[i];
    		}
	    	heapify(tab);
	    }
	    
	    public int dequeue(){
	    	int tmp[]=new int[tab.length-1];
	    	int temp=tab[0];
	    	tab[0]=tab[tab.length-1];
	    	tab[tab.length-1]=temp;
	    	for(int i=0;i<tmp.length;i++) {
	    		tmp[i]=tab[i];
	    	}
	    	tab=new int[tmp.length];
	    	for(int i=0;i<tab.length;i++) {
	    		tab[i]=tmp[i];
	    	}
	    	heapify(tab);
	    	return temp;
	    }
	    
	    public void zmienWartosc(int indeks,int wartosc){
	    	for(int i=0;i<tab.length;i++) {
	    		if(i==indeks){
	    			tab[i]=wartosc;
	    		}
	    	}
	    	heapify(tab);
	    }
	    
	    public int usunIndeks(int indeks){
	    	int liczba=tab[indeks];
	    	int[]tmp=new int[tab.length];
	    	for(int i=0;i<tab.length;i++){
	    		tmp[i]=tab[i];
	    	}
	    	for(int i=indeks;i<tab.length-1;i++){
	    		tmp[i]=tab[i+1];
	    	}
	    	tab=new int[tab.length-1];
	    	for(int i=0;i<tab.length;i++){
	    		tab[i]=tmp[i];
	    	}
	    	heapify(tab);
	    	return liczba;
	    }
	    
	    public void sort(int[] tablica){    
	    	tab=new int[tablica.length];
	    	for(int i=0;i<tab.length;i++) {
	    		tab[i]=tablica[i];
	    	}
	    	heapify(tab);
	    	System.out.println("Tablica jako kopiec");
	    	wypiszTablice();
	        for (int i=N;i>0;i--){
	            swap(tab,i,0);
	            N=N-1;
	            maxheap(tab,0);
	        }
	    	
	    }   
	    
	    public static void main(String[] args){
	    	HeapSort h=new HeapSort();
	    	h.enqueue(25);
	    	h.enqueue(2);
	    	h.enqueue(58);
	    	h.enqueue(93);
	    	h.enqueue(71);
	    	h.enqueue(39);
	    	h.enqueue(49);
	    	h.enqueue(77);
	    
	    	h.wypiszTablice();
	    	System.out.println(h.dequeue());
	    	System.out.println(h.dequeue());
	    	System.out.println(h.dequeue());
	    	h.wypiszTablice();
	    	//h.zmienWartosc(0, 55);
	    	System.out.println(h.usunIndeks(3));
	    	h.wypiszTablice(); 
	    	
	    	//sortowanie
	    	
	    	int[] tab=new int[8];
	    	for(int i=0;i<tab.length;i++) {
				double a = Math.random()*1000;
				int b=(int)a;
				tab[i]=b;
			}
	    	
	    	System.out.println("Tablica nieposortowana: ");
	    	for(int i=0;i<tab.length;i++) {
	    		System.out.print(tab[i]+" ");
	    	}
	    	System.out.println();
	    	h.sort(tab);
	    	System.out.println("Tablica posortowana");
	    	h.wypiszTablice();
	    	
	    }    
}
