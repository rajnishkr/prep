package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;

    Graph(){
        this.nodes=new ArrayList<>();
    }
    public boolean addNode(Node node){
        nodes.add(node);
        return true;
    }
    public List<Node> getNodes(){
        return this.nodes;
    }
}
