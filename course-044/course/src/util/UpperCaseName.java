package util;

import java.util.function.Function;

import entities.Product;

public class UpperCaseName implements Function<Product, String> {

	/**
	 * imprime cada nome da lista em letras maiusculas
	 */
	@Override
	public String apply(Product p) {
		return p.getName().toUpperCase();
	}
}
