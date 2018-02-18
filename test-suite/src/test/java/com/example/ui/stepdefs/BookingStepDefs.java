package com.example.ui.stepdefs;

import org.junit.Assert;

import com.example.ScenarioContext;
import com.example.ui.tasks.BookingTasks;
import com.google.inject.Inject;

import cucumber.api.java.en.Then;

public class BookingStepDefs {

    private final ScenarioContext scenarioContext;
    private final BookingTasks bookingTasks;

    @Inject
    public BookingStepDefs(ScenarioContext scenarioContext, BookingTasks bookingTasks) {
        this.scenarioContext = scenarioContext;
        this.bookingTasks = bookingTasks;
    }

    @Then("^i should see the booking details$")
    public void i_should_see_the_booking_details() {
        Assert.assertTrue("Booking details are not present.",
                bookingTasks.getFirstBookingDetails().contains("Booking ID"));
    }

}
