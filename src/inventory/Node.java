/**
 * Node for a binary tree, used by ItemTree
 */

package inventory;

public class Node {

	ItemRecord i;    
 	public int iData; 		// data item that pulls SKU from itemrecord 
   	public Node leftChild;  	// this node's left child
   	public Node rightChild;         // this node's right child
   
   	public Node(ItemRecord a) {
        	i = a;
        	iData = a.getSKU();
		leftChild = null;
		rightChild = null;
        }
   
}
