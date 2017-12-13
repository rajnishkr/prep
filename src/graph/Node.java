package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int nodeName;
    List<Node> nodeList;

    Node(int name){
        this.nodeList= new ArrayList<>();
        this.nodeName= name;
    }
    public List<Node> getNodeList(){
        return this.nodeList;
    }

    public int getNodeName() {
        return nodeName;
    }
}
