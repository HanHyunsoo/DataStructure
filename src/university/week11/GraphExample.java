package university.week11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GraphNode {
    int id;
    GraphNode link;
}

class AdjList {
    private GraphNode[] vertices;
    private int size;

    public AdjList(int N) {
        this.size = N;
        this.vertices = new GraphNode[N];
    }

    public void insertEdge(int v1, int v2) {
        GraphNode newNode = new GraphNode();
        newNode.id = v2;
        newNode.link = vertices[v1];
        vertices[v1] = newNode;
    }

    public int getOutDegree(int v) {
        if (v > size) return -1;

        int count = 0;
        GraphNode node = vertices[v];

        while (node != null) {
            count++;
            node = node.link;
        }

        return count;
    }

    public void printList() {
        for (int i = 0; i < this.size; i++) {
            System.out.printf("%d 정점에서 도달하는 정점들: ", i);
            GraphNode temp = this.vertices[i];
            while(temp != null) {
                System.out.printf("%2d", temp.id);
                temp = temp.link;
            }
            System.out.println();
        }
    }

    public void DFS(int v) {
        Stack<GraphNode> stack = new Stack<>();
        boolean[] visited = new boolean[this.size];
        stack.push(vertices[v]);
        visited[v] = true;
        System.out.print(v + " ");
        GraphNode w = stack.peek();

        while (!stack.isEmpty()) {
            if (w == null) {
                w = stack.pop();
            }

            if (!visited[w.id]) {
                visited[w.id] = true;
                System.out.print(w.id + " ");
                stack.push(w);
                w = vertices[w.id];
            } else {
                w = w.link;
            }
        }
        System.out.println();
    }

    public void BFS(int v) {
        Queue<GraphNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[this.size];
        queue.add(vertices[v]);
        visited[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            GraphNode w = queue.remove();

            while (w != null) {
                if (!visited[w.id]) {
                    queue.add(vertices[w.id]);
                    visited[w.id] = true;
                    System.out.print(w.id + " ");
                }
                w = w.link;
            }
        }
        System.out.println();
    }
}

public class GraphExample {
    public static void main(String[] args) {
        AdjList Graph = new AdjList(9);

        Graph.insertEdge(0, 4);
        Graph.insertEdge(0, 3);
        Graph.insertEdge(0, 1);

        Graph.insertEdge(1, 4);
        Graph.insertEdge(1, 2);

        Graph.insertEdge(2, 5);

        Graph.insertEdge(3, 6);
        Graph.insertEdge(3, 4);

        Graph.insertEdge(4, 7);
        Graph.insertEdge(4, 5);

        Graph.insertEdge(6, 7);
        Graph.insertEdge(6, 4);

        Graph.insertEdge(7, 8);
        Graph.insertEdge(7, 5);

        Graph.printList();
        System.out.println();

        System.out.println("DFS 순서");
        Graph.DFS(0);
        System.out.println();

        System.out.println("BFS 순서");
        Graph.BFS(0);
        System.out.println();

        System.out.println("0의 진출 차수 = " + Graph.getOutDegree(0));
    }
}
