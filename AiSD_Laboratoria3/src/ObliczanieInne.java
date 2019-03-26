import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ObliczanieInne {
	
	public void Oblicz() throws Exception {
		ArrayStack<Integer>stack=new ArrayStack<Integer>();
		ArrayStack<String>stack1=new ArrayStack<String>();
		File plik=new File("plik.txt");
		Scanner sc=new Scanner(plik);
		Scanner sca=new Scanner(plik);
		int suma=0;
		int iloczyn=0;
		int l1=0;
		String el;
		while(sc.hasNext()) {
			el=sc.next();
			try{
				l1=Integer.parseInt(el);
				stack.Push(l1);
			}catch(Exception e) {
				if(el.equals("+")) {
					suma=stack.pop()+stack.pop();
					stack.Push(suma);
				}else if(el.equals("*")) {
					iloczyn=stack.pop()*stack.pop();
					stack.Push(iloczyn);
				}
			}
		}
		while(sca.hasNextLine()) {
			stack1.Push(sca.nextLine());
		}
		while(!stack.isEmpty()) {
			System.out.println(stack1.pop());
			System.out.println("wynik= "+stack.pop());
		}
		sc.close();
		sca.close();
	}	
	
	public static void main(String args[]) throws Exception {
		ObliczanieInne o=new ObliczanieInne();
		o.Oblicz();
	}
}
