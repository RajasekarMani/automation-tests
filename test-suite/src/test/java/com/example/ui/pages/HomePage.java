package com.example.ui.pages;

import org.openqa.selenium.By;

import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;

public class HomePage {

    @FindByKey("home-page.profile-icon")
    public PageElement profileIcon;
    
    @FindByKey("home-page.booking-list")
    public PageElementCollection bookingList;
    
    public PageElement getHotelDetail(PageElement pageElement){
        return pageElement.all(By.cssSelector("div[class*='col-md-5']")).first();
    }

    public PageElementCollection getBookingDetailElements(PageElement pageElement){
        return pageElement.all(By.cssSelector("div[class='col-md-3'] > span"));
    }
    
}
