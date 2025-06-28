package com.redbus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateSeatsTest 
{
	@Test
	public void seatsTest()
	{
	String actualseats=	"2 seats";
		String actualbutton="Fill passenger details";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.redbus.in/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//div[text()='From']")).click();
	String from="Bangalore";
	String to="Tirupati";
	String Date="24";
	driver.findElement(By.xpath("//div[text()='"+from+"']")).click();
    driver.findElement(By.xpath("//div[text()='"+to+"']")).click();
    driver.findElement(By.xpath("//i[@class='icon___0039d4 icon icon-date_range']")).click();
    driver.findElement(By.xpath("//span[text()='"+Date+"']")).click();
    driver.findElement(By.xpath("//i[@class='icon___5d0bb4 icon icon-search']")).click();
    driver.findElement(By.xpath("(//button[@class='primaryButton___2f7bf2 '])[position()=2]")).click();
    driver.findElement(By.xpath("(//button[@class='primaryButton___2f7bf2 viewSeatsBtn___3f5f2a'])[position()=1]")).click();
    driver.findElement(By.xpath("//div[text()='Mathikere']/parent::div/parent::div/following-sibling::div/child::div")).click();
    driver.findElement(By.xpath("(//button[@class='primaryButton___2f7bf2 '])[position()=2]")).click();
    driver.findElement(By.xpath("//div[@id='6']")).click();
    driver.findElement(By.xpath("//div[@id='12']")).click();
  String expectedseats=  driver.findElement(By.xpath("(//div[@class='countPriceWrap___e5c960 ']/child::div)[position()=1]/child::span")).getText();
   String expectedbutton =driver.findElement(By.xpath("//button[@class='primaryButton___2f7bf2 button___2b7236']")).getText();
   
   Assert.assertEquals(actualseats,expectedseats);
   Assert.assertEquals(actualbutton, expectedbutton);
   
	}
    
    
    
}
