package com.bcci;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestRanking 
{
	@Test
	public void ratingTest()
	{
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the country name");
	String country=s.nextLine();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.bcci.tv/international/men/rankings/test ");
	driver.manage().window().maximize();
	String ratings=driver.findElement(By.xpath("(//h6[text()='"+country+"']/parent::td/ancestor::tr/descendant::p)[position()=3]")).getText();
	System.out.println(ratings);
	driver.quit();
	}

}
