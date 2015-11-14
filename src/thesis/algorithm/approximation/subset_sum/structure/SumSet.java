package thesis.algorithm.approximation.subset_sum.structure;

import java.util.HashSet;
import java.util.Set;

public class SumSet {

	private Integer maxRange;
	Set<Long> set = new HashSet<Long>();
	private double q = 0.0;

	public SumSet(Integer maxRange) {
		this.maxRange = maxRange;
	}

	public SumSet(Integer maxRange, double q) {
		this.maxRange = maxRange;
		this.q = q;
	}
	
	public void add(Integer element) {
		Set<Long> expandSet = expandSet(element);
		trim();
		set.addAll(expandSet);
	}

	private void trim() {
		Set<Long> trimSet= new HashSet<Long>();
		long last = 0;
		trimSet.add(last);
		for (Long element : set) {
			if (element > last*(1+q)) {
				trimSet.add(element);
				last = element;
			}
		}
		set = trimSet;
	}

	private Set<Long> expandSet(Integer element) {
		Set<Long> result = new HashSet<Long>();
		if (element > maxRange) {
			return result;
		}
		result.add(element.longValue());
		for (Long e : set) {
			long extendedElement = e + element;
			if (extendedElement <= maxRange) {
				result.add(extendedElement);
			}
		}
		return result;
	}
	
	public Long getSum() {
		Long maxValue = Long.MIN_VALUE;
		for (Long value : set) {
			if (value > maxValue) {
				maxValue = value;
			}
		}
		return maxValue;
	}
	
	@Override
	public String toString() {
		return set.toString();
	}
}
