package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class Login extends BaseClass{
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement usrName;
	@FindBy(id="password")
	private WebElement pwd;
	@FindBy(id="login")
	private WebElement login;
	
	
	public void getUsrName(String userName) {
		inputText(usrName, userName);
	}
	public void getPwd(String pass) {
		inputText(pwd, pass);
		
	}
	public void getLogin() {
		buttonClick(login);
	}
	

}
