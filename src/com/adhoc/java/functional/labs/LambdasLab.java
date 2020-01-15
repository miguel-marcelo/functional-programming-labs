package com.adhoc.java.functional.labs.lambdas;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;		

class LambdasLab {
	
	List<Integer> filterOddNumbers(int[] array) {
		List<Integer> result = new ArrayList<>();
		for(int val:array) {
			if(val%2==1) {
				result.add(val);
			}
		}
		return result;
	}
	
	List<Integer> filterNumbers(int[] array, NumberFilter nf) {
		List<Integer> result = new ArrayList<>();
		for(int val:array) {
			if(nf.test(val)) {
				result.add(val);
			}
		}
		return result;
	}
	
	int[] numberList = new int[]{1,1,2,3,5,8,13,21};
	

	@Test
	void filterNumbersTest() {
		List<Integer> result = filterOddNumbers(numberList);
		Assertions.assertEquals(6, result.size());
		
		List<Integer> result2 = filterNumbers(numberList, new OddFilter());
		Assertions.assertEquals(6, result2.size());
		
		List<Integer> oddResult = filterNumbers(numberList, val -> val%2 == 1);
		Assertions.assertEquals(6, oddResult.size());
		
	}
	
	//TODO: rewrite filterOddNumbers to apply Strategy and accept a lambda
	//TODO: rewrite filterOddNumbersTest to use the lambda version of filterOddNumbers
	//TODO: rename filterOddNumbers to generalize its functionality, name it "filterNumbers"
	
	
	//TODO: complete this test to filter even numbers
	@Test
	void filterEvenNumbersTest() {
		List<Integer> evenResult = filterNumbers(numberList, val -> val%2 == 0);
		Assertions.assertEquals(2, evenResult.size());
	}

}

interface NumberFilter{
	boolean test(int i);
}

class OddFilter implements NumberFilter{
	public boolean test(int i) {
		return i%2==1;
	}
}
