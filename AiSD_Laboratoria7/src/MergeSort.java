import java.util.Iterator;
public class MergeSort {
	private int porownania;
	private int swaps;
	private Comparator _comparator;
	
	public MergeSort(Comparator comparator) {
		this._comparator=comparator;
	}
	
	public int[] sort(int[]tab) {
		return mergesort(tab,0,tab.length-1);
	}
	
	public int[] mergesort(int []tab,int startIndex,int endIndex) {
		if(startIndex==endIndex) {
			int tmp[]=new int[1];
			tmp[0]=tab[startIndex];
			return tmp;
		}
		
		//szukanie indeksu granicznego lewej polowki
		int splitIndex=startIndex+(endIndex-startIndex)/2;
		//sortowanie lewej polowki (d¹¿enie do osi¹gniêcia pojedynczego elementu, który jest uwa¿any za posortowany)
		int[]left=mergesort(tab,startIndex,splitIndex);
		
		//sortowanie prawej polowki (d¹¿enie do osi¹gniêcia pojedynczego elementu, który jest uwa¿any za posortowany)
		int [] right=mergesort(tab,splitIndex+1,endIndex);
		
		//laczenie posortowanych polowek
		return merge(left,right);
		
	}
	
	 private int[] merge(int[] left, int[] right){
		 int[] result = new int[left.length+right.length];
		 int lewy=0;
	     int prawy=0;
	     for(int i=0; i<result.length; i++) {
	    	 if(_comparator.compare(lewy, left.length)<0 && _comparator.compare(prawy, right.length)<0){
	    		 porownania++;
	    		 if(_comparator.compare(left[lewy], right[prawy])<=0){
	    			 result[i]=left[lewy];
	                 lewy++;
	                 swaps++;
	                 }else if(_comparator.compare(right[prawy], left[lewy])<0){
	                	 result[i]=right[prawy];
	                	 prawy++;
	                	 swaps++;
	                	 }
	    		 }else if(_comparator.compare(lewy, left.length)<0){
	    			 result[i]=left[lewy];
	    			 lewy++;
	    			 swaps++;
	    			 }else if(_comparator.compare(prawy, right.length)<0){
	    				 result[i]=right[prawy];
	    				 prawy++;
	    				 swaps++;
	    				 }
	    	 }
	     return result;
	     }
	 
	 public int getSwaps() {
		 return swaps;
	 }
	 
	 public void zerujSwaps() {
		 this.swaps=0;
	 }
	 
	 public int getPorownania() {
		 return porownania;
	 }
	 
	 public void zerujPorownania() {
		 this.porownania=0;
	 }
	
	 public String toString() {
			return String.format("%10s %2s %2s", porownania,"|", swaps);
	 }
}

