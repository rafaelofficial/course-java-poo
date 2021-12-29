package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("TV", 900.00));
		list.add(new Product("Tablet", 450.00));
		
		Comparator<Product> comp = new Comparator<Product>() {
			/**
			 * Compara a partir do nome, ignorando letras maiusculas e minusculas
			 */
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};
		
		list.sort(comp);
		
		for (Product products : list) {
			System.out.println(products);
		}	
	}
}
