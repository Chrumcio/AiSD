import java.util.NoSuchElementException;
import java.util.Scanner;

public class BST <T>{
	Node root;
	
	public void addNode(int key,T value) {
		Node newNode=new Node(key,value);
		
		if(root==null) {
			root=newNode;
		}else {
			Node focusNode=root;
			Node parent;
			while(true) {
				parent=focusNode;
				if(key<focusNode.key) {
					focusNode=focusNode.leftChild;
					if(focusNode==null) {
						parent.leftChild=newNode;
						newNode.parent=parent;
						return;
					}
				}else {
					focusNode=focusNode.rightChild;
					if(focusNode==null) {
						parent.rightChild=newNode;
						newNode.parent=parent;
						return;
					}
				}
			}
		}
	}
	
	public void inOrder(Node focusNode) {
		if(focusNode!=null) {
			inOrder(focusNode.leftChild);
			System.out.print(focusNode.key+" ");
			inOrder(focusNode.rightChild);
		}
	}
	
	public void preOrder(Node focusNode) {
		if(focusNode!=null) {
			System.out.print(focusNode.key+" ");
			preOrder(focusNode.leftChild);
			preOrder(focusNode.rightChild);
		}
	}
	
	public void postOrder(Node focusNode) {
		if(focusNode!=null) {
			postOrder(focusNode.leftChild);
			postOrder(focusNode.rightChild);
			System.out.print(focusNode.key+" ");
		}
	}
	
	public Node findNode(int key) {
		Node focusNode=root;
		
		while(focusNode.key!=key) {
			if(key<focusNode.key) {
				focusNode=focusNode.leftChild;
			}else {
				focusNode=focusNode.rightChild;
			}
			if(focusNode==null) {
				return null;
			}
		}
		return focusNode;
	}
	
	public T getMin() {
		if(root==null)
			throw new NoSuchElementException();
		Node focusNode=getMin(root);
		return focusNode.value;
	
	}
	
	private Node getMin(Node node) {
		assert(node!=null);
		while(node.leftChild!=null) {
			node=node.leftChild;
		}
		return node;
	}
	
	public T getMax() {
		if(root==null)
			throw new NoSuchElementException();
		Node focusNode=getMax(root);
		return focusNode.value;
	}
	
	private Node getMax(Node node) {
		assert(node!=null);
		while(node.rightChild!=null) {
			node=node.rightChild;
		}
		return node;
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if(node==null)
			return -1;
		return 1+Math.max(height(node.leftChild), height(node.rightChild));
	}

	public int countNodes() {
		return countNodes(root);
	}
	
	private int countNodes(Node node) {
		if(node==null) {
			return 0;
		}
		return 1+countNodes(node.leftChild)+countNodes(node.rightChild);
	}

	public int numberOfLeafs(){
		if(root == null){
			return -1;
		}
		else{
			return numberOfLeafs(root);
		}
	}

	private int numberOfLeafs(Node node){
		if (node == null)
			return 0;
		if ( node.leftChild== null && node.rightChild == null)
			return 1;
		else
			return numberOfLeafs(node.leftChild) + numberOfLeafs(node.rightChild);
	}
	
	public int internalNodes(){
		return countNodes()-numberOfLeafs();
	}
	
	public int externalNodes() {
		if(root==null) {
			return -1;
		}else {
			return externalNodes(root);
		}
	}
	
	private int externalNodes(Node node) {
		return countNodes(node)*2-(countNodes(node)-1);
	}
	
	public void wyswietlaniePoziomami() {
		for(int i=0;i<=height(root);i++) {
			wyswietlaniePoziomami(i,root);
			System.out.println();
		}
	}
	
	private void wyswietlaniePoziomami(int level,Node node) {
		if(node==null)
			return;
		if(level==0)
		System.out.print(node.value+" ");
		if(level>0) {
			wyswietlaniePoziomami(level-1,node.leftChild);
			wyswietlaniePoziomami(level-1,node.rightChild);
		
		}
	}
	
	public Node nastepnik(int key) {
		Node node=findNode(key);
		Node tmp=null;
		if(node!=null) {
			tmp=nastepnik(node);
		}
		if(tmp==null) {
			return null;
		}
		return tmp;
	}
	
