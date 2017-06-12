package interkassa;

import java.util.LinkedList;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

public class ListHelperUtil {

	
	public static List<Leaf> mergeSort(List<Leaf> list) {
		List<Leaf> left = new LinkedList<>();
		List<Leaf> right = new LinkedList<>();

		if (list.size() <= 1) {
			return list;
		} else {
			int middle = list.size() / 2;

			for (int i = 0; i < middle; i++) {
				left.add(list.get(i));
			}

			for (int i = middle; i < list.size(); i++) {
				right.add(list.get(i));
			}

			left = mergeSort(left);
			right = mergeSort(right);

			merge(left, right, list);
		}
		return list;
	}

	private static void merge(List<Leaf> left, List<Leaf> right, List<Leaf> whole) {
		int leftIndex = 0;
		int rightIndex = 0;
		int wholeIndex = 0;

		while (leftIndex < left.size() && rightIndex < right.size()) {
			if ((left.get(leftIndex).getWeight() < (right.get(rightIndex).getWeight()))) {
				whole.set(wholeIndex, left.get(leftIndex));
				leftIndex++;
			} else {
				whole.set(wholeIndex, right.get(rightIndex));
				rightIndex++;
			}
			wholeIndex++;
		}

		List<Leaf> rest;
		int restIndex;
		if (leftIndex >= left.size()) {
			rest = right;
			restIndex = rightIndex;
		} else {
			rest = left;
			restIndex = leftIndex;
		}

		for (int i = restIndex; i < rest.size(); i++) {
			whole.set(wholeIndex, rest.get(i));
			wholeIndex++;
		}
	}
	
	
	public static Entry<List<Leaf>, List<Leaf>> getSubListAfterSplit(final List<Leaf> list, final int w_constant) {
	    final List<Leaf> inCriteria = new LinkedList<>();
	    final List<Leaf> notInCriteria = new LinkedList<>();
		int accumulator = 0;
		for (Leaf leaf : list) {
			if (accumulator >= w_constant){
				notInCriteria.add(leaf);
			} else {
				inCriteria.add(leaf);
			}
			accumulator += leaf.getWeight();
		}
		//Simple alternative for Tuple2
	    final SimpleImmutableEntry<List<Leaf>, List<Leaf>> result = new SimpleImmutableEntry<>(notInCriteria, inCriteria);
	    return result;
	}

}
