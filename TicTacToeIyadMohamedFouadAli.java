/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.iyad.mohamed.fouad.ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Iyad Mohamed Fouad 
 */
public class TicTacToeIyadMohamedFouadAli {
/**List that i will add to them user input and cpu input to compare them to the
 win conditions list at the (checkwinner method*/
    static ArrayList<Integer>playerpositions=new ArrayList<Integer>();
    static ArrayList<Integer>cpupositions=new ArrayList<Integer>();
   
    public static void main(String[] args) {
       char[][]gameboard={{'1','|','2','|','3'},
                          {'-','+','-','+','-'},
                          {'4','|','5','|','6'},
                          {'-','+','-','+','-'},
                          {'7','|','8','|','9'},};
       printgameboard(gameboard);
     while(true){
       Scanner input= new Scanner (System.in);
       System.out.println("Enter The number of your place from(1-9):");
       int playerpos=input.nextInt();
       // this while loop is to prevent a position to be over written by player
       while(playerpositions.contains(playerpos)||cpupositions.contains(playerpositions)){
       System.out.println("position taken Enter another one");
       playerpos=input.nextInt();}
       placement(gameboard,playerpos,"player");
        if(checkwinner().length()>0){
            printgameboard(gameboard);
         System.out.println(checkwinner());
          break;
       }
       checkwinner();
       Random rand=new Random();
      int cpupos=rand.nextInt(9)+1;
      //this while loop is to prevent a position to be over written by cpu
      while(playerpositions.contains(cpupos)|| cpupositions.contains(cpupos)){
       cpupos=rand.nextInt(9)+1;}
      placement(gameboard,cpupos,"cpu");
       printgameboard(gameboard);
       if(checkwinner().length()>0){
       System.out.println(checkwinner());
       break;
       }
     }
    } 
    
    
    //Method for printing gameboard
    public static void printgameboard(char[][]gameboard){
        for(char[]row : gameboard){
            for(char c : row)
                System.out.print(c);
            System.out.println();
        }
    }
    
    //method to place user input and also add it to the two lists that will be
    //compared to the win list
    public static void placement(char[][]gameboard,int pos,String user){
           char symbol=' ';
           if(user.equals("player")){
               symbol='X';
               playerpositions.add(pos);}
           else if(user.equals("cpu")){
               symbol='O';
               cpupositions.add(pos);}
        
        switch(pos){
            case 1:
                  gameboard[0][0]=symbol;
                break;
            case 2:
                  gameboard[0][2]=symbol;
                break;
            case 3:
                  gameboard[0][4]=symbol;
                break;
            case 4:
                  gameboard[2][0]=symbol;
                break;
            case 5:
                  gameboard[2][2]=symbol;
                break;
            case 6:
                  gameboard[2][4]=symbol;
                break;
            case 7:
                  gameboard[4][0]=symbol;
                break;
            case 8:
                  gameboard[4][2]=symbol;
                break;
            case 9:
                  gameboard[4][4]=symbol;
                break;
            default:
                break;
        
        
        
        
        
        
        
        
        
        
        
        
        }
    }
    
    //method to check the winner by comparing the user inputs list and cpu 
    // inputs list to this list that contain every win condition
    public static String checkwinner(){
    //lists with every win condition
    List toprow = Arrays.asList(1,2,3);
    List midrow = Arrays.asList(4,5,6);
    List botrow = Arrays.asList(7,8,9);
    List leftcol = Arrays.asList(1,4,7);
    List midcol = Arrays.asList(2,5,8);
    List rightcol = Arrays.asList(3,6,9);
    List cross1 = Arrays.asList(1,5,9);
    List cross2 = Arrays.asList(7,5,3);
    
    //added all of them to one list
    List<List>win=new ArrayList<List>();
    win.add(toprow);
    win.add(midrow);
    win.add(botrow);
    win.add(leftcol);
    win.add(midcol);
    win.add(rightcol);
    win.add(cross1);
    win.add(cross2);
    // compare the user list and cpu list with win list
    for(List l: win){
    if(playerpositions.containsAll(l))
        return "Congratulations! you won :D";
    else if(cpupositions.containsAll(l))
        return"Sorry You Lost :(";
    else if (cpupositions.size()+playerpositions.size()==9)
        return"it's a Draw!";
    }
    return"";
    } 
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

