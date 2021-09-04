package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void constructorShouldInstantiateFinancingObjectWhenValidArguments() {

		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

		Assertions.assertEquals(100000.0, f.getTotalAmount());
		Assertions.assertEquals(2000.0, f.getIncome());
		Assertions.assertEquals(80, f.getMonths());
	}

	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidArguments() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			FinancingFactory.createFinancing(100000.0, 2000.0, 20);
		});
	}
	
	@Test
	public void setTotalAmountShouldUpdateTotalAmountWhenValidArguments() {
		
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		
		f.setTotalAmount(80000.0);
		
		Assertions.assertEquals(80000.0, f.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidArguments() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
			f.setTotalAmount(200000.0);
		});
	}
}
