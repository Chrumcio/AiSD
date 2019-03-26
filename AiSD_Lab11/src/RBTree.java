import java.util.NoSuchElementException;

public class RBTree {
	  final static boolean RED = true;
	  final static boolean BLACK = false;
	  Node root; 
	  Node sentinel;
	
	  public RBTree() {
		  this.root=null;
		  sentinel=new Node(0);
		  sentinel.color=BLACK;
	  }
	  
	  public void addNode(int key) {
		  Node newNode=new Node(key);
		  addNode(newNode);
		  buildTree(newNode);
	  }
	  
	  private void addNode(Node newNode) {
		  newNode.color=RED;
		  if(root==null) {
				root=newNode;
			}else {
				Node focusNode=root;
				Node parent;
				while(true) {
					parent=focusNode;
					if(newNode.key<focusNode.key) {
						focusNode=focusNode.left;
						if(focusNode==sentinel) {
							parent.left=newNode;
							newNode.parent=parent;
							return;
						}
					}else {
						focusNode=focusNode.right;
						if(focusNode==sentinel) {
							parent.right=newNode;
							newNode.parent=parent;
							return;
						}
					}
				}
			}
		}
	  
	  public void buildTree(Node node) {
		  
		  while(node.parent.color!=BLACK) {
			  if(node.parent.parent.left.equals(node.parent)) {
				  if(node.parent.parent.right.color==RED) { //prawy wujek jest czerwony
					  node.parent.color=BLACK;
					  node.parent.parent.right.color=BLACK;
					  node.parent.parent.color=RED;
					  node=node.parent.parent;
				  }else {
					  if(node.parent.parent.right.color==BLACK && node.parent.right.equals(node)) { //prawy wujek jest czarny, a wstawiany wezel jest prawym dzieckiem
					  rotateLeft(node.parent);
					  node=node.left;
					  }
					  rotateRight(node.parent.parent);
					  node=node.parent;
					  node.color=BLACK;
					  node.right.color=RED;
					  node.left.color=RED;
				  }
			  }else { 
				  if(node.parent.parent.left.color==RED) {
					  node.parent.color=BLACK;
					  node.parent.parent.left.color=BLACK;
					  node.parent.parent.color=RED;
					  node=node.parent.parent;
				  }else {
					  if(node.parent.parent.left.color==BLACK && node.parent.left.equals(node)) {
					  rotateRight(node.parent);  
					  node=node.right;
					  }
					  rotateLeft(node.parent.parent);
					  node=node.parent.left;
					  node.color=RED;
					  node.parent.color=BLACK;
					  node.parent.right.color=RED;
				  }
			  }
		  }
		  root.color=BLACK;
	  }

	  public void rotateLeft(Node node){
	        Node node_right=node.right;
	        node.right=node_right.left;
	        if (node.right!=sentinel) {
	            node.right.parent=node;
	        }
	        node_right.parent=node.parent;
	        if (node.parent==sentinel) {
	            root = node_right;
	        }else if (node==node.parent.left) {
	            node.parent.left =node_right;
	        }else {
	            node.parent.right=node_right;
	        }
	        node_right.left=node;
	        node.parent=node_right;
	  }
	  
	  public void rotateRight(Node node){
	        Node node_left=node.left;
	        node.left=node_left.right;
	        if (node.left!=sentinel) {
	            node.left.parent=node;
	        }
	        node_left.parent=node.parent;
	        if (node.parent==sentinel) {
	            root=node_left;
	        }else if (node==node.parent.left) {
	            node.parent.left=node_left;
	        }else {
	            node.parent.right=node_left;
	        }
	        node_left.right=node;
	        node.parent=node_left;
	  }

	  public int numberOfNodes(){
	        return numberOfNodes(root);
	  }

	  public int numberOfNodes(Node r){
	        if (r == sentinel)
	            return 0;
	        else {
	            int lnodes = numberOfNodes(r.left);
	            int rnodes= numberOfNodes(r.right);

	            return(lnodes+rnodes+1);
	        }
	  }
	    
	  public void nodes(Node r) {
	    	if (r==sentinel)
	    		return;

	    	r.nodes = numberOfNodes(r);
	    	r.lnodes = numberOfNodes(r.left);
	    	r.rnodes = numberOfNodes(r.right);

	    	nodes(r.left);
	    	nodes(r.right);
	    }
	  
