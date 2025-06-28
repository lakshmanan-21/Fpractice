package com.manapuram;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PlaceholderTest
{
	@Test
	public void ratingTest()
	{
		String name="peter";
		String email="peter@gmail.com";
		String city="Bangalore";
		String goldweight="77";
		String contactno="9123595956";
		String state="Karnataka";
		String gtype="Chain";
		String amount="-34563";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.manappuram.com/gold-loan");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//li[@class='nav-item quick-link--sticky__item'])[position()=2]")).click();
		Actions action=new Actions(driver);
		action.scrollByAmount(0, 2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='gold_weight']")).sendKeys(goldweight);
		driver.findElement(By.xpath("//input[@name='phone_number']")).sendKeys(contactno);
		
		WebElement states=driver.findElement(By.xpath("//select[@id='edit-state']"));
		Select s=new Select(states);
		s.selectByVisibleText(state);
		
		WebElement goldtype=driver.findElement(By.xpath("//select[@id='edit-goldtype']"));
		Select s1=new Select(goldtype);
		s1.selectByVisibleText(gtype);
		
		driver.findElement(By.xpath("//input[@name='amount_required']")).sendKeys(amount);
		try
		{
		List<WebElement> placeholder=driver.findElements(By.xpath("//div[@class='fieldset-wrapper']/descendant::input"));
		for(WebElement text:placeholder)
		{
			String placeholdertext=text.getAttribute("placeholder");
		System.out.println(placeholdertext);
		}
		WebElement button=driver.findElement(By.xpath("//button[@id='edit-submit']"));
		action.moveToElement(button).click().build().perform();
		}
		catch(Exception e)
		{
			
		}
	
	}
}


