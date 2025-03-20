package com.qa.opencart.parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	
	@Given("I have a Search field in Amazon")
	public void i_have_a_search_field_in_amazon() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Search fied visible on Amazon");
	}

	@When("I search for a product {string} and Price {int}")
	public void i_search_for_a_product_and_price(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User Searches for product and price");
	}

	@Then("Product with {string} should be displayed")
	public void product_with_should_be_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User Successfully Searched Product");
	}


}
