/** 
  * Application to read in product data from individual text files for each
  * product, store these in memory for access to decrement as sales are made
  * and to order more of a product when a threshold is reached for sales
  * velocity and number of item in stock.
  *
  * Data structures used are the ItemRecord, a single node containing fields
  * for product data and stock levels, and the StockList, which is a container
  * class holding all of the ItemRecords, allowing search, insertion, and 
  * deletion
  *
  * Written for the Fall 2014 Data Structure and Algorithms Course at
  * Empire State College, a collaboration between Adam Acosta, Joe Harmon, 
  * Junko Kotake, Stephanie Fuschetti, Kevin Leonas, and Michael Scarpace.
  */
 
package inventory;
import java.io.*;
import java.util.*;

class ItemTree {

	private Node root;
	private int size;

   	public ItemTree() { 
		root = null;
		size = 0;
        }            
	
	public int size() {
		return size;
	}

	public ItemRecord find(int key) { 
       		if (root == null) {
          		return null;
        	}
      		Node current = root;
      		while(current.iData != key) {      		// while no match,
        		if (key < current.iData) {        	// go left?
            			current = current.leftChild;
         		} else {                          	// or go right?
            			current = current.rightChild;
			}
         		if (current == null) {            	// if no child,  
         			return null;              	// didn't find it
         		}
		}
      		return current.i;                    		// found it
      	}  
      
  	public void insert(ItemRecord a) {
     		Node newNode = new Node(a);    		// make new node
     						 	// newNode.i = a;           
     		int id = newNode.iData;   
     		if (root == null) {	                // no node in root
         		root = newNode;
			size++;
			return;
      		} else {                          	// root occupied
         		Node current = root;       	// start at root
         		Node parent;
        		while(true) {                	// (exits internally)
            			parent = current;
            			if (id < current.iData) {
               				current = current.leftChild;
					if (current == null) {  
                  				parent.leftChild = newNode;
						size++;
                  				return;
                  			}
               			} else if (id >= current.iData) {  
                  			current = current.rightChild;
					if (current == null) { 
                  				parent.rightChild = newNode;
						size++;
                  				return;
                  			}
                  		} 
            		}  
		}
        }   

  	public boolean delete(int key) { // delete node with given key
                      			 // (assumes non-empty list)
      		Node current = root;
     		Node parent = root;
      		boolean isLeftChild = true;

      		while (current.iData != key) {        	// search for node
       			parent = current;
         		if(key < current.iData) {       // go left?
            			isLeftChild = true;
           			current = current.leftChild;
            		} else {			// or go right?
           			isLeftChild = false;
            			current = current.rightChild;
            		}
         		if(current == null) {           // end of the line,
            			return false;           // didn't find it
         		}  		
		} // end while
      				// found node to delete

      		// if no children, simply delete it
      		if (current.leftChild == null && current.rightChild == null) {
         		if (current == root) {	             // if root,
            			root = null;                 // tree is empty
    			} else if (isLeftChild) {
            			parent.leftChild = null;     // disconnect
         		} else {           		     // from parent
            			parent.rightChild = null;
         		}
      		// if no right child, replace with left subtree
      		} else if (current.rightChild == null) {
         		if(current == root) {
            			root = current.leftChild;
		        } else if (isLeftChild) {
            			parent.leftChild = current.leftChild;
         		} else {
            			parent.rightChild = current.leftChild;
			}
      		// if no left child, replace with right subtree
      		} else if (current.leftChild==null) {
         		if (current == root) {
            			root = current.rightChild;
         		} else if (isLeftChild) {
            			parent.leftChild = current.rightChild;
         		} else {
            			parent.rightChild = current.rightChild;
			}
      		} else {  	// two children, so replace with inorder successor
         			// get successor of node to delete (current)
       			Node successor = getSuccessor(current);
         		// connect parent of current to successor instead
       			if (current == root) {
            			root = successor;
         		} else if (isLeftChild) {
            			parent.leftChild = successor;
         		} else {
            			parent.rightChild = successor;
         			// connect successor to current's left child
         			successor.leftChild = current.leftChild;
         		}  	// end else two children
      				// (successor cannot have a left child)
		}
		return true;
	}  // end delete()

   	private Node getSuccessor (Node delNode) {
  		Node successorParent = delNode;
      		Node successor = delNode;
      		Node current = delNode.rightChild;   // go to right child
      		while(current != null) {             // until no more
         		                             // left children,
         		successorParent = successor;
         		successor = current;
         		current = current.leftChild;    // go to left child
         	}
      		                                     	// if successor not
      		if(successor != delNode.rightChild) {	// right child,
      	 	                              		// make connections
         		successorParent.leftChild = successor.rightChild;
         		successor.rightChild = delNode.rightChild;
         	}
      		return successor;
      }

} 
