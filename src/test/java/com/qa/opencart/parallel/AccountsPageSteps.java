package com.qa.opencart.parallel;

import java.util.List;
import java.util.Map;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage acctPage;
	
	@Given("User has already logged into the OpenCart site")
	public void user_has_already_logged_into_the_open_cart_site(DataTable credTable) {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		List<Map<String, String>> credData = credTable.asMaps();
		String uname = credData.get(0).get("Username");
		String upass = credData.get(0).get("Password");
		acctPage = loginPage.doLogin(uname, upass);
	}

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
	    String acctPageTitle = acctPage.getAccountsPageTitle();
	    Assert.assertEquals(acctPageTitle, "My Account");
	}

	@When("user get the accounts page header")
	public void user_get_the_accounts_page_header() {
		List<String> actualHeaders = acctPage.getAcctsPageHeaderTitle();
	    System.out.println("Actual accounts section list: " + actualHeaders);
	}

	@Then("accounts page headers are displayed")
	public void accounts_page_headers_are_displayed(DataTable sectionsTable) {
		List<String> expectedHeaders = sectionsTable.asList();
		System.out.println("Expected accounts section list: " + expectedHeaders);
		List<String> actualHeaders = acctPage.getAcctsPageHeaderTitle();
	    System.out.println("Actual accounts section list: " + actualHeaders);
	    Assert.assertTrue(actualHeaders.containsAll(expectedHeaders));
	}

	@Then("account page headers are {int}")
	public void account_page_headers_are(Integer headersCount) {
	    Assert.assertEquals(acctPage.getAcctsPageHeaderCount(),4);
	}

}
