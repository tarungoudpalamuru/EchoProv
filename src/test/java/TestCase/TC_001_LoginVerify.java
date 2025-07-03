package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Object.DeepHomePage;
import Page_Object.LoginPage;
import TestBase.BaseClass;

public class TC_001_LoginVerify extends BaseClass
{
	
	
	@Test(groups = {"sanity","master"})
	public void verify()
	{
		System.out.println("✅ launchpad() executed");
		logs.info("**[start]Starting the TestCase TC_001_LoginVerify ***");
		LoginPage lp = new LoginPage(driv, waits);
		logs.info("** [info]Intializing the LoginPage ***");
		lp.putUser(p.getProperty("usname"));  //getting username from propertiy file
		lp.putPass(p.getProperty("passwo"));   //getting password from propertiy file
		lp.clickBtn();
		
		 if (lp.isAuthCodeVisible())
	        {
	            logs.info("🔐 AuthCode field appeared. Entering OTP...");
	            lp.Handleauthcode();
	        } 
	        else 
	        {
	            logs.info("✅ No AuthCode field. Proceeding without OTP...");
	        }
		
		logs.info("**[Info]Succesfully Entered credintials and clicked on login button***");
		
		DeepHomePage dh= new DeepHomePage(driv, waits);
		String welcomeMessage= dh.Welcomemessage();
		
		
		if(welcomeMessage.toLowerCase().contains("welcome"))
		{
			logs.info("**[INFO]Searching for Welcome message***");
			dh.logout();
			logs.info("**[Pass]Succesfully Logged out ***");
			Assert.assertTrue(true);
			
		}
		else
		{
			dh.logout();
			logs.error("**[FAIL]  Unable to Login***");
			Assert.fail("[FAIL] Welcome Message Not Found after login");
		}
		
		
		
	}
	
	
	
	
}
