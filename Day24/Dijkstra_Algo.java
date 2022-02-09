package Day24;
import java.util.*;

class Node implements Comparator<Node> {
    int v, weight;
    Node(int v, int w) { this.v = v; this.weight = w; }
    Node() {}
    int getV() { return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(Node n1, Node n2) {
        if(n1.weight < n2.weight)
            return -1;
        if(n1.weight > n2.weight)
            return 1;
        return 0;
    }
}

public class Dijkstra_Algo {
    static void Dijkstra(int s, List<List<Node>> adj, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        //Since s is the starting index the distance shall always be 0
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
        pq.offer(new Node(s, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            for(Node it: adj.get(node.getV())) {
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }
    }
}