package graphDetectCycle;

import java.util.HashSet;
import java.util.Set;

public class Node {
	int val;
	Set<Node> neighbors;
	public Node(int val) {
		this.val = val;
		neighbors = new HashSet<>();
	}
}