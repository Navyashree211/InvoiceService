package com.BridgeLab.InvoiceServiceTest;

import org.junit.Assert;
import org.junit.Test;

import com.BridgeLab.InvoiceService.CabInvoiceGenerator;
import com.BridgeLab.InvoiceService.InvoiceSummary;
import com.BridgeLab.InvoiceService.Ride;

public class CabInvoiceGeneratorTest {  
	 @Test
	    public void givenDistanceAndTime_IfFareGreaterThanMinimumFare_ShouldReturnTotalFare() {
	        double distance = 10;
	        int time = 12;
	        Assert.assertEquals(112, new CabInvoiceGenerator().calculateFare(distance, time), 0.0);
	    }

	    @Test
	    public void givenDistanceAndTime_IfFareLessThanMinimumFare_ShouldReturnMinimumFare() {
	        double distance = 0.1;
	        int time = 1;
	        Assert.assertEquals(5, new CabInvoiceGenerator().calculateFare(distance, time), 0.0);
	    }

	    @Test
	    public void givenMultipleRides_ShouldReturnTotalFare() {
	        Ride[] rides = { new Ride(10, 15), new Ride(3, 8), new Ride(4, 10) };
	        Assert.assertEquals(203, new CabInvoiceGenerator().calculateTotalAggregateFare(rides), 0.0);
	    }

	    @Test
	    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
	        Ride[] rides = {
	                new Ride(7, 15),
	                new Ride(2.3, 8),
	                new Ride(0.8, 4)
	        };
	        Assert.assertEquals(new InvoiceSummary(3,  128), new CabInvoiceGenerator().getInvoiceSummary(rides));
	    }


}
