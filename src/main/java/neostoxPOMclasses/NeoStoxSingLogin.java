package neostoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxSingLogin
	{
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement Mobnofild;
	
	@FindBy(id="lnk_signup1")private WebElement SingButton;

	public NeoStoxSingLogin(WebDriver driver)   //contructor
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendMobileNUm(WebDriver driver,String mobNum) throws InterruptedException
	{
		Mobnofild.sendKeys(mobNum);
		Thread.sleep(3000);
		Reporter.log("seending mobile number",true);
	}
	public void clickonSingButton(WebDriver driver)
	{
		SingButton.click();
		Reporter.log("clicking on singin button", true);
	}
}
