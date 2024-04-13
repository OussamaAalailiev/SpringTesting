package ma.siid.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessTest {

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actualResult = businessImpl.calculateSum(new int [] {1, 2, 3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSum_empty() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actualResult = businessImpl.calculateSum(new int [] { });
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSum_oneValue() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actualResult = businessImpl.calculateSum(new int [] { 99 });
		int expectedResult = 99;
		assertEquals(expectedResult, actualResult);
	}

}
