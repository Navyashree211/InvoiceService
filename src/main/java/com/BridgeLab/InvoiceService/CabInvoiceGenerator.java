package com.BridgeLab.InvoiceService;

public class CabInvoiceGenerator {
	public final double COST_PER_KILOMETER = 10;
	private final int COST_PER_MINUTE = 1;
	private final int MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	public double calculateTotalAggregateFare(Ride[] rides) {
		double totalAggregateFare = 0;
		for (Ride ride : rides)
			totalAggregateFare += calculateFare(ride.distance, ride.time);
		return totalAggregateFare;
	}

	public InvoiceSummary getInvoiceSummary(Ride[] rides) {
		double totalFare = calculateTotalAggregateFare(rides);
		return new InvoiceSummary(rides.length, totalFare);
	}
}
