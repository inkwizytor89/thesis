package thesis.main.presentation;

import java.util.List;

import thesis.algorithm.approximation.subset_sum.ApproxSubsetSum;
import thesis.generate.NumberSetGenerator;

public class SubsetSumPresentation {

	private static final int NUMBER_COUNT = 10000;
	private static final Integer RANDOM_TEST_COUNT = 10;
	private static final Integer BOUND = 80000;

	public static void presents() {
		Integer maxRange = 100000;
		System.out.println("\nSUBSET SUM MODE:");
		System.out.println("\nProgram will find " + RANDOM_TEST_COUNT
				+ " randoms sum less than "+Integer.MAX_VALUE+"\n");

		NumberSetGenerator generator = new NumberSetGenerator(NUMBER_COUNT);
		for (int i = 0; i < RANDOM_TEST_COUNT; i++) {
			List<Integer> numberList = generator.createRandomNumberList(BOUND);
			System.out.println("Sum(Set["+NUMBER_COUNT+"] < "+ BOUND +" ) <= "+ maxRange+"\t total_sum = "+sum(numberList));
			long sum = ApproxSubsetSum.calculateMaxSum(numberList, maxRange);
			System.out.println("\tAPPROX-SUBSETSUM alghoritm find sum " + sum);
			System.out.println();
		}
	}
	
	private static Long sum(List<Integer> elements) {
		long sum = 0;
		for (Integer element : elements) {
			sum += element;
		}
		return sum;
	}
}
