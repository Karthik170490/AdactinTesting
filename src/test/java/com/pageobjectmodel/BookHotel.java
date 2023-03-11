package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookHotel extends BaseClass {
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement fName;
	@FindBy(id="last_name")
	private WebElement lName;
	@FindBy(id="address")
	private WebElement billAddress;
	@FindBy(id="cc_num")
	private WebElement ccNum;
	@FindBy(id="cc_type")
	private WebElement ccType;
	@FindBy(id="cc_exp_month")
	private WebElement ccExpM;
	@FindBy(id="cc_exp_year")
	private WebElement ccExpY;
	@FindBy(id="cc_cvv")
	private WebElement ccCVV;
	@FindBy(id="book_now")
	private WebElement booknowBtn;
	
	public void getfName(String firstname) {
		inputText(fName, firstname);
	}
	public void getlName(String lastname) {
		inputText(lName, lastname);
	}
	public void getBillAddress(String add) {
		inputText(billAddress, add);
	}
	public void getCcNum(String cardnum) {
		inputText(ccNum, cardnum);
	}
	
	public void getCcType() {
		selectValue(ccType, "MAST");
	}
	public void getCcExpM() {
		selectValue(ccExpM, "1");
	}
	public void getCcExpY() {
		selectIndex(ccExpY, 2);
	}
	public void getCcCVV() {
		inputText(ccCVV, "123");
	}
	public void getBooknowBtn() {
		buttonClick(booknowBtn);
	}
	

}
