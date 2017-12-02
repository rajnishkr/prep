package graph;

public class FindPathDirected {

    public static void main(String[] args) {
        Graph graph = new Graph();
        for (int i = 0; i < 5 ; i++) {
            graph.addNode(new Node("index "+i));
        }

        //Random edges
        graph.getNodes().get(0).getNodeList().add(new Node("index 2"));
    }

}
