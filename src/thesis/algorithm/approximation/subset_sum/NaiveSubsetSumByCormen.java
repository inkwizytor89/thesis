package thesis.algorithm.approximation.subset_sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import thesis.algorithm.approximation.subset_sum.structure.SumSet;

public class NaiveSubsetSumByCormen {
	
	public static long calculateMaxSum(List<Integer> elements, Integer maxRange) {
		SumSet sumSet = new SumSet(maxRange);
		for (Integer element : elements) {
			sumSet.add(element);
		}
		return sumSet.getSum();
		
		
//		List<Long> sumSet = new ArrayList<Long>();
//		int i=0;
//		for (Integer element : elements) {
//			List<Long> expandedList = expandList(sumSet, element);
//			List<Long> roundList = deleteHigherThan(expandedList, maxRange);
//			sumSet = mergeLists(sumSet, roundList);
//			System.err.println((++i)+"/"+elements.size());
//		}
//		return getMaxValue(sumSet);
	}
	
//	private static long getMaxValue(List<Long> sumSet) {
//		Long maxValue = Long.MIN_VALUE;
//		for (Long value : sumSet) {
//			if (value > maxValue) {
//				maxValue = value;
//			}
//		}
//		return maxValue;
//	}
//
//	private static List<Long> deleteHigherThan(List<Long> list, Integer maxRange) {
//		List<Long> result = new ArrayList<Long>();
//		for (Long element : list) {
//			if (element <= maxRange) {
//				result.add(element);
//			}
//		}
//		return result;
//	}
//
//	private static List<Long> mergeLists(List<Long> firstList, List<Long> secondList) {
//		Set<Long> result = new HashSet<Long>(firstList);
//		result.addAll(secondList);
//		return new ArrayList<Long>(result);
//	}
//	
//	private static List<Long> expandList(List<Long> list, Integer element) {
//		List<Long> result = new ArrayList<Long>();
//		result.add(element.longValue());
//		for (Long e : list) {
//			result.add(e+element);
//		}
//		return result;
//	}
}
