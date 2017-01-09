package aStar;

import java.util.ArrayList;
import java.util.Collections;


public class AStar {
        private AreaMap map;
        /**
         * closedList The list of Nodes not searched yet, sorted by their distance to the goal as guessed by our heuristic.
         */
        private ArrayList<Node> exploredList;
        private ArrayList<Node> frontierList;
        private Path shortestPath;
        
        public AStar(AreaMap map) {
                this.map = map;
                
                exploredList = new ArrayList<Node>();
                frontierList = new ArrayList<Node>();
        }
        
        public double getEstimatedDistanceToGoal(double startX, double startY, double goalX, double goalY) {         
        	double dx = goalX - startX;
        	double dy = goalY - startY;
            return (double) Math.sqrt(  Math.pow(dx,2) + Math.pow(dy,2) );
    }
        
        public Path calcShortestPath(int startNode, int goalNode) {
                
                //mark start and goal node
                map.setStartLocation(startNode);
                map.setGoalLocation(goalNode);
                map.getStartNode().distanceFromStart = 0;
                
                // initialize the explored list and frontier
                exploredList.clear();
                frontierList.clear();
                frontierList.add(map.getStartNode());
                
                System.out.println("Calc Shortest Path");
                //while we haven't reached the goal yet
                while(frontierList.size() != 0) {
                        //System.out.println("\tFrontier List size = "+frontierList.size()+" --- Explored List size = "+exploredList.size());
                        
                        //get the first Node from non-searched Node list, sorted by lowest distance from our goal as guessed by our heuristic
                        Node current = frontierList.get(0);
                        System.out.println("Grabbing node "+current.nodeNum+" from Frontier list: "+current.x+","+current.y+" distances "+current.distanceFromStart+" & "+current.heuristicDistanceToGoal);
                        
                        // check if our current Node location is the goal Node. If it is, we are done.
                        if(current.isGoal()) {
                        		System.out.println("\tFound goal node");
                                return reconstructPath(current);
                        }
                        
                        //move current Node to the closed (already explored) list
                        frontierList.remove(current);
                        exploredList.add(current);
                        
                        //go through all the current Nodes neighbors and calculate if one should be our next step
                        for(int i=0;i<current.getNeighborSize();i++){
                                Node neighbor = current.getNeighbor(i);
                                System.out.print("Checking neighbor: "+neighbor.nodeNum+" at "+neighbor.x+","+neighbor.y+" distances "+current.getNeighborDistance(i)+" & "+neighbor.heuristicDistanceToGoal+" --- ");

                                //if we have already searched this Node, don't bother and continue to the next one 
                                if (exploredList.contains(neighbor)){
                                    System.out.println("Neighbor already on Explored list");
                                    continue;
                                }
                                                                             
                                // calculate how long the path is if we choose this neighbor as the next step in the path 
                                double newDistanceFromStart = current.distanceFromStart + current.getNeighborDistance(i);
                                
                                //add neighbor to the frontier list if it is not there
                                if(!frontierList.contains(neighbor)) {
                                	System.out.println("Adding neighbor to Fronter list");
                                	frontierList.add(neighbor);
                                    neighbor.setPreviousNode(current);
                                    neighbor.distanceFromStart = newDistanceFromStart;
                                    neighbor.heuristicDistanceToGoal = getEstimatedDistanceToGoal(neighbor.x, neighbor.y, map.getGoalLocation().x, map.getGoalLocation().y);
                                    neighbor.TotalDistanceFromGoal = neighbor.distanceFromStart + neighbor.heuristicDistanceToGoal;
                                    //neighbor.TotalDistanceFromGoal = neighbor.distanceFromStart;
                                    //keep the frontier list sorted so you explore the best nodes first
                                    Collections.sort(frontierList);
                                } else {
                                	System.out.println("Neighbor already on Fronter list... do nothing?");
                                	// If the node is already on the frontier, do we need to do anything?  
                                	// What if this path to the node is better than the first path we found to the node?
                                	// You need to check if the new distance to the neighbor, newDistanceFromStart, is less than the old distance to the neighbor, neighbor.distanceFromStart) {
                                        // if it is, you need to do the same things we did above:
                                        //   --- Set the PreviousNode to the current node
                                        //   --- Set the neighbor's distance from start to the newly calculated newDistanceFromStart
                                        //   --- Set the neighbor's heuristic distance to goal using getEstimatedDistanceToGoal()
                                        //   --- Set the neighbor's total distance from goal to the distance from start plus the heuristic distance to goal
                                        //   --- Make sure the frontier list stays sorted
  
                                }
                        
                        }
                        
                }
                System.out.println("Error --- No path found from start to goal");
                shortestPath = new Path();
                return null;
        }
        
        public void printPath() {
                Node node;
                //map.printMap();
                shortestPath.printPath();
        }
        
        private Path reconstructPath(Node node) {
                Path path = new Path();
                path.prependWayPoint(node);
                while(!(node.getPreviousNode() == null)) {
                	node = node.getPreviousNode();
                	path.prependWayPoint(node);
                }
                this.shortestPath = path;
                return path;
        }

}
