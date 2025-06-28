package com.worldometers.geography;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UndernourishedPeople 
{
	@Test
	public void ratingTest()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the more option");
		String m=s.nextLine();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the country");
		String c=s.nextLine();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.worldometers.info/geography/countries-of-the-world/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//p[text()='More']")).click();
	driver.findElement(By.xpath("//p[text()='More']/parent::button/following-sibling::div/descendant::a[text()='"+m+"']")).click();
	WebElement country=driver.findElement(By.xpath("//a[text()='"+c+"']"));
	Actions action =new Actions(driver);
	action.moveToElement(country).click().build().perform();
	
	WebElement e=driver.findElement(By.xpath("//h2[text()='Forest in India']"));
	action.scrollToElement(e).build().perform();
	WebElement people=driver.findElement(By.xpath("(//*[local-name()='svg']/*[name()='g'])[position()=9]/*[name()='text']"));
	action.moveToElement(people).click().perform();
	System.out.println(people.getText());
	
	}
	

}
