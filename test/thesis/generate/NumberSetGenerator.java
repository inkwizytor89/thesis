package thesis.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import thesis.structure.bitvector.BitVector;

public class NumberSetGenerator {

	private Random random = new Random();
	private Integer size;
	private BitVector bitVector;

	public NumberSetGenerator(Integer size) {
		this.size = size;
	}
	 
	public List<Integer> createRandomNumberList(Integer bound) {
		bitVector = new BitVector(bound);
		while (bitVector.getBitSum() < size) {
			Integer index = random.nextInt(bound);
			if (!bitVector.getPositionValue(index)) {
				bitVector.setPositionValue(index, true);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < bitVector.size(); i++) {
			if(bitVector.getPositionValue(i)) {
				list.add(i);
			}
		}
		return list;
	}
}
