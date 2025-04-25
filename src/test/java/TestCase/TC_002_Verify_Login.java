package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Object.DeepHomePage;
import Page_Object.LoginPage;
import TestBase.BaseClass;

public class TC_002_Verify_Login extends BaseClass
{

	
	@Test(dataProvider = "LoginData",dataProviderClass = Utilities.DataProvider.class,groups = {"regression","master"})
	public void verifyLog(String Username,String Password,String Result)
	{
		logs.info("TC_002_Verify_Login is started Executing");
		logs.info("Creating LoginPage Object");
		LoginPage lp = new LoginPage(driv, waits);
		
		logs.info("Validating Logins from Excel File");
		lp.putUser(Username);
		lp.putPass(Password);
		lp.clickBtn();
		
		logs.info("Looking for Authentication ");
		lp.Handleauthcode();
		
		logs.info("Creating DeepPage Methods");
		 // Deep Home Page Object
        DeepHomePage dhp = new DeepHomePage(driv, waits);
        
       // String welmes=dhp.Welcomemessage();
        boolean weltrue=dhp.ValidateWelcomemessage();
        
        logs.info("Running Our validation");
        
        if(Result.equalsIgnoreCase("Valid"))
        {
        	if(weltrue==true)
        	{
        		dhp.logout();
        		Assert.assertTrue(true);
        	}
        	else
        	{
        		Assert.assertTrue(false);
        	}
        	
        }
        
        if(Result.equalsIgnoreCase("Invalid"))
        {
        	if(weltrue==true)
        	{
        		dhp.logout();
        		Assert.assertTrue(false);
        	}
        	else
        	{
        		Assert.assertTrue(true);
        	}
        }

        logs.info("Execution Completed");
       
	}
	
}
