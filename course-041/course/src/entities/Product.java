package entities;

public class Product implements Comparable<Product> {
	
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

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	/**
	 * faz a comparacao de objetos a partir do atributo 'name', ignorando letras maiusculas e minusculas (toUpperCase())
	 */
	@Override
	public int compareTo(Product o) {
		return name.toUpperCase().compareTo(o.getName().toUpperCase());
	}
}
