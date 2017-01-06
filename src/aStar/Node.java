package aStar;

import java.util.ArrayList;
import java.util.Collections;

public class Node implements Comparable<Node> {
        /* Nodes that this is connected to */
        AreaMap map;
        ArrayList<Node> neighborList;				// list of neighbor nodes to this node
        ArrayList<Double> neighborDistance;			// distance to each of the neighbor nodes in above list
        boolean visited;
        public double distanceFromStart;			// distance from Start node to this node
        public double heuristicDistanceToGoal;			// estimated distance from node to Goal node
        public double TotalDistanceFromGoal;			// estimated distance from start to Goal node going through this node, TotalDistanceFromGoal = heuristicDistanceToGoal + distanceFromStart
        Node previousNode;					// previous node in the path to this node.  How did we get to this node.
        public int nodeNum;					// the number of this node on the map
        public double x;					// x coordinate of this node
        public double y;					// y coordinate of this node
        boolean isStart;					// is this a start node?
        boolean isGoal;						// is this a goal node?
        
        Node(int n, double x, double y) {
                neighborList = new ArrayList<Node>();
                neighborDistance = new ArrayList<Double>();
                this.nodeNum = n;
                this.x = x;
                this.y = y;
                this.visited = false;
                this.distanceFromStart = Integer.MAX_VALUE;
                this.isStart = false;
                this.isGoal = false;
        }
        
        Node (double x, double y, boolean visited, int distanceFromStart , boolean isStart, boolean isGoal) {
                neighborList = new ArrayList<Node>();
                this.x = x;
                this.y = y;
                this.visited = visited;
                this.distanceFromStart = distanceFromStart;
                this.isStart = isStart;
                this.isGoal = isGoal;
        }
        
        public Double getNeighborDistance(int i) {
            return neighborDistance.get(i);
        }
        
        public int getNeighborSize() {
            return neighborList.size();
        }
        
        public Node getNeighbor(int i) {
            return neighborList.get(i);
        }
        
        public void setNeighbor(Node n, double dist) {
        	neighborList.add(n);
        	neighborDistance.add(dist);
        }

        public boolean isVisited() {
                return visited;
        }

        public void setVisited(boolean visited) {
                this.visited = visited;
        }

        public Node getPreviousNode() {
                return previousNode;
        }

        public void setPreviousNode(Node previousNode) {
                this.previousNode = previousNode;
        }
              
        public boolean isStart() {
                return isStart;
        }

        public void setStart(boolean isStart) {
                this.isStart = isStart;
        }

        public boolean isGoal() {
                return isGoal;
        }

        public void setGoal(boolean isGoal) {
                this.isGoal = isGoal;
        }

        public boolean equals(Node node) {
                return (node.x == x) && (node.y == y);
        }

        // Compare this node with another node using TotalDistanceFromGoal.
        //  Used by Collections.sort to sort the list in order by total distance
        public int compareTo(Node otherNode) {               
                if (TotalDistanceFromGoal < otherNode.TotalDistanceFromGoal) {
                        return -1;
                } else if (TotalDistanceFromGoal > otherNode.TotalDistanceFromGoal) {
                        return 1;
                } else {
                        return 0;
                }
        }
}