package com.BridgeLab.InvoiceService;

import java.util.List;

public class InvoiceService {   
	 private List<RideRepository> rideRepository;

	    public InvoiceService(List<RideRepository> rideRepository) {
	        this.rideRepository = rideRepository;
	    }

	    public InvoiceSummary getInvoice(int userID, boolean normalRide) {
	        InvoiceSummary invoiceSummary = null;
	        for (RideRepository userRides : rideRepository) {
	            if (userRides.userID == userID) {
	                invoiceSummary = new CabInvoiceGenerator().getInvoiceSummary(userRides.rides, normalRide);
	            }
	        }
	        return invoiceSummary;
	    }

}
