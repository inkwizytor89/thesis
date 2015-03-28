package test;

public class RandomGraphGenerator extends GraphGenerator {

    public RandomGraphGenerator() {
        super();
        edgesBitVector.setRandomValues();
    }

    public RandomGraphGenerator(Integer size) {
        super(size);
        edgesBitVector.setRandomValues();
    }

    public void randomize() {
        edgesBitVector.setRandomValues();
    }
}
