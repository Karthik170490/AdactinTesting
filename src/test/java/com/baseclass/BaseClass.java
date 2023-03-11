package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
    public static Actions ac;
	public static JavascriptExecutor js;

	public static void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	public static void fireFoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	public static void launchURL(String url) {
		driver.get(url);
	}

	public static void inputText(WebElement refName, String text) {
		
		//refName.clear();
		refName.sendKeys(text);
	}

	public static void buttonClick(WebElement refName) {

	if(refName.isEnabled() && refName.isDisplayed())
	{
		visibilityExpliWait(refName);
		elementClickExpliWait(refName);
		refName.click();
	}
	else
	{
		System.out.println("Button is not enabled");
	}
		
	}

	public static void currentPageTitle() {
		driver.getTitle();
	}

	public static void currentPageURL() {
		driver.getCurrentUrl();

	}

	public static void closeCurrentPage() {
		driver.close();

	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void getExistText(WebElement refName) {
		String webPageText = refName.getText();
		System.out.println("Text is"+webPageText);

	}
	
	
	//public static void getAttributeValue(WebElement refName, String text) {
		//String attributeValue = refName.getAttribute(text);
		//System.out.println(attributeValue);

	//}

	public static String getAttributeValue(WebElement refName, String text) {
		String attributeValue = refName.getAttribute(text);
		//
		System.out.println(attributeValue);
		return attributeValue;

	}

	public static void imcWait() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public static void alertExpliWait() {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void visibilityExpliWait(WebElement refName) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(refName));
	}
	
	public static void elementClickExpliWait(WebElement refName) {
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(refName));
	}
	
	public static void fluentExpliWait() {
		FluentWait<WebDriver> fWait= new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(Exception.class);
	}


	public static void rightClick(WebElement refName) {
		Actions ac = new Actions(driver);
		ac.contextClick(refName).perform();

	}
	public static void doubleClick(WebElement refName) {
		ac = new Actions(driver);
		ac.doubleClick(refName).build().perform();

	}
	public static void dragDrop(WebElement src, WebElement Trg) {
		ac = new Actions(driver);
		ac.dragAndDrop(src, Trg).perform();

	}
	
	public static void mouseOver(WebElement refName) {
		ac = new Actions(driver);
		ac.moveToElement(refName).perform();

	}
	
	public static void acceptAlert() {
		driver.switchTo().alert().accept();

	}
	
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}
	public static void inputTextAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();

	}
	
	public static void getTextAlert(String text) {
		Alert alert = driver.switchTo().alert();
		String altText = alert.getText();
		System.out.println(altText);
		alert.accept();

	}
	

	public static void selectValue(WebElement refName, String text) {
		Select s = new Select(refName);
		s.selectByValue(text);

	}

	public static void selectVisualText(WebElement refName, String text) {
		Select s = new Select(refName);
		s.selectByVisibleText(text);

	}

	public static void selectIndex(WebElement refName, int value) {
		Select s = new Select(refName);
		s.selectByIndex(value);

	}

	public static void selectMultiple(WebElement refName) {
		Select s = new Select(refName);
		boolean mul = s.isMultiple();
		System.out.println(mul);

	}

	public static void jseSendKeys(String text, WebElement refName ) {
		 js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '"+text+"')", refName);
	}
	public static void jseClick(WebElement refName) {
		 js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", refName);
		
	}
	
	public static void jseGetAttribute(WebElement refName) {
		 js = (JavascriptExecutor) driver;
		Object getAttributeValue = js.executeScript("return arguments[0].getAttribute('value')", refName);
		System.out.println(getAttributeValue);
	}
	
	public static void jseScrollUp(WebElement refName) {
		 js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", refName);
	}
	public static void jseScrollDown(WebElement refName) {
		 js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", refName);
	}
	
	public static void idFrame(String id) {
		driver.switchTo().frame(id);

	}
	public static void nameFrame(String name) {
		driver.switchTo().frame(name);

	}
	public static void elementFrame(WebElement refName) {
		driver.switchTo().frame(refName);

	}
	public static void indexFrame(int value) {
		driver.switchTo().frame(value);

	}
	public static void getOutFrame() {
		driver.switchTo().defaultContent();

	}
	public static void moveparentFrame() {
		driver.switchTo().parentFrame();

	}
	
	public static String excelRead(String FileName, String SheetName, int RowNum, int CellNum ) throws IOException {
		File f = new File("E:\\KK\\Automation_WS\\Adactin\\src\\test\\resources\\Excel\\"+FileName+".xlsx");
		  FileInputStream fis= new FileInputStream(f);
		  Workbook wb = new XSSFWorkbook(fis);
		  Sheet s = wb.getSheet(SheetName);
		  Row r = s.getRow(RowNum);
		  Cell c = r.getCell(CellNum);
		  CellType cellType = c.getCellType();
		  String value="";
		  switch (cellType) {
		case STRING:
			value = c.getRichStringCellValue().getString();
			System.out.println(value);
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
				value= sdf.format(dateCellValue);
				System.out.println(value);
				
			} else {
				double numericCellValue = c.getNumericCellValue();
				long l= (long)numericCellValue;
				value = String.valueOf(l);
				System.out.println(value);

			}
		  }
           return value;
            
		
		}
		  

	}

	