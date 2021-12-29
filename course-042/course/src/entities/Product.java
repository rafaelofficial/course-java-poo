package entities;

public class Product {
	
	private String name;
	private Double price;
	
	public Product() {
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * m�todo est�tico trabalha com o pr�prio objeto passado como argumento
	 * @param p recebe um produto
	 * @return retira da lista produtos com o pre�o acima de 100.00
	 */
	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 100.0;
	}
	
	// m�todo n�o est�tico trabalha com o pr�prio objeto da classe
	public boolean nonStaticProductPredicate() {
		return price >= 100.0;
	}

	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", price);
	}
}
