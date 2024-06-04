package projec;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class graphe{
	public List<sommet> sommets;
	public List<arc> arcs;
	public static sommet findSommetById(List<sommet> sommets, int id) {
   		for (sommet s : sommets) {
      		if (s.getId() == id) {
        	return s;
    	  }
   		}
   return null; // or throw an exception if not found
}
    public arc getarc(sommet Dep, sommet Arr){
        for (arc a : arcs){
            if (a.Dep == Dep && a.Arr == Arr)
            return a;
        }
	return null;
    }
	public sommet getById(int idd){
		for (sommet s : sommets){
			if (idd == s.id)
			return s;
		}
		return null;
	}
	public graphe(List<sommet> sommets,List<arc> arcs){
			this.sommets=sommets;
			this.arcs=arcs;
			}
	public sommet findClosetSommet(List<sommet> somm) {
        if (somm.isEmpty()) {
			System.out.println("find the Closest sommet failed");
            return null;
        }

        sommet closestSommet = somm.get(0);

        for (sommet obj : somm) {
            if (obj.getDist() < closestSommet.getDist()) {
                closestSommet.copyFrom(obj);
            }
        }

        return closestSommet;
    }
	
	
	public static void removeAddSommetById(List<sommet> sommrem, List<sommet> sommadd, int tarid) {
    	Iterator<sommet> iterator = sommrem.iterator();
        while (iterator.hasNext()) {
            sommet obj = iterator.next();
            if (obj.getId() == tarid) {
				sommadd.add(obj);
                iterator.remove();
                break;
            }
        }
    }
}	
