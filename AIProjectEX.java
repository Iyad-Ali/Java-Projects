/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiproject.ex;

import java.util.ArrayList;


public class AIProjectEX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] puzzle = {2,0,5,1,3,4,6,7,8};
        Node root = new Node(puzzle);

        Search s = new Search(root);

        long start = System.currentTimeMillis();

        // start of function 
        s.DFS();

        // end of function 
        // ending time 
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("DFS takes "
                + (end - start) + "ms");
    }

}
