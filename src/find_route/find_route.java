package find_route;

import java.util.*;

public class find_route {

	public static void main(String[] args) {
		String fileName = args[0];
		String start = args[1];
		String end = args[2];
		BuildGraph graph = new BuildGraph(fileName);
		graph.PrintGraph();
		Node goal = Search.uniformCostSearch(graph, start, end);
		int distance = 0;
		if(goal.getCost() != Integer.MAX_VALUE) {
			distance = goal.getCost();
		}
		System.out.println("distance: " + distance + " km");
		System.out.println("route:");
		if(goal.getParentNode() == null) {
			System.out.println("none");
		}
		List<Node> path = new ArrayList<Node>();
		while(goal != null) {
			path.add(goal);
			goal = goal.getParentNode();
		}
		for(int i = path.size() - 1; i > 0; i--) {
			int initial = graph.cities.indexOf(path.get(i).getCity());
			int next = graph.cities.indexOf(path.get(i - 1).getCity());
			System.out.println(path.get(i).getCity() + " to " 
			+ path.get(i - 1).getCity() + ", " + graph.graph[initial][next] + " km");
		}
	}

}
