package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String nodeName;
    List<Node> nodeList;

    Node(String name){
        this.nodeList= new ArrayList<>();
        this.nodeName= name;
    }
    public List<Node> getNodeList(){
        return this.nodeList;
    }
}
