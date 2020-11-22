/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiproject.ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Search {

    public Stack<Node> frontier = new Stack<Node>();
    Queue<Node> q = new LinkedList<>();
    public ArrayList<Node> explored = new ArrayList<Node>();
    Node initialState;

    public Search(Node initialState) {

        this.initialState = initialState;
    }

    public boolean DFS() {

        frontier.push(initialState);

        while (!frontier.empty()) {
            Node state = frontier.pop();
            explored.add(state);
            if (state.goalTest()) {
                printpath(state);
                return true;

            }
            state.ExpandMove();

            for (int i = 0; i < state.children.size(); i++) {

                Node child = state.children.get(i);

                if (!Contains(explored, child)) {
                    frontier.push(child);

                }

            }
        }

        return false;
    }

    public boolean BFS() {

        q.add(initialState);

        while (!q.isEmpty()) {
            Node state = q.poll();
            explored.add(state);
            if (state.goalTest()) {
                System.out.println();
                printpath(state);
                return true;

            }
            state.ExpandMove();

            for (int i = 0; i < state.children.size(); i++) {

                Node child = state.children.get(i);

                if (!Contains(explored, child)) {
                    q.add(child);

                }

            }
        }

        return false;
    }
// method to check if the node is in a certain list or not

    public static boolean Contains(List<Node> list, Node child) {
        boolean contains = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).IsSamePuzzle(child.puzzle)) {
                contains = true;
            }

        }

        return contains;
    }
// method to print the nodes till the goal node 

    public void printpath(Node node) {
        System.out.println("The path to the goal.....");
        initialState.printPuzzle();
        ArrayList<Node> path = new ArrayList<Node>();
        while (node.parent != null) {
            path.add(node);
            node = node.parent;

        }
        for (int i = path.size() - 1; i >= 0; i--) {
            if (path.get(i).goalTest()) {
                System.out.println();
                System.out.println("Goal found:");
            }
            path.get(i).printPuzzle();

        }

    }

}
