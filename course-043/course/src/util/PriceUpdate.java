package util;

import java.util.function.Consumer;

import entities.Product;

public class PriceUpdate implements Consumer<Product> {

	/**
	 * adiciona 10% a cada produto da lista
	 */
	@Override
	public void accept(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}
}
