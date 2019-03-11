package com.suman.java.DijkstraAlgo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ShortestPathAlgo {


	private void dijkstra(int[][] adjacentMatrix) {
		int v = adjacentMatrix.length;
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];
		distance[0] = 0;
		for(int i=1; i<v; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<v-1; i++){
			//Find vertex with minimum distance
			int minvertex = findMinVertex(distance, visited);
			visited[minvertex] = true;
			//find neighbour
			for(int j=0; j<v; j++){
				if(adjacentMatrix[minvertex][j] != 0 && !visited[j]){
					int newDist = distance[minvertex] + adjacentMatrix[minvertex][j];
					if(newDist < distance[j]){
						distance[j] = newDist;
					}
				}
			}
		}
		
		Map<Integer, Integer> pathMap = new LinkedHashMap<>();
		int total_val = 0;
		//print
		for(int i=0; i<v; i++){
			System.out.println(i + " ----> " + distance[i]);
			pathMap.put(i, distance[i]);
			if(i != v-1){
				total_val += distance[i];
			}
		}
		/*int ignore_val = total_val - pathMap.get(v-1);
		//find shortest path
		System.out.println("Shortest Path is\n");
		for(int i=0; i<pathMap.size()-1; i++){
			if(pathMap.get(i) != ignore_val){
				System.out.print(i);
				System.out.print(" ---> ");
			}
		}
		System.out.print(v-1);*/
		
	}
	
	private int findMinVertex(int[] distance, boolean[] visited) {
		int minvertex = -1;
		for(int i=0; i<distance.length; i++){
			if(!visited[i] && (minvertex == -1 || distance[i] < distance[minvertex])){
				minvertex = i;
			}
		}
		return minvertex;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of Vertices");
		int v = s.nextInt();
		System.out.println("Enter number of Edges");
		int e = s.nextInt();
		int adjacentMatrix[][] = new int[v][v];
		for(int i=0; i<e; i++){
			System.out.println("Enter to vertice");
			int v1 = s.nextInt();
			System.out.println("Enter from vertice");
			int v2 = s.nextInt();
			System.out.println("Enter weight between them");
			int weight = s.nextInt();
			adjacentMatrix[v1][v2]= weight;
			adjacentMatrix[v2][v1]= weight;
		}
		ShortestPathAlgo spa = new ShortestPathAlgo();
		spa.dijkstra(adjacentMatrix);
	}


}
