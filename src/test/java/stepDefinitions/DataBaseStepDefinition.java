package stepDefinitions;

import core.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DataBaseUtility;

public class DataBaseStepDefinition extends Base {

	@Given("^user connect to PostgreSql Databse$")
	public void user_connect_to_PostgreSql_Database() {
		DataBaseUtility.setupConnection();
		logger.info("connection is established between JDBC and DataBase");
	}
	
	@When("^user sends query '(.+)'$")
	public void user_sends_query(String query) {
		DataBaseUtility.runQuery(query);
		logger.info(query + ": has been executed ");
	}
	
	@Then ("^user should get all information from that table$")
	public void user_should_get_all_information_from_that_table() {
		DataBaseUtility.returnResult();
		logger.info("resultSet is stored in a CSV file in outcome folder");
		DataBaseUtility.closeDBConnection();
		logger.info("DataBase connection has been closed");
	}
	
	
	
	
	
	
	
	
	
}