	  public void preOrder(Node focusNode) {
			if(focusNode!=sentinel) {
				if(focusNode.color==true) {
					System.out.print(focusNode.key+"(R) ");
				}else {
					System.out.print(focusNode.key+"(B) ");
				}
				preOrder(focusNode.left);
				preOrder(focusNode.right);
			}
	  }    
	  
	    public int height() {
			return height(root);
		}
		
		private int height(Node node) {
			if(node==sentinel)
				return 0;
			return 1+Math.max(height(node.left), height(node.right));
		}
	  
		public void wyswietlaniePoziomami() {
			for(int i=0;i<=height(root);i++) {
				wyswietlaniePoziomami(i,root);
				System.out.println();
			}
		}
		
		private void wyswietlaniePoziomami(int level,Node node) {
			if(node==sentinel)
				return;
			if(level==0) {
				if(node.color==RED) {
					System.out.print(node.key+"(R) ");
				}else {
					System.out.print(node.key+"(B) ");
				}
			}
			if(level>0) {
				wyswietlaniePoziomami(level-1,node.left);
				wyswietlaniePoziomami(level-1,node.right);
			}
		}
		
		public void inscribe(Node node) {
			if(node!=sentinel) {
				node.height=height(node)-1;
				node.nodes=numberOfNodes(node)-1;
				node.lheight=height(node.left);
				node.rheight=height(node.right);
				node.lnodes=numberOfNodes(node.left);
				node.rnodes=numberOfNodes(node.right);
				inscribe(node.left);
				inscribe(node.right);
			}
		}
		
		 public void preOrder1(Node focusNode) {
				if(focusNode!=sentinel) {
					if(focusNode.color==true) {
						System.out.print(focusNode.key+"(R)H="+focusNode.height+" LH="+focusNode.lheight+" RH="+focusNode.rheight+" N="+focusNode.nodes+" LN="+focusNode.lnodes+" RN="+focusNode.rnodes);
						System.out.println();
					}else {
						System.out.print(focusNode.key+"(B)H="+focusNode.height+" RH="+focusNode.rheight+" LH="+focusNode.lheight+" N="+focusNode.nodes+" LN="+focusNode.lnodes+" RN="+focusNode.rnodes);
						System.out.println();
					}
					preOrder1(focusNode.left);
					preOrder1(focusNode.right);
				}
		  }    
		 
		 //pomocnicza metoda szukania wezla do usuniecia
		 
		 public Node findNode(int key) {
				Node focusNode=root;
				
				while(focusNode.key!=key) {
					if(key<focusNode.key) {
						focusNode=focusNode.left;
					}else {
						focusNode=focusNode.right;
					}
					if(focusNode==null) {
						return null;
					}
				}
				return focusNode;
			}
		 
		 public Node getMin() {
				if(root==sentinel)
					throw new NoSuchElementException();
				Node focusNode=getMin(root);
				return focusNode;
			
			}
			
			private Node getMin(Node node) {
				assert(node!=sentinel);
				while(node.left!=sentinel) {
					node=node.left;
				}
				return node;
			}
		 
		 public Node nastepnik(int key) {
				Node node=findNode(key);
				Node tmp=null;
				if(node!=sentinel) {
					tmp=nastepnik(node);
				}
				if(tmp==sentinel) {
					return null;
				}
				return tmp;
			}
			
