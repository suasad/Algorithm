import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	int V;
	List<Integer> adjacency[];
	public Graph(int V) {
		adjacency = new LinkedList[V];
		this.V = V;
		for(int i=0;i<V;i++) {
			adjacency[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int u, int v) {
		adjacency[u].add(v);
		adjacency[v].add(u);
	}
	
	void BFS(int src) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		boolean visited[] = new boolean[V];
		visited[src] = true;
		Iterator<Integer> i = new LinkedList().iterator();
		while(queue.isEmpty() == false) {
			int u = queue.poll();
			System.out.print(u+" ");
			 i = adjacency[u].iterator();
			 while(i.hasNext()) {
				 int v = i.next();
				 if(visited[v] == false) {
					 visited[v] = true;
					 queue.add(v);
				 }
			 }
		}
	}
	
	void DFS(int src) {
		boolean visited[] = new boolean[this.V];
		DFSUtil(src,visited);
	}

	private void DFSUtil(int src, boolean[] visited) {
		if(visited[src]) {
			return;
		}
		System.out.print(src+" ");
		visited[src] = true;
		Iterator<Integer> i = adjacency[src].iterator();
		while(i.hasNext()) {
			DFSUtil(i.next(), visited);
		}
		
	}
	
	boolean checkCycleUndirected() {
		
		for(int i=0;i<V;i++) {
			
		}
		return false;
	}
	
    boolean checkCycleDirected() {
		
		return false;
	}
	
	// Driver method to 
    public static void main(String args[]) 
    { 
        Graph g = new Graph(5); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        g.addEdge(4, 1);
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 3)"); 
  
        g.BFS(0);
        System.out.println("\nFollowing is Depth First Traversal "+ 
                "(starting from vertex 3)"); 
        g.DFS(0);
    } 
}
