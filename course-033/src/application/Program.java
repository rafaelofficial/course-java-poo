package application;

import java.util.HashSet;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
		
		/**
		 * HashSet - mais rápido (operação O(1) em tabela hash) e não ordenado
		 */
		Set<String> set = new HashSet<>();
		
		set.add("TV");
		set.add("Tablet");
		set.add("Notebook");
		
		System.out.println(set.contains("Notebook"));
		
		for (String p : set) {
			System.out.println(p);
		}
	}
}