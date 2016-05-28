package findFriend;

public class UnionFind {
	public int cnt = 0;
	private int[] id;
	public UnionFind(int[][] matrix) {
		cnt = matrix.length;
		id = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			id[i] = i;
		}
	}
	
	public int find(int p) {
		if (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	
	public void union(int pId, int qId) {
		pId = find(pId);
		qId = find(qId);
		if (pId == qId) {
			return;
		}
		
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
		cnt--;
	}
	
	
}
