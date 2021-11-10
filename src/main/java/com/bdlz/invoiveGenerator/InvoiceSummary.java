package com.bdlz.invoiveGenerator;

public class InvoiceSummary {
    public final double averageFarePerRide;
    public final int numberOfRides;
    public final double totalFare;
    //parameterized constructor
    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = this.totalFare / this.numberOfRides;
    }
    /*
    method overridden
    created an Object and used equals method
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return numberOfRides == summary.numberOfRides && Double.compare(summary.totalFare, totalFare) == 0 &&
                Double.compare(summary.averageFarePerRide, averageFarePerRide) == 0;

    }
}
