import java.io.File;
import java.util.Scanner;

public class Liczenie {
	public void Oblicz() throws Exception {
		ArrayStack<Integer>stack=new ArrayStack<Integer>();
		File plik=new File("plik.txt");
		Scanner sc=new Scanner(plik);
		int suma=0;
		int iloczyn=0;
		int l1=0;
		String tab[];
		while(sc.hasNextLine()) {
			tab=sc.nextLine().split(" ");
			for(int i=0;i<tab.length;i++) {
				try{
					l1=Integer.parseInt(tab[i]);
					stack.Push(l1);
				}catch(Exception e) {
					if(tab[i].equals("+")) {
						suma=stack.pop()+stack.pop();
						stack.Push(suma);
					}else if(tab[i].equals("*")) {
						iloczyn=stack.pop()*stack.pop();
						stack.Push(iloczyn);
					}
				}
				System.out.print(tab[i]+" ");
			}
			System.out.println();
			System.out.println("wynik="+stack.pop());
		}
		sc.close();
	}
	
	
	public static void main(String args[]) throws Exception {
		Liczenie o=new Liczenie();
		o.Oblicz();
	}
}
