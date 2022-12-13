package neostoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


import neoStoxUtility.UtilityNew;

public class NeoStoxHomePage
	{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton; 
	
	   @FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	   
	   @FindBy(id = "lbl_username") private WebElement userName;
	   
	   @FindBy(id="lbl_curbalancetop") private WebElement balance;
	   
	   @FindBy(xpath = "//span[text()='Logout']") private WebElement logoutButton; 
	 
	   public NeoStoxHomePage(WebDriver driver)  
	   {
		   PageFactory.initElements(driver, this);
		   }
	   public void popUpHandle(WebDriver driver)  
	   {
		   UtilityNew.wait(driver, 2000);
		   okButton.click(); 
		   UtilityNew.scrollIntoView(driver, closeButton); 
		   UtilityNew.wait(driver, 2000);
		   closeButton.click(); 
		   UtilityNew.wait(driver, 2000);

		   Reporter.log("Handeling popup..",true);
		   }
	   public String getUserName() 
	   {
		   String actualUserName = userName.getText();  
		   Reporter.log("getting user Name",true);
		   return actualUserName;
		   } 
	   
	   public String getBalance(WebDriver driver)  
	   {
		   UtilityNew.wait(driver, 2000);
		   String actualBalance = balance.getText();
		   Reporter.log("getting actual balance",true);
		   return actualBalance;
		   }
	   public void logoutFormNeoStox(WebDriver driver)
	   {
		   UtilityNew.wait(driver, 2000);
		   userName.click();
		   UtilityNew.wait(driver, 2000);  
		   logoutButton.click();
		   Reporter.log("Loggoing out from neoStox",true);  

}
}