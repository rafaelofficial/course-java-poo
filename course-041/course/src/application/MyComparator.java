package application;

import java.util.Comparator;

import entities.Product;

public class MyComparator implements Comparator<Product> {

	/**
	 * Compara a partir do nome, ignorando letras maiusculas e minusculas
	 */
	@Override
	public int compare(Product p1, Product p2) {
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
	}

}
