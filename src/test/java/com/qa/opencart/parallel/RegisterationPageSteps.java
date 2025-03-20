package com.qa.opencart.parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class RegisterationPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private RegistrationPage registerPage;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@When("User clicks on Register link")
	public void user_clicks_on_register_link() {
		registerPage = loginPage.selectRegistrationLink();
	}

	@Then("User is navigated to Register page")
	public void user_is_navigated_to_register_page() {
	    // Write code here that turns the phrase above into concrete actions
	    String regTitle = registerPage.getRegistrationPageTitle();
	    Assert.assertEquals(regTitle, "Register Account");
	}


	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("./src/test/resources/testdata/OpenCartData.xlsx", sheetName);
		
		String firstName = testData.get(rowNumber).get("FirstName");
		String lastName = testData.get(rowNumber).get("LastName");
		String email = "firstname.lastname" + System.currentTimeMillis()+"@gmail.com";
		String telephone = testData.get(rowNumber).get("Telephone");
		String password = testData.get(rowNumber).get("Password");
		String confirmPassword = testData.get(rowNumber).get("ConfirmPassword");
		String subscribe = testData.get(rowNumber).get("Subscribe");
		String news = testData.get(rowNumber).get("News");
		
		registerPage.doUserRegistration(firstName, lastName, email, telephone, password, confirmPassword, subscribe, news);
		
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String string) {
		
		System.out.println("PASS:");
	}


}
