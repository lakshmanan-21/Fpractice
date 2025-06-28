package com.kushals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FeaturesTest 
{
	@Test
	public void countryNameTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.kushals.com/");
		driver.manage().window().maximize();
		
	}
	

}
