package application;

import java.util.Set;
import java.util.TreeSet;

public class Program {
	public static void main(String[] args) {
		
		/**
		 * TreeSet - mais lento (operação O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator)
		 */
		Set<String> set = new TreeSet<>();
		
		set.add("TV");
		set.add("Tablet");
		set.add("Notebook");
		
		System.out.println(set.contains("Notebook"));
		
		for (String p : set) {
			System.out.println(p);
		}
	}
}