package interkassa;

import static org.junit.Assert.assertEquals;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class TreeTest {
	
	private List<Leaf> getLeafList() {
	   	final List<Leaf> exampleList = new LinkedList<>();
    	exampleList.add(new Leaf("e1", 2));
    	exampleList.add(new Leaf("e2", 5));
    	exampleList.add(new Leaf("e3", 3));
    	exampleList.add(new Leaf("e4", 1));
    	exampleList.add(new Leaf("e4", 4));
    	
    	return exampleList;
	}
	
	private List<Leaf> getSortedList() {
    	final List<Leaf> expectedList = new LinkedList<>();
    	expectedList.add(new Leaf("e4", 1));
    	expectedList.add(new Leaf("e1", 2));
    	expectedList.add(new Leaf("e3", 3));
    	expectedList.add(new Leaf("e4", 4));
    	expectedList.add(new Leaf("e2", 5));
    	return expectedList;
	}
	
	private List<Node> getExampleNodesList() {
		final List<Node> rootsSubNodes = new LinkedList<>();
		rootsSubNodes.add(new Node("a1"));
		rootsSubNodes.add(new Node("a2"));
		rootsSubNodes.add(new Node("a3"));
		return rootsSubNodes;
	}
	
	
    @Test
    public void testLeafListSorting() {
        assertEquals("Lists should be equal", ListHelperUtil.mergeSort(getLeafList()), getSortedList());
    }
    
    @Test
    public void testSpliting() {
    	
    	final List<Leaf> rightPart = new LinkedList<>();
    	rightPart.add(new Leaf("e4", 1));
    	rightPart.add(new Leaf("e1", 2));
    	
    	final List<Leaf> leftPart = new LinkedList<>();
    	leftPart.add(new Leaf("e3", 3));
    	leftPart.add(new Leaf("e4", 4));
    	leftPart.add(new Leaf("e2", 5));
    	
    	final Entry<List<Leaf>, List<Leaf>> expectedResult = new SimpleImmutableEntry<>(leftPart, rightPart);
    	
        assertEquals("Tuple result after splitting should be equal to expected", ListHelperUtil.getSubListAfterSplit(getSortedList(), 3), expectedResult);
    }
    
    @Test
    public void testOfTaskExample() {
		//started structure
    	
    	final List<Node> rootsSubNodes = getExampleNodesList();
		
		final List<Leaf> rootsLeafs = new LinkedList<>();
		final Leaf b1 = new Leaf("b1", 1);
		final Leaf b2 = new Leaf("b2", 2);
		final Leaf b3 = new Leaf("b3", 3);
		final Leaf b4 = new Leaf("b4", 4);
		
		
		rootsLeafs.add(b2);
		rootsLeafs.add(b4);
		rootsLeafs.add(b3);
		rootsLeafs.add(b1);
		
		final Node root = new Node("root", rootsSubNodes, rootsLeafs);
		
		//expected structure
		final List<Node> expecteRootSubNodes = getExampleNodesList();
		
		final Node a1 = expecteRootSubNodes.get(0); // getting a1
		final List<Leaf> a1Leafs = new LinkedList<>();
		a1Leafs.add(b3);
		a1.setLeafList(a1Leafs);
		
		final List<Leaf> expecteRootsLeafs = new LinkedList<>();
		expecteRootsLeafs.add(b1);
		expecteRootsLeafs.add(b2);
		
		
		final Node expectedRootNode = new Node("root", expecteRootSubNodes, expecteRootsLeafs);
		
		
		new TreeProcessor(root, 3).procesTree();
		assertEquals("Expected result", root, expectedRootNode);
		
    }

}
