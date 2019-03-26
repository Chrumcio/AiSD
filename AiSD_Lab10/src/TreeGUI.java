import java.awt.*;
import java.io.*;

public class TreeGUI extends Frame { 
Abs_tree tree;
boolean is_new_tree=true;
Choice tree_kind, element_kind;
TextField input_elem, min_text, max_text;
String nodeValue;
Panel inputPanel;
OutputPanel outputPanel;
Button clear;
Button exit;
int last_x, last_y;

public static void main(String [] x) {
	TreeGUI g = new TreeGUI();
	}

public TreeGUI() {
	Label tree_kind_label, elem_kind_label, input_elem_label;
	Panel input1, input2;
	setLayout(new BorderLayout());
	
	inputPanel = new Panel();
	inputPanel.setLayout(new BorderLayout());

	input1 = new Panel();
	tree_kind_label = new Label("Tree Kind:");
	input1.add(tree_kind_label);
	tree_kind = new Choice();
	tree_kind.addItem("Normal Tree");
	input1.add(tree_kind);
	elem_kind_label = new Label("   Element Kind:");
	input1.add(elem_kind_label);
	element_kind = new Choice();
	element_kind.addItem("Integer");
	input1.add(element_kind);
	input_elem = new TextField(10);
	input1.add(input_elem);
	
	input2 = new Panel();
	clear = new Button("Clear");
	input2.add(clear);
	exit = new Button("Exit");
	input2.add(exit);

	inputPanel.add("North", input1);
	inputPanel.add("South", input2);

	add("North", inputPanel);

	outputPanel = new OutputPanel();
	add("Center", outputPanel);
	pack();
	setVisible(true);
	
	}

public boolean action(Event e, Object what) { 
  if (e.target.equals(exit))
    { System.exit(0); }

  if (e.target.equals(clear))
	{ is_new_tree = true;
	  input_elem.setText("");
	  outputPanel.clearPanel();
	}

  if (e.target.equals(input_elem))
	{ String s = (String)what;
	  int index = element_kind.getSelectedIndex();

	 
	   try {
		if (is_new_tree)
		   {if (index == 0)
		     {if (tree_kind.getSelectedIndex() == 0)
		         tree=new Tree(new IntElem(Integer.parseInt(s)));
		      else tree=new Duptree(new IntElem(Integer.parseInt(s))); 
		     }
		    else {if (tree_kind.getSelectedIndex() == 0)
			      tree=new Tree(new StringElem(s));
			  else tree=new Duptree(new StringElem(s));
			 }
		    is_new_tree = false;
		   } 
		else {if (index==0) 
			 tree.insert(new IntElem(Integer.parseInt(s)));
		      else tree.insert(new StringElem(s));
		     }
		} 

	   catch(Exception exception) 
		{ 
		  input_elem.selectAll();
		  return true;
		}

	   outputPanel.drawTree(tree);
	   input_elem.selectAll();
	   return true;
	}

   return true;
   }
} 


class OutputPanel extends Panel {
Image treeImage;  
int imageWidth, imageHeight;

public void paint(Graphics g) {
 if (treeImage == null)
 { Dimension d = this.size(); 
   treeImage = createImage(d.width, d.height);
   imageWidth = d.width; imageHeight = d.width;
   Graphics gr = treeImage.getGraphics();
   gr.setColor(getBackground());
   gr.fillRect(0, 0, imageWidth, imageHeight);
   gr.setColor(Color.black);
 }
 g.drawImage(treeImage, 0, 0, this);
 }

public void clearPanel() {
 Graphics g;

 g = treeImage.getGraphics();
 g.setColor(getBackground());
 g.fillRect(0, 0, imageWidth, imageHeight);
 g.setColor(Color.black);
 getGraphics().drawImage(treeImage, 0, 0, this);
 }


public void drawTree(Abs_tree tree) {
 Graphics g;
 Dimension d = this.size();
 if (imageWidth != d.width || imageHeight != d.height)
    { treeImage = createImage(d.width, d.height);
      imageWidth = d.width; imageHeight = d.height;
    };

 g = treeImage.getGraphics();
 g.setColor(getBackground());
 g.fillRect(0, 0, d.width, d.height);
 g.setColor(Color.black);

 drawNode(g, imageWidth/2, tree, imageWidth/2, 0);
 getGraphics().drawImage(treeImage, 0, 0, this);
 }

private void drawNode(Graphics g, int subtreeW, Abs_tree tree, int x, int y) {
 Abs_tree left, right;
 g.drawString(tree.get_value(), x-10, y+10);
 left = tree.get_left();
 right = tree.get_right();
 if (left != null)
    { g.drawLine(x, y+10, x-subtreeW/2, y+50);
      drawNode(g, subtreeW/2, left, x-subtreeW/2, y+50);
    };
 if (right != null)
    { g.drawLine(x, y+10, x+subtreeW/2, y+50);
      drawNode(g, subtreeW/2, right, x+subtreeW/2, y+50);
    }
 }
}


abstract class Abs_tree {
 public Abs_tree(Element n) { node = n; left = null; right = null;} 
 public void insert(Element n) {
      if (node.equal(n)) count_duplicates();
      else if (node.less_than(n)) 
	 	if (right == null) right = add_node(n);
         	else right.insert(n);
      else if (left == null) left = add_node(n);
              else left.insert(n);
 	} 
	
 public Element min() { 
 	if (left != null) return left.min();
 	else return node;
 	}

 public Element max() { 
 	if (right != null) return right.max();
 	else return node;
 	}

 public void print()   {
 	if (left != null) left.print();
 	this.print_node();
 	if (right != null) right.print();
 	}

 public Abs_tree get_left() {
	 return left;
 }

 public Abs_tree get_right() {
	 return right;
 }

 protected Element node;
 protected Abs_tree left;
 protected Abs_tree right;

 protected abstract void count_duplicates();
 protected abstract Abs_tree add_node(Element n);
 protected abstract void print_node();

 public abstract String get_value();
}


class Tree extends Abs_tree {
 public Tree(Element n) {super(n);}
 protected Abs_tree add_node(Element n) {return new Tree(n);}
 protected void count_duplicates() {}
 protected void print_node() { System.out.print(node.get_value() + "  "); }

 public String get_value() { return(node.get_value()); }
}


class Duptree extends Abs_tree {
 public Duptree(Element n) {super(n); count = 1;}
 protected Abs_tree add_node(Element n) {return new Duptree(n);}
 protected void count_duplicates() {count++;}
 protected void print_node() {
	 System.out.print(node.get_value() + "/" + count + "  ");
 }

 public String get_value() { return(node.get_value() + '/' + count); }

 protected int count;
}


interface Element
{
 public boolean equal(Element n);
 public boolean less_than(Element n);
 public String get_value();
}

class IntElem implements Element
{
 private int value;
 public IntElem(int i) { value=i; }
 public boolean equal(Element n) {
	 return(this.value == ((IntElem)n).getValue());
 }
 public boolean less_than(Element n) {
	 return(this.value < ((IntElem)n).getValue());
 }
 public String get_value() { return(String.valueOf(value)); }
 public int getValue() { return value; }
}

class StringElem implements Element
{
 private String value;
 public StringElem(String s) { value=s; }
 public boolean equal(Element n) {
	 return(this.value.equals(((StringElem)n).get_value()));
 }
 public boolean less_than(Element n) {
	 return(value.compareTo(((StringElem)n).get_value()) < 0);
 }
 public String get_value() { return(value); }
}