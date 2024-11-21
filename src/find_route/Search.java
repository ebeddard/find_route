package find_route;

import java.util.*;

class Search {
	
	public static Node uniformCostSearch(BuildGraph buildGraph, String startCity, String endCity) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        queue.add(new Node(startCity, null, 0, 0));

        int[][] graph = buildGraph.graph;
        
        int numCities = buildGraph.numCities;

        int explored = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.getCity().equals(endCity)) {
                return current;
            }

            if (current.getDepth() >= numCities) {
                break;
            }

            int currentNodeIndex = buildGraph.cities.indexOf(current.getCity());
            for (int i = 0; i < graph[currentNodeIndex].length; i++) {
                if (graph[currentNodeIndex][i] > 0) {
                    int totalCost = current.getCost() + graph[currentNodeIndex][i];
                    Node neighbor = new Node(buildGraph.cities.get(i), current, totalCost, current.getDepth() + 1);

                    if (!queue.contains(neighbor)) {
                        queue.add(neighbor);
                    } else {
                        for (Node n : queue) {
                            if (n.equals(neighbor) && n.getCost() > totalCost) {
                                queue.remove(n);
                                queue.add(neighbor);
                                break;
                            }
                        }
                    }
                }
            }
            explored++;
            if (explored == (numCities * numCities)) {
                break;
            }
        }

        return new Node("", null, Integer.MAX_VALUE, 0);
    }
}
