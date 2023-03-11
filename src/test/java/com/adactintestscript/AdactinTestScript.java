package com.adactintestscript;

import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageobjectmodel.BookHotel;
import com.pageobjectmodel.BookingConfirmation;
import com.pageobjectmodel.Login;
import com.pageobjectmodel.SearchHotel;
import com.pageobjectmodel.SelectHotel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;

public class AdactinTestScript extends BaseClass {

	@Test // login
	public void tc001() throws IOException, InterruptedException {
		Thread.sleep(3000);
		Login login = new Login();
		String unameData = excelRead("TestData", "data", 0, 0);
		login.getUsrName(unameData);
		Thread.sleep(3000);
		String passData = excelRead("TestData", "data", 1, 0);
		login.getPwd(passData);
		login.getLogin();

	}

	@Test // serachHotel
	public void tc002() throws InterruptedException {
		//Thread.sleep(6000);
		imcWait();
		SearchHotel srcHotels = new SearchHotel();
		selectValue(srcHotels.getLocation(), "Sydney");
		srcHotels.getHotel();
		selectIndex(srcHotels.getRoom(), 1);
		selectValue(srcHotels.getRoomNos(), "2");
		inputText(srcHotels.getCheckIn(), "22/02/2023");
		inputText(srcHotels.getCheckOut(), "20/02/2023");
		selectIndex(srcHotels.getAdultRoom(), 2);
		selectIndex(srcHotels.getChildRoom(), 2);
		buttonClick(srcHotels.getSubmitBtn());

	}
	
	@Test //selectHotel
	public void tc003() {
		SelectHotel selHotel = new SelectHotel();
		selHotel.getSelHotel();
		selHotel.getContiBtn();

	}
	@Test
	private void tc004() throws InterruptedException {
		BookHotel bh= new BookHotel();
		bh.getfName("Karthik");
		bh.getlName("K");
		bh.getBillAddress("India");
		bh.getCcNum("1234567890123456");
		bh.getCcType();
		bh.getCcExpM();
		bh.getCcExpY();
		Thread.sleep(1000);
		bh.getCcCVV();
		bh.getBooknowBtn();
		//Thread.sleep(6000);
		imcWait();

	}
	@Test
	private void tc005() {
		
		BookingConfirmation bc= new BookingConfirmation();
		bc.getOrderNum();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@BeforeClass
	public void browserLaunch() throws InterruptedException {
		chromeBrowserLaunch();
		launchURL("http://adactinhotelapp.com/HotelAppBuild2/");
        Thread.sleep(3000);
        System.out.println("Browser Launched");
	}

//  @AfterClass
//  public void browserClose() throws InterruptedException {
//	  Thread.sleep(5000);
//	  closeBrowser();
//  }

}
