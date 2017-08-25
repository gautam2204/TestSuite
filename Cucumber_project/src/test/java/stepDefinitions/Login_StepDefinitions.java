package stepDefinitions;

import java.sql.Driver;
import java.util.Set;

import org.openqa.selenium.WebElement;

import page.Login_Page;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_StepDefinitions {

	Login_Page login = new Login_Page();

	@Given("^I am on login page for signIn using \"(.*?)\"$")
	public void i_am_on_login_page_for_signIn(String url) throws Throwable {
		login.verify_Sign_In_PageLoad(url);
	}

	@When("^I enter my login credentials \"(.*?)\" and \"(.*?)\"$")
	public void i_enter_my_login_credentials_and(String username,
			String password) throws Throwable {
		login.clickSignIn();
		login.enter_EmailID(username);
		login.clickNext();
		login.enter_Password(password);
		login.clickNext();
	}

	@Then("^I will see my homepage$")
	public void i_will_see_my_homepage() throws Throwable {
		login.verify_title();
	}

	@When("^I am authenticating with a wrong userid$")
	public void i_am_authenticating_with_a_wrong_userid() throws Throwable {
		login.clickSignIn();
		login.enter_EmailID("112");
		login.clickNext();
	}

	@Then("^i should be displayed with the error message$")
	public void i_should_be_displayed_with_the_error_message() throws Throwable {
		login.error_message_display_wron_userId();
	}
	
	@When("^I enter my login credentials$")
	public void i_enter_my_login_credentials(DataTable table) throws Throwable {
		login.clickSignIn();
	    login.enter_userID_credential_using_dataTable(table);
	    login.clickNext();
	    login.enter_password_credential_using_dataTable(table);
	    login.clickNext();
	}
	
	@When("^I get all the links on the page$")
	public void i_get_all_the_links_on_the_page() throws Throwable {
	    login.getallLinks();
	}


}
