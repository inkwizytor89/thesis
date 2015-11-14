package thesis.algorithm.approximation.subset_sum;

import java.util.LinkedList;
import java.util.List;

import thesis.structure.bitvector.BitVector;

public class NaiveSubsetSum {

	public static Integer calculateMaxSum(List<Integer> elements, Integer maxRange) {
		Integer sum = 0;
		for (Integer value : selectMaxSubset(elements, maxRange)) {
			sum += value;
		}
		return sum;
	}

	public static long calculateMaxSum(List<Integer> elements) {
		long sum = 0L;
		for (Integer value : elements) {
			sum += value;
		}
		return sum;
	}
	
	public static List<Integer> selectMaxSubset(List<Integer> elements, Integer maxRange) {
		 BitVector bitVector = new BitVector(elements.size());
		 List<Integer> solution = null;
		 long bestSum = 0;
	        do {
	            List<Integer> subset = new LinkedList<>();
	            for (int i=0;i<elements.size();i++) {
	                if (bitVector.getPositionValue(i)) {
	                    subset.add(elements.get(i));
	                }
	            }
	            long tmpSum = calculateMaxSum(subset);
	            if (tmpSum > bestSum && tmpSum <=maxRange) {
	                solution = subset;
	                bestSum = tmpSum ;
	            }
	        }while (bitVector.next());
	     return solution;
	}	        
}
