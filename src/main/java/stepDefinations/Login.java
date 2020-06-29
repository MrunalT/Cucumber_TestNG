package stepDefinations;

import io.cucumber.java.en.*;

public class Login {

	@Given("application get launched")
	public void application_get_launched() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("application get launched");
	}

	@When("validate home page logo")
	public void validate_home_page_logo() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("validated home page logo");
	}

	@Then("user clicks login button")
	public void user_clicks_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("user clicked login button");
	}

	@Then("user enter username and password")
	public void user_enter_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user entered username and password");
	}

}
