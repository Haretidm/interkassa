package interkassa;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Node {
	private String name;
	private List<Node> subNodesList;
	private List<Leaf> leafList;
	
	private boolean visited = false;

	public Node(final String value) {
		this.name = value;
		this.subNodesList = new LinkedList<>();
		this.leafList = new LinkedList<>();
	}
	
	public Node(final String value, final List<Node> nodeList, final List<Leaf> leafList) {
		this.name = value;
		this.subNodesList = nodeList;
		this.leafList = leafList;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public List<Node> getSubNodeList() {
		return subNodesList;
	}

	public void setSubNodeList(List<Node> subNodesList) {
		this.subNodesList = subNodesList;
	}

	public List<Leaf> getLeafList() {
		return leafList;
	}

	public void setLeafList(List<Leaf> leafList) {
		this.leafList = leafList;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, subNodesList, leafList);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) return false;
		Node node = (Node) obj;
	    return this.subNodesList.equals(node.getSubNodeList())
	    		&& this.leafList.equals(node.getLeafList())
	    		&& this.name.equals(node.getName());
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", subNodesList=" 
				+ subNodesList + ", leafList=" + leafList + "]";
	}
}
