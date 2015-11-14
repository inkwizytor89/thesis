package thesis.algorithm.approximation.subset_sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import thesis.algorithm.approximation.subset_sum.structure.SumSet;

public class ApproxSubsetSum {
	
	private static final double REPRESENTAT_CONSTANT = 0.4;

	public static long calculateMaxSum(List<Integer> elements, Integer maxRange) {
		SumSet sumSet = new SumSet(maxRange, REPRESENTAT_CONSTANT);
		for (Integer element : elements) {
			sumSet.add(element);
		}
		return sumSet.getSum();
	}
}