	private Node nastepnik(Node node) {
		if(node.rightChild!=null) {
			return getMin(node.rightChild);
		}
		Node tmp=root;
		Node tmp1=null;
		while(tmp!=null) {
			if(node.key<tmp.key) {
				tmp1=tmp;
				tmp=tmp.leftChild;
			}else if(node.key>tmp.key) {
				tmp=tmp.rightChild;
			}else {
				break;
			}
		}
		return tmp1;
	}
	
	public Node poprzednik(int key) {
		Node node=findNode(key);
		Node tmp=null;
		if(node!=null) {
			tmp=poprzednik(node);
		}
		if(tmp==null) {
			return null;
		}
		return tmp;
	}
	
	private Node poprzednik(Node node) {
		if(node.leftChild!=null) {
			return getMax(node.leftChild);
		}
		Node tmp=root;
		Node tmp1=null;
		while(tmp!=null) {
			if(node.key>tmp.key) {
				tmp1=tmp;
				tmp=tmp.rightChild;
			}else if(node.key<tmp.key) {
				tmp=tmp.leftChild;
			}else {
				break;
			}
		}
		return tmp1;
	}
	
	public void delete(int key) {
		if(findNode(key)==null)
			return;
		Node node=findNode(key);
		System.out.println("Usuwanie wezla o kluczu: "+key);
		if(node.parent!=null && node.leftChild==null && node.rightChild==null) {
			if(node.parent.key<node.key) {
				node.parent.rightChild=null;
			}else {
				node.parent.leftChild=null;
			}
		}else if(node.parent!=null && node.leftChild==null && node.rightChild!=null) {
			if(node.parent.key<node.key) {
				node.parent.rightChild=node.rightChild;
			}else {
				node.parent.leftChild=node.rightChild;
			}
		}else if(node.parent!=null && node.rightChild==null && node.leftChild!=null) {
			if(node.parent.key<node.key) {
				node.parent.rightChild=node.leftChild;
			}else {
				node.parent.leftChild=node.leftChild;
			}
		}else if(node.parent!=null && node.rightChild!=null && node.leftChild!=null){
			if(node.key<node.parent.key) {
				Node tmp=nastepnik(node.key);
				node.parent.leftChild=tmp;
				if(tmp.leftChild==null)
					tmp.leftChild=node.leftChild;
			}
		}else {
			if(node.parent==null) {
				Node tmp=nastepnik(node.key);
				if(tmp.rightChild==null) {
					node.key=tmp.key;
					node.value=tmp.value;
					tmp.parent.leftChild=null;
				}else {
					node.key=tmp.key;
					node.value=tmp.value;
					tmp.parent.leftChild=tmp.rightChild;
				}
			}
		}
	}

	/*public void rysowanieDrzewa() {

		for(int i=0;i<=height(root);i++) {
			rysowanieDrzewa(i,root);
		}
	}
	
	private void rysowanieDrzewa(int level,Node node) {
		/*if(node==null)
			return;
		if(level==0)
			System.out.print(node.value+" ");
		if(level>0) {
			System.out.println();
			wyswietlaniePoziomami(level-1,node.leftChild);
			wyswietlaniePoziomami(level-1,node.rightChild);
		}
		if(node==null)
			return;
		if(level==0) {
			if(node.equals(root)) {
				System.out.println(String.format("%50s",node.value));
				System.out.println();
			}else if(node.parent.equals(root) && node.equals(node.parent.leftChild)) {
				System.out.print(String.format("%30s", node.value));
			}else if(node.parent.equals(root) && node.equals(node.parent.rightChild)) {
				System.out.print(String.format("%40s", node.value));
				System.out.println();
				System.out.println();
			}else if(node.parent.parent.equals(root)&&!node.equals(root.rightChild.rightChild)) {
				System.out.print(String.format("%20s", node.value));
				rysowanieDrzewa(level,node.leftChild);
			}else if(node.parent.parent.equals(root) && node.equals(root.rightChild.rightChild)) {
				System.out.print(String.format("%20s", node.value));
				System.out.println();
				System.out.println();
			}
		}
		if(level>0) {
			rysowanieDrzewa(level-1,node.leftChild);
			rysowanieDrzewa(level-1,node.rightChild);
		}
	}
	*/
	
	class Node{
		int key;
		T value;
		Node parent;
		Node leftChild;
		Node rightChild;
		
		Node(int key,T value){
			this.key=key;
			this.value=value;
		}
		
