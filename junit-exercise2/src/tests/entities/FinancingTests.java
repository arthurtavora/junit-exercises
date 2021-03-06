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
	
	@Test
	public void setIncomeShouldUpdateIncomeWhenValidArguments() {
		
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		
		f.setIncome(3000.0);
		
		Assertions.assertEquals(3000.0, f.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidArguments() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
			f.setIncome(1000.0);
		});
	}
	
	@Test
	public void setMonthsShouldUpdateMonthsWhenValidArguments() {
		
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		
		f.setMonths(90);
		
		Assertions.assertEquals(90, f.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidArguments() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
			f.setMonths(70);
		});
	}
	
	@Test
	public void entryShouldReturnTwentyPercentOfTotalAmount() {
		
		Financing f = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
		double expectedValue = 20000.0;
		
		double value = f.entry();
		
		Assertions.assertTrue(expectedValue == value);
	}
	
	@Test
	public void quotaShouldCalculateCorrectNumberOfInstallments() {
		
		Financing f = FinancingFactory.createFinancing(200000.0, 7000.0, 80);
		double expectedValue = 2000.0;
		
		double value = f.quota();
		
		Assertions.assertTrue(expectedValue == value);
	}
}
