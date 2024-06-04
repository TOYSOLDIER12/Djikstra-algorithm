package projec;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class djikstra{
	List<sommet> ShortestPath;
	List<sommet> sommetNonTraited;
	public djikstra(){};
	public void djikstraAlgo(graphe G, sommet Sdeb){
		sommetNonTraited = new ArrayList<>(G.sommets);
		sommet a = new sommet();
		List<sommet> sommetTraited = new ArrayList<>();
		for (Iterator<sommet> iterator = sommetNonTraited.iterator(); iterator.hasNext(); ){
			sommet s = iterator.next();
			s.distance = Integer.MAX_VALUE;
			iterator.remove();
		}
		Sdeb.distance = 0;
		Sdeb.previous=null;
		while (!sommetNonTraited.isEmpty()){
			a.copyFrom(G.findClosetSommet(sommetNonTraited));
			G.removeAddSommetById(sommetNonTraited,sommetTraited,a.id);
			for (sommet s : new ArrayList<>(sommetNonTraited)){
				for (sommet v : s.voisins){
					if (v.distance > s.distance){
						v.distance = s.distance + G.getarc(s,v).getPoids();
						v.previous = s;
			
                }
		}
			}

		}
    }
	public List<sommet> ZePath(graphe G, sommet Sdeb, sommet Sfin){
		boolean FoundSource = false;
		sommet iteratr = new sommet();
		djikstraAlgo(G, Sdeb);
		iteratr.copyFrom(Sfin.getPrevious());
		while(!FoundSource){
			iteratr.copyFrom(iteratr.getPrevious());
			if (iteratr == null){
				return ShortestPath;
			}
			else{
				ShortestPath.add(G.findSommetById(G.sommets, iteratr.getId()));
			}
			if (iteratr.previous == Sdeb){
				FoundSource = true;
			}
		}
		Collections.reverse(ShortestPath);
		return ShortestPath;
	}
}
