package container;

import function.Function;
import util.Activation;
import util.GenRandom;

public class Layer {
	private Neuron[] neurons;
	private Function function;
	
	public Layer(int inNeurons, int nNeurons, Function function) {
		this.setFunction(function);
		this.neurons = new Neuron[nNeurons];
		
		for (int i = 0; i < nNeurons; i++) {
			double[] weights = new double[inNeurons];
			for (int j = 0; j < inNeurons; j++) {
				weights[j] = GenRandom.randomDouble(Neuron.getMinWeightValue(), Neuron.getMaxWeightValue());
			}
			Neuron neuron = new Neuron(weights, GenRandom.randomDouble(0,1));
			this.neurons[i] = neuron;
		}
	}
	
	public Layer(double[] input) {
		this.neurons = new Neuron[input.length];
		for (int i = 0; i < input.length; i++) {
			this.neurons[i] = new Neuron(input[i]);
		}
		this.setFunction(null);
	}
	
	public double applyActivation(double x) {
		double result = 0;
		if (this.getFunction() == null) {
			throw new IllegalArgumentException("Unknown activation function: " + function);
		} else {
			if (this.getFunction().equals(Function.SIGMOID)) {
				result = Activation.sigmoid(x);
			} else if (this.getFunction().equals(Function.TANH)) {
				result = Activation.tanh(x);
			} else if (this.getFunction().equals(Function.RELU)) {
				result = Activation.relu(x);
			}
		}
		return result;
	}
	
	public double applyActivationDerivative(double x) {
		double result = 0;
		if (this.getFunction() == null) {
			throw new IllegalArgumentException("Unknown activation function: " + function);
		} else {
			if (this.getFunction().equals(Function.SIGMOID)) {
				result = Activation.sigmoidDerivative(x);
			} else if (this.getFunction().equals(Function.TANH)) {
				result = Activation.tanhDerivative(x);
			} else if (this.getFunction().equals(Function.RELU)) {
				result = Activation.reluDerivative(x);
			}
		}
		return result;
	}

	public Neuron[] getNeurons() {
		return neurons;
	}

	public void setNeurons(Neuron[] neurons) {
		this.neurons = neurons;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
	
	
}
