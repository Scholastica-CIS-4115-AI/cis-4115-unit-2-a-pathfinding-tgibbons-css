package aStar;

public class main_controller {
	
    private static int start = 1;
    private static int goal = 11;
    private static Path path;

    public static void main(String[] args) { 
    	System.out.println("MainControl starting up");
    	
    	System.out.println("Map initializing...");
        AreaMap map = new AreaMap();
        
    	System.out.println("Pathfinder initializing...");
        AStar pathFinder = new AStar(map);
        
        System.out.println("Calculating shortest path from node "+start+" to node "+goal);
        path = pathFinder.calcShortestPath(start, goal);
                
        System.out.println("Starting with Errors --- Printing map of shortest path...");
        pathFinder.printPath();
    	
    }
	
	
}
