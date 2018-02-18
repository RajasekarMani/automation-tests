package com.example.ui.tasks;

import com.example.ui.pages.HomePage;
import com.google.inject.Inject;

public class BookingTasks extends DefaultTasks {
    
    private final HomePage homePage;

    @Inject
    public BookingTasks(HomePage homePage) {
        this.homePage = homePage;
    }
    
    public String getFirstBookingDetails(){
        waitUntilPageLoaded();
        homePage.getBookingDetailElements(homePage.bookingList.first());
        return "";
    }
    
}