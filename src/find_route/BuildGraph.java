package find_route;

import java.io.*;
import java.util.*;

public class BuildGraph {
	int[][] graph;
	List<String> cities;
	int numCities;
	
	BuildGraph(String inputFile) {
		numCities = 0;
		cities = new ArrayList<String>();
		Build(inputFile);
	}
	
	void Build(String inputFile) {
		try {
			File file = new File(inputFile);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String[] line = reader.nextLine().split(" ", 0);
				if(!(line[0].contains("END") || line[0] == "")) {
					if(!cities.contains(line[0])) {
						cities.add(line[0]);
						numCities += 1;
					}
					if(cities.size() > 1) {
						if(!cities.contains(line[1])) {
							cities.add(line[1]);
							numCities += 1;
						}
					}
				}
			}
			graph = new int[numCities][numCities];
			reader.close();
			reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String[] line = reader.nextLine().split(" ", 0);
				if(!(line[0].contains("END") || line[0] == "")) {
					graph[cities.indexOf(line[0])][cities.indexOf(line[1])] = Integer.parseInt(line[2]);
					graph[cities.indexOf(line[1])][cities.indexOf(line[0])] = Integer.parseInt(line[2]);
				}
			}
			reader.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
	
	void PrintGraph() {
		System.out.print(String.format("%" + 16 + "s", "") + " ");
		for(int i = 0; i < numCities; i++) {
			System.out.print(String.format("%" + 16 + "s", cities.get(i)) + " ");
		}
		System.out.println();
		for(int i = 0; i < numCities; i++) {
			System.out.print(String.format("%" + 16 + "s", cities.get(i)) + " ");
			for(int j = 0; j < numCities; j++) {
				System.out.print(String.format("%" + 16 + "s", graph[i][j]) + " ");
			}
			System.out.println();
		}
	}
}
