package neoStoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBase.BaseNew;

import neoStoxUtility.UtilityNew;
import neostoxPOMclasses.NeoStoxHomePage;
import neostoxPOMclasses.NeoStoxPasswordPage;
import neostoxPOMclasses.NeoStoxSingLogin;

@Listeners(neoStoxUtility.Listener.class)
	public class ValidateNewProperties extends BaseNew
	{
		NeoStoxSingLogin login; 
		NeoStoxPasswordPage password;
		NeoStoxHomePage home; 
		
		@BeforeClass
		public void launchNeoStox() throws IOException 
		{
			launchBrowser();  
			
			login= new NeoStoxSingLogin(driver); 
			password = new NeoStoxPasswordPage(driver);
			home= new NeoStoxHomePage(driver);
			}
		@BeforeMethod 
		public void loginToNeoStox() throws EncryptedDocumentException, InterruptedException, IOException 
		 {
			login.sendMobileNUm(driver, UtilityNew.readDataFromPropertyFile("MobNum"));
			Thread.sleep(2000);
			login.clickonSingButton(driver);
			Thread.sleep(3000);
			password.sendPassword(driver, UtilityNew.readDataFromPropertyFile("password")); 
			Thread.sleep(3000);
			password.clickOnSubmitButton(driver);
			Thread.sleep(3000);
			home.popUpHandle(driver);
			}
		@Test 
		public void validateUserName() throws EncryptedDocumentException, IOException, InterruptedException 
		{
			Assert.assertEquals(home.getUserName(), UtilityNew.readDataFromPropertyFile("userName"),"TC failed, actual and expected User Names are not matching"); 
			Thread.sleep(3000);
			
			}                                                               
		   @AfterMethod  
		   public void logout()  
		   {
			   home.logoutFormNeoStox(driver);
			   } 
		   @AfterClass
		   public void closeApplication() throws InterruptedException 
		   {
			   
		  closingBrowser(driver);  
	 
  
  }
}
