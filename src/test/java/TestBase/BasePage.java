	package TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
 public WebDriver driv;
 public WebDriverWait waits;
 
 public BasePage(WebDriver driv, WebDriverWait waits)
 {
	 this.driv=driv;
	 this.waits= new WebDriverWait(driv, Duration.ofSeconds(10));
	 
	  PageFactory.initElements(driv, this);
	 
 }
	
	
}
