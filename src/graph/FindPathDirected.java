package graph;

import java.util.ArrayList;
import java.util.List;

public class FindPathDirected {

    public static void main(String[] args) {
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            graph.add(new Node(i));
        }

        //Random edges
        graph.get(0).getNodeList().add(new Node(2));

        graph.get(2).getNodeList().add(new Node(3));
        graph.get(3).getNodeList().add(new Node(4));
        graph.get(4).getNodeList().add(new Node(0));

        graph.get(1).getNodeList().add(new Node(4));

        graph.get(4).getNodeList().add(new Node(9));

        System.out.println(checkIfpathExists(graph,0,2));

        System.out.println(checkIfpathExists(graph,1,3));

        System.out.println(checkIfpathExists(graph,4,3));

    }

    public static boolean checkIfpathExists(List<Node> graph, int startNodeId, int endNodeId) {
        if (startNodeId > graph.size())
            return false;
        //TODO other validation

        for (Node e : graph.get(startNodeId).getNodeList()) {
            boolean visited[] = new boolean[graph.size()];
            visited[startNodeId] = true;
            dfs(e, visited, graph, endNodeId);
            if (visited[endNodeId]) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(Node e, boolean[] visited, List<Node> graph, int endNodeId) {
        if (visited[e.getNodeName()]) {
            return;
        }
        visited[e.getNodeName()] = true;
        if(e.getNodeName()==endNodeId){
            return;
        }
        for (Node next : graph.get(e.getNodeName()).getNodeList()) {
            if (visited[next.getNodeName()]) {
                continue;
            }
            dfs(next, visited, graph, endNodeId);
        }
    }

}
