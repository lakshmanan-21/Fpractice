package josalukas;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ValidateLinks 
{
	@Test
	public void ratingTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.josalukkaseasybuy.com");
		driver.manage().window().maximize();
		 List<WebElement> socialLinks = driver.findElements(By.xpath("//a[contains(@href, 'facebook.com') or contains(@href, 'twitter.com') or contains(@href, 'instagram.com') or contains(@href, 'linkedin.com')]"));

         
         for (WebElement link : socialLinks) {
             String href = link.getAttribute("href");
             if (href != null && !href.isEmpty()) {
                 System.out.println("Valid social media link found: " + href);
             } else {
                 System.out.println("Invalid link found");
             }
		
        
		
		
         }	
         driver.quit();
	}
	
	
	}


