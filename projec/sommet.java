package projec;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class sommet{
	public static int counter=0;
	public String name;
	public int id; 
	public List<sommet> voisins;
	public int distance;
	public sommet previous;
	public sommet getPrevious(){
		return previous;
	}
	public int getDist(){
		return distance;
	}
	public int getId(){
		return id;
	}
	public sommet(List<sommet> voisins, String name ){
		this.name = name;
		this.distance = Integer.MAX_VALUE;
		this.setId();
		this.voisins = (voisins != null) ? voisins : new ArrayList<>();
	}
	public void setId(){
		this.id = ++counter;
	}
	public sommet(){}
	public void copyFrom(sommet other) {
    	this.voisins = other.voisins;
        this.distance = other.distance;
		this.id = other.id;
    }

}
