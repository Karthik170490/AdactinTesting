package com.pageobjectmodel;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookingConfirmation extends BaseClass {
	
	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement orderNum;

	public void getOrderNum() {
		String bookingOrederNumber ="9H0CC9P1X8";
		jseScrollDown(orderNum);
		String originalOrderNum = getAttributeValue(orderNum, "value");
		System.out.println(originalOrderNum);
		if (originalOrderNum ==bookingOrederNumber) {
			System.out.println("Order number Matched");
		}
		else
		{
			System.out.println("Oedre Number Mismatched");
		}
		
	}
	
	

}
