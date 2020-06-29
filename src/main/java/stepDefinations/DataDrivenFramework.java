package stepDefinations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExcelReader;

public class DataDrivenFramework {
	public WebDriver driver;
	public static List<HashMap<String,String>> datamap;

	public static void main(String[] args)
	{
		try {
			ExcelReader.setExcelFile(System.getProperty("user.dir")+"//src//test//java//Default.xlsx","Sheet1");
			
			datamap = ExcelReader.getExcelData("Data driven with excel",
					System.getProperty("user.dir")+"//src//test//java//Default.xlsx","Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	

	public DataDrivenFramework()
	{

		//       driver = Hooks.driver;
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
//		driver = new ChromeDriver();
		//       datamap = ExcelReader.data(System.getProperty("user.dir")+"//src//test//java//Default.xlsx","Sheet1");
		//       System.out.println("message" + datamap);

		
	}
	@Before
	public void beforeHook(Scenario scenario) {
	   String ScenarioName = scenario.getName();
	   System.out.println("Scenarioo Name"+ScenarioName);
	    
	    try {
			ExcelReader.setExcelFile(System.getProperty("user.dir")+"//src//test//java//Default.xlsx","Sheet1");

			datamap = ExcelReader.getExcelData(ScenarioName,
					System.getProperty("user.dir")+"//src//test//java//Default.xlsx","Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data map"+datamap);
	}

	@When("^I open automationpractice website$")
	public void i_open_automationpractice_website() throws Throwable {
//		driver.get("http://automationpractice.com");
	}


	@And("^click contact us$")
	public void click_contact_us() throws Throwable {
//		driver.findElement(By.linkText("Contact us")).click();
	}



	@Then("^I contact the customer service with excel row \"(.*?)\" dataset$")
	public void i_contact_the_customer_service_with_excel_row_dataset(String arg1) throws Throwable {
		int index = Integer.parseInt(arg1)-1;
		System.out.println("inside function "+datamap);
		System.out.println("Printing current data set...");
		
		        for(HashMap<String, String> h:datamap)
		        {
		            System.out.println(h.keySet());
		            System.out.println(h.values());
		        }

//		System.out.println(datamap.get(index).get("heading"));
//		System.out.println(datamap.get(index).get("email"));
//		System.out.println(datamap.get(index).get("order_reference"));
//		System.out.println(datamap.get(index).get("message"));
		//        Select subjectHeading = new Select(driver.findElement(By.id("id_contact")));
		//        subjectHeading.selectByVisibleText(datamap.get(index).get("heading"));
		//        driver.findElement(By.id("email")).sendKeys(datamap.get(index).get("email"));
		//        driver.findElement(By.id("id_order")).sendKeys(datamap.get(index).get("order_reference"));
		//        driver.findElement(By.id("message")).sendKeys(datamap.get(index).get("message"));
		//        driver.findElement(By.id("submitMessage")).sendKeys(datamap.get(index).get("message"));
	}
}