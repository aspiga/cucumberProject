package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;


import pages.AutoheroSearchPage;
import utils.WebDriverSupport;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Auto1TestSteps {
	
	WebDriver driver;
	WebDriverSupport support;
	AutoheroSearchPage searchPage;
	 int [] registrationYears;
	
	@Given("I am in the autohero web page")
	public void i_am_in_the_autohero_web_page() {
		support = new WebDriverSupport(driver);
	    driver = support.getBrowser("Chrome");
		driver.manage().window().maximize();
		searchPage = AutoheroSearchPage.navigateTo(driver);
	    
	}
	

	
	@When("I select a registration year as {string} a filter criteria as {string}")
	public void i_select_a_registration_year_as_a_filter_criteria_as(String year, String filter) {
		 searchPage.getSortedCarsList(year, filter);
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("all the cars displayed comes from the correct year")
	public void all_the_cars_displayed_comes_from_the_correct_year() {
		registrationYears = searchPage.getRegistrationYears();
		 assertTrue(verifyRegistrationDate(registrationYears));
	}
	
	@Then("all the cars are displayed using a descendent price order")
	public void all_the_cars_are_displayed_using_a_descendent_price_order() {
		int[] carPrices = searchPage.getCarsPrices();
		assertTrue(verifyPricesSort(carPrices));
	}
	
	
	private boolean verifyRegistrationDate(int[] registrationYears) {
		boolean success = true;
		for (int i = 0; i < registrationYears.length ; i++) {

			if (registrationYears[i]<2015) {
				success = false;
				return success;
			}
			}
			
		return success;
	}
	
	private boolean verifyPricesSort(int[] carPrices) {
		boolean success = true;
		
		for (int i=1; i<carPrices.length; i++) {
			if (carPrices[i]>carPrices[i-1]){
				success = false;
				return success;
			}	
		}
		return success;
	}

}
