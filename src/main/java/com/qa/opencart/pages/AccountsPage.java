package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementsUtility;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementsUtility eleUtil;
	
	private By acctPageHeaders = By.xpath("//div[@id='content']/h2");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtility(driver);
		
	}
	
	public String getAccountsPageTitle() {
		return eleUtil.waitForTitleContains("My Account", 10);
	}
	
	public int getAcctsPageHeaderCount() {
		return eleUtil.getElementsCount(acctPageHeaders);
	}
	
	public List<String> getAcctsPageHeaderTitle() {
		List<String> items = new ArrayList<String>();
		List<WebElement> acctHeaders = eleUtil.waitForElementsPresence(acctPageHeaders, 10);
		for(WebElement e : acctHeaders) {
			String text = e.getText();
			items.add(text);
		}
		return items;
	}

}
