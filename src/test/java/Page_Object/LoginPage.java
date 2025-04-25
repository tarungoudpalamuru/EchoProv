package Page_Object;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import TestBase.BasePage;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driv, WebDriverWait waits) 
	{
		super(driv, waits);
		
		
	}

	@FindBy(xpath="//input[@id='MainContent_LoginUser_UserName']")
	WebElement usern;
	
	@FindBy(xpath="//input[@id='MainContent_LoginUser_Password']")
	WebElement passw;
	
	@FindBy(xpath="//input[@id='MainContent_LoginUser_LoginButton']")
	WebElement loginbtn;
	
	@FindBy(xpath="//input[@id='MainContent_txtAuthCode']")
	WebElement verificationcode;
	
	@FindBy(xpath="//input[@id='MainContent_btnCodeSubmit']")
	WebElement submitbtn;
	
	
	public  void putUser(String username)
	{
		usern.clear();
		usern.sendKeys(username);
	}
	
	public void putPass(String password)
	{
		passw.clear();
		passw.sendKeys(password);
		
	}
	
	public void Handleauthcode()
	{
		try
		{
			WebDriverWait waits = new WebDriverWait(driv, Duration.ofSeconds(10));
			waits.until(ExpectedConditions.visibilityOf(verificationcode));
			
			Scanner sc = new Scanner (System.in);
			System.out.println("Please eneter the Verification Code in the Box");
			String code =sc.next();
			
			
			verificationcode.sendKeys(code);
			submitbtn.click();
			sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void clickBtn()
	{
		loginbtn.click();
	}
	
	
	
}
