package services;

import java.util.List;

public class CalculationService {
	
	/**
	 * @param list passa a lista que irá buscar o maior item dela  
	 * @return retorna o maior item da lista
	 */
	public static Integer max(List<Integer> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty");
		}
		
		Integer max = list.get(0);
		for (Integer item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}	
		return max;
	}
	

}
