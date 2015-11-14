package thesis.algorithm.approximation.subset_sum;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import thesis.algorithm.approximation.clique.CoverDualClique;
import thesis.algorithm.approximation.clique.NaiveClique;
import thesis.generate.NumberSetGenerator;
import thesis.structure.graph.Graph;

public class SubsetSumTest {

	private static final int NUMBER_COUNT = 23;
	private static final int BOUND = 10000;
	private static final int MAX_RANGE = 10000;
	
	NumberSetGenerator generator = new NumberSetGenerator(NUMBER_COUNT);

	@Test
	public void SubsetSum1() throws Exception {
		isCorrect(MAX_RANGE);
	}

	@Test
	public void SubsetSum2() throws Exception {
		isCorrect(MAX_RANGE);
	}

	@Test
	public void SubsetSum3() throws Exception {
		isCorrect(MAX_RANGE);
	}
	
	@Test
	public void SubsetSum4() throws Exception {
		isCorrect(MAX_RANGE);
	}
	
	private void isCorrect(Integer maxRange) {
		List<Integer> elements = generator.createRandomNumberList(BOUND);
		System.out.println("Sum(Set["+NUMBER_COUNT+"] < "+ BOUND +") <= "+ maxRange+"\t total_sum = "+sum(elements));
		long mentorSum = NaiveSubsetSum.calculateMaxSum(elements, maxRange);
		System.out.println("\tMENTOR-SUBSETSUM alghoritm find sum " + mentorSum);
		long approxSum = ApproxSubsetSum.calculateMaxSum(elements, maxRange);
		System.out.println("\tAPPROX-SUBSETSUM alghoritm find sum " + approxSum);
		System.out.println();
		
		assertTrue(mentorSum >= approxSum);
	}

	private Long sum(List<Integer> elements) {
		long sum = 0;
		for (Integer element : elements) {
			sum += element;
		}
		return sum;
	}
}
