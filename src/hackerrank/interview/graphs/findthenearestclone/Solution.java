package hackerrank.interview.graphs.findthenearestclone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        Graph[] graph = parseGraph(graphNodes, graphFrom, graphTo, ids);

        List<Graph> allWithColor = getAllWithColor(graph, val);
        if (allWithColor.size() < 2) return -1;

        return bfs(allWithColor);
    }

    private static int bfs(List<Graph> base) {
        Queue<Graph> queue = new LinkedList<>(base);
        Queue<Graph> nextQueue = new LinkedList<>();
        HashMap<Graph, Integer> nodeDepth = new HashMap<>();
        HashMap<Graph, Graph> discoverer = new HashMap<>();

        base.forEach(node -> {
            nodeDepth.put(node, 0);
            discoverer.put(node, node);
        });

        int depth = 1;

        while (!queue.isEmpty()) {
            Graph current = queue.remove();

            for (Graph a : current.getAdjacents()) {

                if (discoverer.containsKey(a)) {
                    Graph aa = discoverer.get(a);
                    Graph bb = discoverer.get(current);
                    if (!aa.equals(bb)) {
                        return nodeDepth.get(a) + depth;
                    }
                } else {
                    discoverer.put(a, discoverer.get(current));
                    nodeDepth.put(a, depth);
                    nextQueue.add(a);
                }
            }

            if (queue.isEmpty()) {
                depth++;
                queue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }

        return -1;
    }

    private static List<Graph> getAllWithColor(Graph[] graph, int val) {
        List<Graph> all = new ArrayList<>();

        for (Graph g : graph) {
            if (g.getColor() == val)
                all.add(g);
        }
        return all;
    }

    private static Graph[] parseGraph(int graphNodes, int[] graphFrom, int[] graphTo, long[] colors) {
        Graph[] nodes = new Graph[graphNodes];
        for (int i = 0; i < graphFrom.length; i++) {
            int from = graphFrom[i] - 1;
            int to = graphTo[i] - 1;

            parseNode(from, colors, nodes);
            parseNode(to, colors, nodes);
            nodes[from].addAdjacent(nodes[to]);
            nodes[to].addAdjacent(nodes[from]);
        }

        return nodes;
    }

    private static void parseNode(int node, long[] colors, Graph[] nodes) {
        if (nodes[node] == null) {
            nodes[node] = new Graph(node, colors[node]);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private static class Graph {
        private int label;
        private int color;
        private List<Graph> adjacents = new ArrayList<>();

        public Graph(int label, long color) {
            this.label = label;
            this.color = Math.toIntExact(color);
        }

        public void addAdjacent(Graph g) {
            adjacents.add(g);
        }

        public int getLabel() {
            return label;
        }

        public int getColor() {
            return color;
        }

        public List<Graph> getAdjacents() {
            return adjacents;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Graph graph = (Graph) o;
            return label == graph.label;
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Graph{");
            sb.append("label=").append(label);
            sb.append('}');
            return sb.toString();
        }
    }
}
