package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new Node(i));
        }

        //Random edges
        graph.get(0).getNodeList().add(new Node(3));

        graph.get(5).getNodeList().add(new Node(1));
        graph.get(1).getNodeList().add(new Node(3));
        graph.get(5).getNodeList().add(new Node(0));

        graph.get(3).getNodeList().add(new Node(2));
        //graph.get(6).getNodeList().add(new Node(7));

        Stack<Node> resultReverse = new Stack<>();
        State[] state = new State[8];
        for (int i = 0; i < 8; i++) {
            state[i] = State.INCOMPLETE;
        }
        boolean cycle = false;
        for (Node currentNode : graph) {
            if (state[currentNode.getNodeName()] == State.INCOMPLETE) {
                if (!topologicalSort(currentNode, resultReverse, state)) {
                    cycle = true;
                }
            }
        }
        if (cycle) {
            System.out.println("graph has Cycle");
        } else {
            while (!resultReverse.empty()) {
                System.out.println(resultReverse.pop().getNodeName());
            }
        }

    }

    private static boolean topologicalSort(Node currentNode, Stack<Node> resultReverse, State[] states) {
        if (states[currentNode.getNodeName()] == State.STARTED) {
            return false;
        }

        if (states[currentNode.getNodeName()] == State.DONE) {
            return true;
        }

        states[currentNode.getNodeName()] = State.STARTED;
        for (Node current : currentNode.getNodeList()) {
            if (!topologicalSort(current, resultReverse, states)) {
                return false;
            }
        }
        states[currentNode.getNodeName()] = State.DONE;
        resultReverse.push(currentNode);
       return true;
    }
}

enum State {
    INCOMPLETE, STARTED, DONE
}
