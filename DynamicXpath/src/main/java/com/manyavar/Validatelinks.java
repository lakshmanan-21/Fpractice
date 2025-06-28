package com.manyavar;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Validatelinks 
{
	@Test
	public void ratingTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.manyavar.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Agree & Close']")).click();
		driver.findElement(By.xpath("//p[text()='Men']")).click();
		
		WebElement img=driver.findElement(By.xpath("//img[@alt='men indo-western']"));
		Actions action =new Actions(driver);
		action.moveToElement(img).click().build().perform();
		
		WebElement wish=driver.findElement(By.xpath("(//i[@class='fa fa-heart-o'])[position()=6]"));
		action.moveToElement(wish).click().build().perform();
	List<WebElement> element=driver.findElements(By.xpath("//div[@class='d-flex social-container']/a"));
	for(WebElement lin:element)
	{
				
				
					String href=lin.getAttribute("href");
					 if (href != null && !href.isEmpty()) {
		                 System.out.println("Valid social media link found: " + href);
		             } else {
		                 System.out.println("Invalid link found");
		             }
					
				}
				driver.quit();
			}
		
		
	}




	