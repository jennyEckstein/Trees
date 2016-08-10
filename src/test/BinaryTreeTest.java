package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import binaryTree.BinaryTree;

public class BinaryTreeTest {
	
	private BinaryTree tree;

	@Before
	public void setUp() throws Exception {
		this.tree = new BinaryTree();
		tree.addNode(50, "Boss");
		tree.addNode(25, "Vice president");
		tree.addNode(15, "Office Manager");
		tree.addNode(30, "Secretary");
		tree.addNode(75, "Sales Manager");
		tree.addNode(85, "Salesman 1");
	}

	@After
	public void tearDown() throws Exception {
		this.tree = null;
	}

	@Test
	public void testDeleteRoot() {		
		Assert.assertTrue(this.tree.remove(50));
	}
	
	@Test
	public void testDeleteChildWithChildren(){
		Assert.assertTrue(this.tree.remove(25));
	}
	
	@Test
	public void testDeleteChildWithNoChildren(){
		Assert.assertTrue(this.tree.remove(15));
	}
	
	@Test
	public void testDeleteNotExistantElement(){
		Assert.assertTrue(!this.tree.remove(100));
	}

}
