package com.BridgeLab.InvoiceService;

public class InvoiceSummary {   
    private int numberOfRides;
    private double totalFare;
    private double averageFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.numberOfRides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        InvoiceSummary other = (InvoiceSummary) obj;
        if(other.numberOfRides == this.numberOfRides && this.totalFare == other.totalFare && this.averageFare == other.averageFare) return true;
        else return false;
    }
 
}
