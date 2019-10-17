package spring.AOP.impl;

import org.springframework.stereotype.Component;

@Component
public class calculatorImpl implements calculator {

	@Override
	public int add(int i, int j) {
		int res = i+j;
		return res;
	}

	@Override
	public int minus(int i, int j) {
		int res = i-j;
		return res;
	}

	@Override
	public int multiply(int i, int j) {
		int res = i*j;
		return res;
	}

	@Override
	public int div(int i, int j) {
		int res = i/j;
		return res;
	}

}
