package services;

import java.util.List;

public class CalculationService {
	
	/**
	 * @param list passa a lista que ir� buscar o maior item dela  
	 * @return retorna o maior item da lista
	 */
	public static <T extends Comparable<T>> T max(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty");
		}
		
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}	
		return max;
	}
}
