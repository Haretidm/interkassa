package interkassa;

import java.util.Objects;

public class Leaf {
	private String name;
	private int weight;
	
	public Leaf(final String name, final int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(final int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Leaf [name=" + name + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Leaf)) return false;
		Leaf leaf = (Leaf) obj;
	    return this.name.equals(leaf.name) &&
	           (this.weight == leaf.weight);
	}
}
