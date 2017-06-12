package interkassa;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

public class TreeProcessor {
	private Node rootNode;
	private final int w;
	
	
	public TreeProcessor(Node rootNode, final int w) {
		this.rootNode = rootNode;
		this.w = w;
	}
	
	public void procesTree(){
		procesTreeFromNode(rootNode);
	}
	
	//Performing BFS traversal 
	private void procesTreeFromNode(Node node){
		Queue<Node> queue = new LinkedList<>();
		
		node.setVisited(true);
		queue.add(node);
		
		while (!queue.isEmpty()) {
			final Node actualNode = queue.remove();
			final List<Leaf> sortedLeafList = ListHelperUtil.mergeSort(actualNode.getLeafList());
			
			final Entry<List<Leaf>, List<Leaf>> pairOfSublist = ListHelperUtil.getSubListAfterSplit(sortedLeafList, w);
			actualNode.setLeafList(pairOfSublist.getValue()); //changing leaf sublist to the new one
			
			final List<Node> subLists = actualNode.getSubNodeList();
			
			if (!subLists.isEmpty()) {
				subLists.get(0).getLeafList().addAll(pairOfSublist.getKey()); //rest part are added to fi
			}
			
			for (Node v : subLists) {
				if (!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
				}
			}	
		}
		
	}
	
}
