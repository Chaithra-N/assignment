package com.interview.searchtext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTermPage {

	public FindTermPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="text1")
	private WebElement searchTerm;
	
	@FindBy(id="text2")
	private WebElement searchContent;
	
	@FindBy(xpath="//button[contains(text(),'Find')]")
	private WebElement find;

	public WebElement getSearchTerm() {
		return searchTerm;
	}

	public WebElement getSearchContent() {
		return searchContent;
	}

	public WebElement getFind() {
		return find;
	}
	public void setSearch(String search) {
		searchTerm.sendKeys(search);
	}
	
	public void setContent(String content) {
		searchTerm.sendKeys(content);
	}
}