			private Node nastepnik(Node node) {
				if(node.right!=sentinel) {
					return getMin(node.right);
				}
				Node tmp=root;
				Node tmp1=null;
				while(tmp!=sentinel) {
					if(node.key<tmp.key) {
						tmp1=tmp;
						tmp=tmp.left;
					}else if(node.key>tmp.key) {
						tmp=tmp.right;
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
			 
			 boolean color;
			 if(node.left==sentinel) {
				 color=node.color;
				 if(node.key<node.parent.key) {
					 node.parent.left=node.right;
					 node.right.parent=node.parent;
				 }else {
					 node.parent.right=node.right;
					 node.right.parent=node.parent;
				 }
				 node=node.right;
				 if(node.color==RED && node.parent.color==RED) {
					 node.color=BLACK;
				 }
			 }else if(node.right==sentinel) {
				 color=node.color;
				 if(node.key<node.parent.key) {
					 node.parent.left=node.left;
					 node.left.parent=node.parent;
				 }else {
					 node.parent.right=node.left;
					 node.left.parent=node.parent;
				 }
				 node=node.left;
				 if(color==BLACK) {
					 node.color=BLACK;
				 }
			 }else if(node.left!=sentinel && node.right!=sentinel && node.right.equals(nastepnik(node))) {
				 color=node.color;
				 Node tmp=node.left;
				 boolean color2=nastepnik(node).color;
				 if(node.key<node.parent.key) {
					 node.parent.left=node.right;
					 node.right.parent=node.parent;
					 node=node.right;
					 node.color=color;
				 }else {
					 node.parent.right=node.right;
					 node.right.parent=node.parent;
					 node=node.right;
					 node.color=color;
				 }
				 if(color2==BLACK) {
					 node.right.color2=BLACK;
				 }
			 }else if(node.left!=sentinel && node.right!=sentinel && !node.right.equals(nastepnik(node))) {
				 Node nastepnik=nastepnik(node);
				 if(nastepnik.key<nastepnik.parent.key) {
					 nastepnik.parent.left=nastepnik.right;
					 nastepnik.right.color=nastepnik.color;
					 nastepnik.right.parent=nastepnik.parent;
					 boolean tmp=nastepnik.color;
					 color=node.color;
					 node=nastepnik;
					 node.color=color;
					 if(tmp==BLACK) {
						 nastepnik.right.color2=BLACK;
						// if(node.key<node.parent.key) {
							 if(node.parent.right.color==RED) {
								rotateLeft(node.parent);
								node.parent.color=RED;
								node.parent.parent.color=BLACK;
								node.parent.right.color=BLACK;
							 }
						// }else if(node.key>node.parent.key) {
							 if(node.parent.left.color==RED) {
								 rotateRight(node.parent);
								 node.parent.color=RED;
								 node.parent.parent.color=BLACK;
								 node.parent.left.color=BLACK;
							 }
							 //}
							 if(node.parent.right.color=BLACK && node.parent.right.left.color==BLACK && node.parent.right.right.color==BLACK) {
							 node.parent.color=node.color2;
							 node.parent.left.color=RED;
							 
						 }
							 if(node.parent.right.color==BLACK && node.parent.right.left.color==RED && node.parent.right.right.color==BLACK) {
							 rotateRight(node.parent.right);
							 tmp=node.parent.right.color;
							 node.parent.right.color=node.parent.right.right.color;
							 node.parent.right.right.color=tmp;
							 
						 }
							 if(node.parent.right.color==BLACK && node.parent.right.right.color==RED) {
							 rotateLeft(node.parent);
							 node.parent.parent.color=node.parent.color;
							 node.parent.color=node.color2;
							 node.parent.parent.right.color=BLACK;
						 }
					 }
				 }
			 }
		 }
		 class Node{
			 int key;
			 Node left;
			 Node right;
			 Node parent;
			 boolean color;
			 boolean color2;
			 int nodes;
			 int lnodes;
			 int rnodes;
			 int height;
			 int lheight;
			 int rheight;
		
			 Node(int key){
				 this.key=key;
				 color=RED;
				 left=sentinel;
				 right=sentinel;
				 parent=sentinel;
			 }
		 }
		 public static void main(String[] args) {
			 RBTree t=new RBTree();
		
			 for(int i=40;i>30;i--)
				 t.addNode(i);
			 t.addNode(41);
			 t.preOrder(t.root);
			 System.out.println();
			 System.out.println();
			 //t.wyswietlaniePoziomami();
			 System.out.println("Wysokosc drzewa: "+(t.height()-1));
			 System.out.println("Wysokosc lewego poddrzewa: "+(t.height(t.root.left)-1));
			 System.out.println("Wysokosc prawego poddrzewa: "+(t.height(t.root.right.left)-1));
			 System.out.println("Ilosc wszystkich wezlow: "+t.numberOfNodes());
			 System.out.println("Ilosc wezlow lewego poddrzewa: "+t.numberOfNodes(t.root.right.left));
			 System.out.println("Ilosc wezlow prawego poddrzewa: "+t.numberOfNodes(t.root.right.right));
			 t.wyswietlaniePoziomami();
			 t.inscribe(t.root);
			 t.preOrder1(t.root);
			 System.out.println((t.height(t.root.right)-1));
		
			 //t.delete(3);
			 //t.wyswietlaniePoziomami();
		 }
}
