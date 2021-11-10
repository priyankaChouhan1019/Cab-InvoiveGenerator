package com.bdlz.invoiveGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    //testCase to calculate the Minimum Charges
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    //invoice generator for multiple rides
    @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    //testCase to return Invoice summary using userID
    @Test
    public void givenUserId_shouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String userId = "sunilgollapalli@gmail.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    //testCase to Normal rides and premium rides
    @Test
    public void givenUserIdAndRides_ShouldReturn_MultipleInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String userId = "sunilgollapalli@gmail.com";
        Ride[] rides = {new Ride(2.0, 5, InvoiceGenerator.RideMode.NORMAL), new Ride(0.1, 1, InvoiceGenerator.RideMode.NORMAL)};
        invoiceGenerator.addRides(userId, rides);
        Ride[] rides1 = {new Ride(2.0, 5, InvoiceGenerator.RideMode.PREMIUM), new Ride(0.1, 1, InvoiceGenerator.RideMode.PREMIUM)};
        invoiceGenerator.addRides(userId, rides1);
        Ride[] rides2 = {new Ride(2.0, 5, InvoiceGenerator.RideMode.NORMAL), new Ride(0.1, 1, InvoiceGenerator.RideMode.PREMIUM)};
        invoiceGenerator.addRides(userId, rides2);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(6, 125);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

}