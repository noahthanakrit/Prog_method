package container;

public class NeuronDemo {
	private Neuron n;
	
	public void demonstrate() {
		double[] weights = {0.2,0.3,0.4};
		this.setN(new Neuron(1));
		n.setMinWeightValue(0.1);
		n.setMaxWeightValue(0.7);
		n.setGradient(0.6);
		n.setBias(0.2);
		n.setWeights(weights);
	}

	public Neuron getN() {
		return n;
	}

	public void setN(Neuron n) {
		this.n = n;
	}
	
	
}
