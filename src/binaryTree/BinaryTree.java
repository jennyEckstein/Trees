package binaryTree;

public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String name){
		Node newNode = new Node(key, name);
		
		if(root == null){
			root = newNode;
		}else{
			Node focusNode = root;
			Node parent;
			while(true){
				parent = focusNode;
				if(key < focusNode.key){
					focusNode = focusNode.leftChild;
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
				}else{
					focusNode = focusNode.rightChild;
					if(focusNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * In order traversal
	 * @param args
	 * ---------------------
	 * Aim for the smallest value first
	 * Start at 1st left child
	 * when null reached then move up in value
	 */
	public void inOrderTraverse(Node focusNode){
		if (focusNode != null){
			inOrderTraverse(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverse(focusNode.rightChild);
		}
	}
	/**
	 * preOrder
	 * @param focusNode
	 * -----
	 * start from out root node
	 * go down to most left
	 * go down to most right
	 */
	public void preOrderTraverse(Node focusNode){
		if (focusNode != null){
			System.out.println(focusNode);
			preOrderTraverse(focusNode.leftChild);			
			preOrderTraverse(focusNode.rightChild);
		}
	}
	
	/**
	 * post order
	 * @param args
	 * ---
	 * get the smallest first
	 */
	public void postOrderTraverse(Node focusNode){
		if (focusNode != null){			
			postOrderTraverse(focusNode.leftChild);			
			postOrderTraverse(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
	public Node findNode(int key){
		Node focusNode = root;
		while(focusNode.key != key){
			if(key < focusNode.key){
				focusNode = focusNode.leftChild;
			}else{
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null){
				return null;
			}
		}
		return focusNode;
	}
	
	public boolean remove(int key){
		Node focusNode = root;
		Node parent = root;
		
		boolean isLeft = true;
		
		while(focusNode.key != key){
			parent = focusNode;
			if(key < focusNode.key){
				isLeft = true;
				focusNode = focusNode.leftChild;
			}else{
				isLeft = false;
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null){
				return false;
			}
		}
		
		if(focusNode.leftChild == null && focusNode.rightChild == null){
			if(focusNode == root){
				root = null;
			}else if(isLeft){
				parent.leftChild = null;
			}else{
				parent.rightChild = null;
			}
		}
		else if(focusNode.rightChild == null){
			if(focusNode == root){
				root = focusNode.leftChild;
			}else if(isLeft){
				parent.leftChild = focusNode.leftChild;
			}else{
				parent.rightChild = focusNode.rightChild;
			}
		}else if(focusNode.leftChild == null){
			if(focusNode == root){
				root = focusNode.rightChild;
			}else if(isLeft){
				parent.leftChild = focusNode.rightChild;
			}else{
				parent.rightChild = focusNode.leftChild;
			}
		}else{
			Node replacement = getReplacementNode(focusNode);
			
			if(focusNode == root){
				root = replacement;
			}else if(isLeft){
				parent.leftChild = replacement;
			}else{
				parent.rightChild = replacement;
			}
			replacement.leftChild = focusNode.leftChild;
		}
		return true;
	}
	
	public Node getReplacementNode(Node replacedNode){
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		Node focusNode = replacedNode.rightChild;
		
		while(focusNode != null){
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}
		
		if(replacement != replacedNode.rightChild){
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}
}

class Node{
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name){
		this.key = key;
		this.name = name;
	}
	
	public String toString(){
		return name + " : " + key;
	}
}
