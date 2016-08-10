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

	public static void main(String [] args){
		BinaryTree tree = new BinaryTree();
		tree.addNode(50, "Boss");
		tree.addNode(25, "Vice president");
		tree.addNode(15, "Office Manager");
		tree.addNode(30, "Secretary");
		tree.addNode(75, "Sales Manager");
		tree.addNode(85, "Salesman 1");
		
		tree.inOrderTraverse(tree.root);
		System.out.println();
		tree.preOrderTraverse(tree.root);
		System.out.println();
		tree.postOrderTraverse(tree.root);
		
		System.out.println("Seach for 15");
		System.out.println(tree.findNode(15));
		
		System.out.println("Search for 100");
		System.out.println(tree.findNode(100));
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
