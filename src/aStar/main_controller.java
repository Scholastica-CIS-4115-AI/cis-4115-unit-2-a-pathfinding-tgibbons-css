package aStar;

import java.util.Scanner;

public class main_controller {
	
    private static int start = 1;
    private static int goal = 11;
    private static Path path;

    public static void main(String[] args) { 
        Scanner scnr = new Scanner(System.in);    // needed to read input from the keyboard
    	System.out.println("MainControl starting up");
        
        System.out.println("What node should pathfinding start with (1-30)");
        start = scnr.nextInt();                // reads in start node
        System.out.println("What node should pathfinding end at for a goal (1-30)");
    	goal = scnr.nextInt();                // reads in end node
        
    	System.out.println("Map initializing...");
        AreaMap map = new AreaMap();
        
    	System.out.println("Pathfinder initializing...");
        AStar pathFinder = new AStar(map);
        
        System.out.println("Calculating shortest path from node "+start+" to node "+goal);
        path = pathFinder.calcShortestPath(start, goal);
                
        System.out.println("Printing shortest path from start to goal");
        pathFinder.printPath();
    	
    }
	
	
}
