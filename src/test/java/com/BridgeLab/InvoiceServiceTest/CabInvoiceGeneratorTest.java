package com.BridgeLab.InvoiceServiceTest;

import org.junit.Assert;
import org.junit.Test;

import com.BridgeLab.InvoiceService.CabInvoiceGenerator;
import com.BridgeLab.InvoiceService.Ride;

public class CabInvoiceGeneratorTest {  
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        int distance = 10, time = 12;
        Assert.assertEquals(112, new CabInvoiceGenerator().calculateFare(distance, time));
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = { new Ride(10, 15), new Ride(3, 8), new Ride(4, 10) };
        Assert.assertEquals(203, new CabInvoiceGenerator().calculateTotalAggregateFare(rides));
    }


}
