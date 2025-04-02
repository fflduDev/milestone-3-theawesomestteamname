package tree;
import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	//<some list of children>
	ArrayList<GenericTreeNode<E>> children;
	
	public GenericTreeNode(E theItem) {
		data = theItem;
		children = new ArrayList<>();
	}
	
	public void addChild(GenericTreeNode<E> theItem) {
		children.add(theItem);
	}
	
	public void removeChild(E theItem) {

		int index = children.indexOf(theItem);

		if (index != -1) {

			children.addAll(children.get(index).children);

			children.remove(index);

		}

		//if target item has chilren, transfer then into parent node
		
		// this one is a little harder.
		// what do you do when the item has children?
		// I suggest "give them to the parent"
	}
	
	
} 
