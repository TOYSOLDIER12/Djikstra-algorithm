package projec;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main{
		public static void main(String args[]){
			Scanner scan = new Scanner(System.in);
        	List<sommet> sommetList = new ArrayList<>();
        	List<arc> arcList = new ArrayList<>();
			// instace de graphe, ourGraph appears to be communist
			graphe myGraph = new graphe(sommetList, arcList);

        	// ajouter les sommets ?? let it be sommets
        	System.out.println("Enter the number of sommets:");
        	int numSommets = scan.nextInt();
        	for (int i = 0; i < numSommets; i++) {
            	System.out.println("Enter the name for sommet " + (i + 1) + ":");
            	String sommetName = scan.next();
            	sommetList.add(new sommet(null, sommetName));
        	}

        	// ajouter les arcs
        	System.out.println("Enter the number of arcs:");
        	int numArcs = scan.nextInt();
        	for (int i = 0; i < numArcs; i++) {
            	System.out.println("Enter the departure sommet id for arc " + (i + 1) + ":");
            	int depId = scan.nextInt();
            	sommet depSommet = myGraph.findSommetById(sommetList, depId);
            	System.out.println("Enter the arrival sommet id for arc " + (i + 1) + ":");
            	int arrId = scan.nextInt();
            	sommet arrSommet = myGraph.findSommetById(sommetList, arrId);
            	System.out.println("Enter the weight for arc " + (i + 1) + ":");
            	int weight = scan.nextInt();
            	arcList.add(new arc(depSommet, arrSommet, weight));
        	}
    		 // Add voisins for each sommet
			for (sommet s : sommetList) {
				System.out.println("Enter the number of voisins for sommet " + s.getId() + ":");
				int numVoisins = scan.nextInt();
	
				List<sommet> voisinsList = new ArrayList<>();
				for (int i = 0; i < numVoisins; i++) {
					System.out.println("Enter the id of voisin " + (i + 1) + " for sommet " + s.getId() + ":");
					int voisinId = scan.nextInt();
					sommet voisin = graphe.findSommetById(sommetList, voisinId);
					voisinsList.add(voisin);
				}
	
				s.voisins = voisinsList;
			}

        	// Taking input for starting sommet
        	System.out.println("Enter the id of the starting sommet:");
        	int startSommetId = scan.nextInt();
        	sommet startSommet = myGraph.findSommetById(sommetList, startSommetId);
			System.out.println("destination Sommet Id :/ :");
			int destinationSommetId = scan.nextInt();
			sommet destinationSommet = myGraph.findSommetById(sommetList, destinationSommetId);
			
        	// Create instance of Dijikstra because why not	
        	djikstra myDjikstra = new djikstra();
        	List<sommet> shortestPath = myDjikstra.ZePath(myGraph, startSommet, destinationSommet);
			// Display :O :0
        	System.out.println("Shortest path:");
        	for (sommet s : shortestPath) {
            	System.out.println(s.name);
        	}
			}
    	}
