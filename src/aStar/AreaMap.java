package aStar;

import java.util.ArrayList;

public class AreaMap {

        private ArrayList<Node> map;
        private int startNode = 0;
        private int goalNode = 0;

        
        public AreaMap() {                
                createMap();
                System.out.println("\tMap Created");
                registerEdges();
                System.out.println("\tMap Node edges registered");
        }
        private void createMap() {
                map = new ArrayList<Node>();
                
                // the map should be read in a text file or xml file in the future
                map.add(new Node(0, 0.0,0.0));			// nodes are numbered starting with 1, so use an empty node 0
                map.add(new Node(1, 6.87, 7.99));
                map.add(new Node(2, 7.21, 7.86));
                map.add(new Node(3, 7.21, 7.48));
                map.add(new Node(4, 7.26, 8.68));
                map.add(new Node(5, 6.85, 9.35));
                map.add(new Node(6, 8.21, 8.00));
                map.add(new Node(7, 8.54, 7.21));
                map.add(new Node(8, 5.96, 7.50));
                map.add(new Node(9, 5.63, 7.50));
                map.add(new Node(10, 5.63, 9.08));
                map.add(new Node(11, 4.17, 8.54));
                map.add(new Node(12, 3.58, 8.54));
                map.add(new Node(13, 3.58, 8.02));
                map.add(new Node(14, 3.58, 7.50));
                map.add(new Node(15, 3.02, 7.50));
                map.add(new Node(16, 4.62, 6.47));
                map.add(new Node(17, 8.33, 5.79));
                map.add(new Node(18, 8.13, 5.46));
                map.add(new Node(19, 7.68, 5.18));
                map.add(new Node(20, 8.33, 4.38));
                map.add(new Node(21, 7.71, 4.38));
                map.add(new Node(22, 6.67, 4.92));
                map.add(new Node(23, 6.67, 4.38));
                map.add(new Node(24, 4.67, 4.38));
                map.add(new Node(25, 4.67, 0.83));
                map.add(new Node(26, 4.67, 0.33));
                map.add(new Node(27, 2.54, 0.33));
                map.add(new Node(28, 2.54, 0.83));
                map.add(new Node(29, 2.25, 1.42));
                map.add(new Node(30, 1.54, 0.33));
                map.add(new Node(31, 1.54, 0.83));
                map.add(new Node(32, 1.54, 4.38));
                map.add(new Node(33, 0.50, 6.50));
                map.add(new Node(34, 1.50, 6.50));
                map.add(new Node(35, 0.50, 7.46));
                map.add(new Node(36, 1.50, 7.46));
                map.add(new Node(37, 0.50, 8.50));
                map.add(new Node(38, 1.50, 8.50));
        }

        private void setBothNeighbors(int n1, int n2, double dist){
        	// set n2 as a neighbor of n1 and n1 as a neighbor of n2
        	//System.out.println("Adding path from "+n1+" to "+n2+" of distance "+dist);
        	map.get(n1).setNeighbor(map.get(n2), dist);
        	map.get(n2).setNeighbor(map.get(n1), dist);
        }
        
        
        /**
         * Registers the nodes edges (connections to its neighbors).
         */
        private void registerEdges() {
        	setBothNeighbors(1,2, 0.5);
        	setBothNeighbors(2,3, 0.4);
        	setBothNeighbors(2,4, 0.8);
        	setBothNeighbors(2,6, 1.1);
        	setBothNeighbors(3,7, 1.4);
        	setBothNeighbors(3,8, 1.2);
        	setBothNeighbors(3,22, 2.8);
        	setBothNeighbors(4,5, 0.8);
        	setBothNeighbors(4,6, 1.4);
        	setBothNeighbors(5,8, 2.2);
        	setBothNeighbors(5,10, 1.3);
        	setBothNeighbors(6,7, 0.8);
        	setBothNeighbors(7,18, 2.1);
        	setBothNeighbors(8,9, 0.2);
        	setBothNeighbors(9,10, 1.5);
        	setBothNeighbors(9,14, 2);
        	setBothNeighbors(9,16, 1.5);
        	setBothNeighbors(10,11, 1.6);
        	setBothNeighbors(11,12, 0.5);
        	setBothNeighbors(11,13, 0.7);
        	setBothNeighbors(12,13, 0.4);
        	setBothNeighbors(12,38, 2);
        	setBothNeighbors(13,14, 0.5);
        	setBothNeighbors(13,15, 0.8);
        	setBothNeighbors(14,15, 0.5);
        	setBothNeighbors(14,16, 2);
        	setBothNeighbors(15,34, 1.8);
        	setBothNeighbors(15,36, 1.4);
        	setBothNeighbors(16,24, 2);
        	setBothNeighbors(17,18, 0.5);
        	setBothNeighbors(18,19, 0.5);
        	setBothNeighbors(18,20, 1.1);
        	setBothNeighbors(19,21, 0.8);
        	setBothNeighbors(19,22, 1);
        	setBothNeighbors(20,21, 0.6);
        	setBothNeighbors(21,23, 1);
        	setBothNeighbors(22,23, 0.5);
        	setBothNeighbors(23,24, 2);
        	setBothNeighbors(24,25, 3.5);
        	setBothNeighbors(24,32, 3);
        	setBothNeighbors(25,26, 0.5);
        	setBothNeighbors(25,28, 2);
        	setBothNeighbors(26,27, 2);
        	setBothNeighbors(27,28, 0.6);
        	setBothNeighbors(27,30, 1);
        	setBothNeighbors(28,29, 0.6);
        	setBothNeighbors(28,31, 0.9);
        	setBothNeighbors(30,31, 0.5);
        	setBothNeighbors(31,32, 3.5);
        	setBothNeighbors(32,33, 2.3);
        	setBothNeighbors(33,34, 1);
        	setBothNeighbors(33,35, 1);
        	setBothNeighbors(34,36, 1);
        	setBothNeighbors(35,36, 1);
        	setBothNeighbors(35,37, 1);
        	setBothNeighbors(36,38, 1);
        	setBothNeighbors(37,38, 1);
       }
        

        public ArrayList<Node> getNodes() {
                return map;
        }
        
        public int getSize() {
            return map.size();
        }
        
        public Node getNode(int n) {
                return map.get(n);
        }

        public void setStartLocation(int n) {
                map.get(startNode).setStart(false);
                map.get(n).setStart(true);
                startNode = n;
        }

        public void setGoalLocation(int n) {
                map.get(goalNode).setGoal(false);
                map.get(n).setGoal(true);
                goalNode = n;
        }
        
        public Node getStartNode() {
                return map.get(startNode);
        }

        public Node getGoalLocation() {
                return map.get(goalNode);
        }
        
        public float getDistanceBetween(Node a, Node b){
        	float dist = (float) Math.sqrt(  Math.pow(a.x-b.x,2) + Math.pow(a.y-b.y,2)  );
        	return dist;
        }
        
        public void printMap() {
        	Node n;
        	
	        System.out.println("Nodes on map:");
	        for(int i=0; i<map.size(); i++) {
	        	n = map.get(i);
	        	System.out.println("Node "+i+" ("+n.x+" , "+n.y+")");
	        }
        }
}

