package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SelectHotel extends BaseClass{
public SelectHotel() {
	PageFactory.initElements(driver, this);
	
}

@FindBy(id="radiobutton_0")
private WebElement selHotel;
@FindBy(id="continue")
private WebElement contiBtn;

public void getSelHotel() {
	buttonClick(selHotel);
	
}
public void getContiBtn() {
	buttonClick(contiBtn);
}


}
