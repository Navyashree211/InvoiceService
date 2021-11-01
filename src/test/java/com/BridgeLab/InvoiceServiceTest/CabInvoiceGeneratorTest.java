package com.BridgeLab.InvoiceServiceTest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.BridgeLab.InvoiceService.CabInvoiceGenerator;
import com.BridgeLab.InvoiceService.InvoiceService;
import com.BridgeLab.InvoiceService.InvoiceSummary;
import com.BridgeLab.InvoiceService.Ride;
import com.BridgeLab.InvoiceService.RideRepository;

public class CabInvoiceGeneratorTest {
	@Test
	public void givenDistanceAndTimeForNormalRide_IfFareGreaterThanMinimumFare_ShouldReturnTotalFare() {
		double distance = 10;
		int time = 12;
		Assert.assertEquals(112, new CabInvoiceGenerator().calculateFare(distance, time, true), 0.0);
	}

	@Test
	public void givenDistanceAndTimeForPremiumRide_IfFareLessThanMinimumFare_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		Assert.assertEquals(20, new CabInvoiceGenerator().calculateFare(distance, time, false), 0.0);
	}

	@Test
	public void givenMultipleRidesForNormalRides_ShouldReturnTotalFare() {
		Ride[] rides = { new Ride(10, 15), new Ride(3, 8), new Ride(4, 10) };
		Assert.assertEquals(203, new CabInvoiceGenerator().calculateTotalAggregateFare(rides, true), 0.0);
	}

	@Test
	public void givenMultipleRidesForPremiumRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(7, 15), new Ride(2.3, 8), new Ride(0.8, 4) };
		Assert.assertEquals(new InvoiceSummary(3, 205.5), new CabInvoiceGenerator().getInvoiceSummary(rides, false));
	}

	@Test
	public void givenUserIDForNormalRide_ShouldReturnUserInvoiceSummary() {
		RideRepository[] repositoryList = {
				new RideRepository(1, new Ride[] { new Ride(4, 8), new Ride(1.1, 3), new Ride(10, 16) }),
				new RideRepository(2,
						new Ride[] { new Ride(2, 4), new Ride(2.3, 5), new Ride(5, 9), new Ride(11, 18) }),
				new RideRepository(3, new Ride[] { new Ride(8.5, 15), new Ride(6, 10), new Ride(0.8, 3) }) };
		InvoiceService invoiceService = new InvoiceService(Arrays.asList(repositoryList));
		InvoiceSummary invoiceSummary = invoiceService.getInvoice(2, true);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(4, 239);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

}
