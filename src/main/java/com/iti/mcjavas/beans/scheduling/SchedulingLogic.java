package com.iti.mcjavas.beans.scheduling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iti.mcjavas.beans.scheduling.knapsackProblem.BoundedKnapsack;
import com.iti.mcjavas.beans.scheduling.knapsackProblem.Item;
import com.iti.mcjavas.orm.dao.FreightDao;
import com.iti.mcjavas.orm.model.Freight;

public class SchedulingLogic {

	private FreightDao freightDao = new FreightDao();

	public List<FreightQuantity> loadFreights() {
		List<FreightQuantity> freightInputs = new ArrayList<>();
		List<Freight> freights = freightDao.findAll();
		for (Freight freight : freights) {
			freightInputs.add(new FreightQuantity(freight));
		}
		return freightInputs;
	}

	public List<FreightQuantity> calculateOptimalLoad(Integer truckCapacity, List<FreightQuantity> freightInputs) {
		List<FreightQuantity> freightOptimals = new ArrayList<FreightQuantity>();
		BoundedKnapsack boundedKnapsack = new BoundedKnapsack(truckCapacity * 1000);
		
		Map<Integer, Freight> freights = new HashMap<>();
		for (FreightQuantity freightQuantity : freightInputs) {
			if (freightQuantity.getQuantity() != null && freightQuantity.getQuantity() > 0) {
				boundedKnapsack.add(String.valueOf(freightQuantity.getId()), freightQuantity.getWeight(), freightQuantity.getValue(),
						freightQuantity.getQuantity());
			}
			freights.put(freightQuantity.getId(), freightQuantity.loadFreight());
		}
		List<Item> solutionItems = boundedKnapsack.calcSolution();
		for (Item item : solutionItems) {
			Freight freight = freights.get(Integer.valueOf(item.getName()));
			FreightQuantity freightOptimal = new FreightQuantity(freight);
			freightOptimal.setQuantity(item.getInKnapsack());
			freightOptimals.add(freightOptimal);
		}
		return freightOptimals;
	}

}
