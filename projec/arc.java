package projec;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class arc{
	public sommet Dep;
	public sommet Arr;
	public int poids;
    public arc(){};
	public arc(sommet Dep, sommet Arr, int poids){
		this.Dep = Dep;
		this.Arr = Arr;
		this.poids = poids;
	}
	public int getPoids(){
		return poids;
	}
}
