package utils;

import org.openqa.selenium.WebElement;

public class CommonFun {

	public void enterVal(WebElement element, String value, String objectName, Boolean mask) throws Exception
	{
		element.clear();
		element.sendKeys(value);
		if(mask)
		{
			value = maskString(value);
		}
//		String path = getScreenShot();
//		reports.log(Status.PASS, value+" is entered in "+objectName,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}



	/*public void selectValFromDrpdwn(WebElement element, String visibleText, String objectName)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Reporter.log("<br><b>"+visibleText+"</b> is selected in <b>"+objectName+"</b></br>");
	}*/

	public String maskString(String val)
	{
		String maskedString = "";
		for(int i = 0; i < val.length() ;i++ )
		{
			maskedString = maskedString+("*");
		}

		return maskedString;

	}
	
	public void click(WebElement element, String objectName) throws Exception
	{
		element.click();
		
//		String path = getScreenShot();
//		reports.log(Status.PASS, "Clicked on "+objectName, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	public void assertEqual(String expeString, String actString, String objectName) throws Exception
	{
//		String path = getScreenShot();
		if(actString.contains(expeString))
		{
//		reports.log(Status.PASS, objectName+"is matched. Verification value: "+actString, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		else
		{
//			reports.log(Status.FAIL, objectName+"is mismatched. Expected value: "+expeString+", Actual Value"+actString, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}	
	}
}
