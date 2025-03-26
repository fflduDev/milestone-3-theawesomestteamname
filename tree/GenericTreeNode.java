package tree;
import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	//<some list of children>
	ArrayList<GenericTreeNode<E>> children;
	
	public GenericTreeNode(E theItem) {
		data = theItem;
	}
	
	public void addChild(GenericTreeNode<E> theItem) {
		children.add(theItem);
	}
	
	public void removeChild(E theItem) {
		if (children.get(children.indexOf(theItem)).children.size() == 0) {
			children.get(children.indexOf(theItem)).children.forEach(e -> addChild(e));
		}
		children.remove(theItem);
		// this one is a little harder.
		// what do you do when the item has children?
		// I suggest "give them to the parent"
	}
	
	
} 
