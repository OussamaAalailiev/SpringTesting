package ma.siid.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ma.siid.unittesting.unittesting.data.SomeDataService;

/* Unit Test using a simple Service Stubs INSTEAD of Mocks that returns fake data. */

class SomeDataServiceImpl implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}
	
}

class SomeDataServiceImplEmpty implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { };
	}
	
}

class SomeDataServiceImplOneValue implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 571 };
	}
	
}

class SomeBusinessStubTest {

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new SomeDataServiceImpl());
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_empty() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new SomeDataServiceImplEmpty());
		int actualResult = businessImpl.calculateSumUsingDataService();// new int [] { }
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new SomeDataServiceImplOneValue());
		int actualResult = businessImpl.calculateSumUsingDataService();// new int [] { 99 }
		int expectedResult = 571;
		assertEquals(expectedResult, actualResult);
	}
	 

}
