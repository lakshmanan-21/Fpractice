package com.cricbuzz;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BowlerRatingTest 
{
	@Test
	public void ratingTest()
	{
		
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the Bowler name");
	String player=s.nextLine();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.cricbuzz.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[text()='Rankings']")).click();
	driver.findElement(By.xpath("//a[text()='Bowling']")).click();
	driver.findElement(By.xpath("//a[text()='ODI']")).click();
	
	String rating=driver.findElement(By.xpath("//a[text()='"+player+"']/ancestor::div[@class='cb-col cb-col-100 cb-font-14 cb-lst-itm text-center']/descendant::div[@class='cb-col cb-col-17 cb-rank-tbl pull-right']")).getText();
	
	System.out.println(rating);
	
	String country=driver.findElement(By.xpath("//a[text()='"+player+"']/following-sibling::div")).getText();
	System.out.println(country);
	
	driver.quit();
}

}



