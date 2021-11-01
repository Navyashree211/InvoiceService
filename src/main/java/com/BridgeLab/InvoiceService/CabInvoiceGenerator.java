package com.BridgeLab.InvoiceService;

public class CabInvoiceGenerator {
	public final double NORMAL_COST_PER_KILOMETER = 10;
	private final int NORMAL_COST_PER_MINUTE = 1;
	private final int NORMAL_MINIMUM_FARE = 5;

	public final double PREMIUM_COST_PER_KILOMETER = 15;
	private final int PREMIUM_COST_PER_MINUTE = 2;
	private final int PREMIUM_MINIMUM_FARE = 20;

	public double calculateFare(double distance, int time, boolean normalRide) {
		if (normalRide) {
			double totalFare = distance * NORMAL_COST_PER_KILOMETER + time * NORMAL_COST_PER_MINUTE;
			return Math.max(totalFare, NORMAL_MINIMUM_FARE);
		} else {
			double totalFare = distance * PREMIUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_MINUTE;
			return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
		}
	}

	public double calculateTotalAggregateFare(Ride[] rides, boolean normalRide) {
		double totalAggregateFare = 0;
		for (Ride ride : rides)
			totalAggregateFare += calculateFare(ride.distance, ride.time, normalRide);
		return totalAggregateFare;
	}

	public InvoiceSummary getInvoiceSummary(Ride[] rides, boolean normalRide) {
		double totalFare = calculateTotalAggregateFare(rides, normalRide);
		return new InvoiceSummary(rides.length, totalFare);
	}
}