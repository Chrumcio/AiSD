import java.util.Scanner;

public class Odwracanie {

	public void Odwroc() throws Exception {
		ArrayStack<String>stack=new ArrayStack<String>();
		Scanner sc=new Scanner(System.in);
		String elem="";
		do{		
			System.out.println("Podaj zdanie: ");
			elem=sc.nextLine();
			if(!elem.equals("")) {
				for(String el:elem.split("")) {
					stack.Push(el);
				}
			}
			while(!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
			System.out.println();
		}while(!elem.equals(""));	
		sc.close();
	}
	
	public static void main(String args[]) throws Exception {
		Odwracanie o=new Odwracanie();
		o.Odwroc();
	}
}