		public String toString() {
			return (String)value;
		}
	}
	
	public static void main(String[] args) {
		BST bst=new BST();
		
		bst.addNode(50, "50");
		bst.addNode(25, "25");
		bst.addNode(15, "15");
		bst.addNode(30, "30");
		bst.addNode(75, "75");
		bst.addNode(80, "80");
		bst.addNode(7, "7");
		bst.addNode(17, "17");
		bst.addNode(24, "24");
		bst.addNode(37, "37");
		bst.addNode(78, "78");
		bst.addNode(51, "51");
		bst.addNode(52, "52");
		System.out.println("InOrder");
		bst.inOrder(bst.root);
		System.out.println();
		System.out.println("PreOrder");
		bst.preOrder(bst.root);
		System.out.println();
		System.out.println("PostOrder");
		bst.postOrder(bst.root);
		System.out.println();
		System.out.print("Szukany wezel o kluczu 30: ");
		System.out.println(bst.findNode(30));
		System.out.println("Szukanie wezla ktorego nie ma: "+bst.findNode(554784));
		System.out.println("Min: "+bst.getMin());
		System.out.println("Max: "+bst.getMax());
		System.out.println("Wysokosc drzewa: "+bst.height());
		System.out.println("Ilosc wszystkich lisci: "+bst.numberOfLeafs());
		System.out.println("Ilosc wszystkich wezlow: "+bst.countNodes());
		System.out.println("Ilosc wezlow wewnetrznych: "+bst.internalNodes());
		System.out.println("Ilosc wezlow zewnetrznych: "+bst.externalNodes());
		System.out.println("Nastepnik: "+bst.nastepnik(30));
		System.out.println("Poprzednik: "+bst.poprzednik(24));
		System.out.println("Wyswietlanie drzewa poziomami: ");
		bst.wyswietlaniePoziomami();
		System.out.println();
		bst.delete(50);
		bst.wyswietlaniePoziomami();
		System.out.println();
		//System.out.println("Przed usunieciem preOrder");
		//bst.preOrder(bst.root);
		//System.out.println();
		///bst.delete(50);
		//bst.preOrder(bst.root);
		System.out.println();
		
		/*
		Scanner sc=new Scanner(System.in);
		String tmp="";
		while(!tmp.equals("end")) {
			if(tmp.equals("put")) {
				System.out.println("Podaj klucz");
				tmp=sc.nextLine();
				bst.addNode(Integer.parseInt(tmp), tmp);
			}else if(tmp.equals("inorder")) {
				bst.inOrder(bst.root);
				System.out.println();
			}else if(tmp.equals("preorder")) {
				bst.preOrder(bst.root);
				System.out.println();
			}else if(tmp.equals("postorder")) {
				bst.postOrder(bst.root);
				System.out.println();
			}else if(tmp.equals("find")) {
				System.out.println("Podaj klucz");
				int key=sc.nextInt();
				System.out.println(bst.findNode(key));
			}else if(tmp.equals("min")) {
				System.out.println(bst.getMin());
			}else if(tmp.equals("max")) {
				System.out.println(bst.getMax());
			}else if(tmp.equals("h")) {
				System.out.println(bst.height());
			}else if(tmp.equals("leaves")) {
				System.out.println(bst.numberOfLeafs());
			}else if(tmp.equals("innode")) {
				System.out.println(bst.internalNodes());
			}else if(tmp.equals("outnode")) {
				System.out.println(bst.externalNodes());
			}else if(tmp.equals("levels")) {
				bst.wyswietlaniePoziomami();
				System.out.println();
			}else if(tmp.equals("nastepnik")) {
				System.out.println("Podaj klucz");
				int a=Integer.parseInt(sc.nextLine());
				System.out.println(bst.nastepnik(a));
			}else if(tmp.equals("poprzednik")) {
				System.out.println("Podaj klucz");
				int a=Integer.parseInt(sc.nextLine());
				System.out.println(bst.poprzednik(a));
			}else if(tmp.equals("delete")) {
				System.out.println("Podaj klucz");
				int a=Integer.parseInt(sc.nextLine());
				bst.delete(a);
			}
			System.out.println("Wybierz dzia³anie: put,inorder,preorder,postorder,find,min,max,h,leaves,innode,outnode,levels,nastepnik,poprzednik,delete,end");
			tmp=sc.nextLine();	
		}*/
	}
}
