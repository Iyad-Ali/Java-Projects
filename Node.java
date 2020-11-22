/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiproject.ex;

import java.util.ArrayList;

public class Node {

    public ArrayList<Node> children = new ArrayList<Node>();
    public Node parent;
    public int[] puzzle = new int[9];
    public int x = 0;
    private int col = 3;

    // Costructors  
    public Node() {
    }

    public Node(int[] p) {
        setPuzzle(p);
    }

    // method to fill the array puzzle
    public void setPuzzle(int[] p) {
        for (int i = 0; i < puzzle.length; i++) {
            this.puzzle[i] = p[i];

        }

    }

    // Method to test if this puzzle is the goal or not
    public boolean goalTest() {

        boolean goal = true;
        for (int i = 0; i < puzzle.length - 1; i++) {
            if (puzzle[i] > puzzle[i + 1]) {
                goal = false;
            }

        }

        return goal;
    }
// method to print our puzzle

    public void printPuzzle() {
        System.out.println();
        int k = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(puzzle[k] + " ");
                k++;

            }
            System.out.println();

        }

    }
// method to check if the given array of a node is same to the puzzle array or not

    public boolean IsSamePuzzle(int[] p) {
        boolean same = true;
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] != p[i]) {
                same = false;

            }

        }
        return same;

    }
// method to copy the array of puzzle to another array of new node

    public void copypuzzle(int[] a, int[] b) {
        {
            for (int i = 0; i < b.length; i++) {
                a[i] = b[i];

            }

        }
    }
    /* the next four method  swap element of array with element to its (right, left ,up ,down) in a new copied array
     and add the new node to the children list and make the original node its parent*/

// method to swap element of array with element to its left
    public void MoveToLeft(int[] p, int i) {
        if (i % col > 0) {
            int[] pc = new int[9];
            copypuzzle(pc, p);
            int temp = pc[i - 1];
            pc[i - 1] = pc[i];
            pc[i] = temp;
            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }

    }

//method to swap element of array with element to its right 
    public void MoveToRight(int[] p, int i) {
        if (i % col < col - 1) {
            int[] pc = new int[9];
            copypuzzle(pc, p);
            int temp = pc[i + 1];
            pc[i + 1] = pc[i];
            pc[i] = temp;
            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }

// method to swap element of array with element below it (3 indicies after it)
    public void MoveToDown(int[] p, int i) {
        if (i + col < puzzle.length) {
            int[] pc = new int[9];
            copypuzzle(pc, p);
            int temp = pc[i + 3];
            pc[i + 3] = pc[i];
            pc[i] = temp;
            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }
    }
// method to swap element of array with element above it (3 indicies before it)

    public void MoveToUp(int[] p, int i) {
        if (i - col >= 0) {
            int[] pc = new int[9];
            copypuzzle(pc, p);
            int temp = pc[i - 3];
            pc[i - 3] = pc[i];
            pc[i] = temp;
            Node child = new Node(pc);
            children.add(child);
            child.parent = this;
        }

    }
//method to expand the node to all four directions

    public void ExpandMove() {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == 0) {
                x = i;
            }

        }

        MoveToDown(puzzle, x);
        MoveToUp(puzzle, x);
        MoveToRight(puzzle, x);
        MoveToLeft(puzzle, x);

    }

}
