package ma.siid.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ma.siid.unittesting.unittesting.data.SomeDataService;

/* Unit Test using a fake Service implementation from the interface "SomeDataService" 
 *  which is a Mock that returns fake data. */

class SomeBusinessStubMockTest {
	
	// Creation of the object that holds the method 'calculate...()':
	SomeBusinessImpl businessImpl = new SomeBusinessImpl();
	// Creation of the Mock implementation of the interface 'SomeDataService': 
	SomeDataService dataServiceMock = mock(SomeDataService.class);
	
	// Injection of the dependency into the 'businessImpl': 
	@BeforeEach
	public void beforeEachMethod() {
		businessImpl.setSomeDataService(dataServiceMock);
	}

	@Test
	void calculateSumUsingDataService_basic() {
		/* When we call the method on the 'dataServiceMock'  We want to the method to return the 
		 * result 'new int[] {1, 2, 3}' Insteadof hitting the db directly*/
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3} );
		
		//Get the actual result:
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	 
	@Test
	void calculateSumUsingDataService_empty() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {});
		
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int [] {});
		
		int actualResult = businessImpl.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	

}
