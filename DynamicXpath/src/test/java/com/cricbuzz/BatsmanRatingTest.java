package com.cricbuzz;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BatsmanRatingTest 
{
	@Test
	public void ratingTest()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Batsman name");
		String player=s.nextLine();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Rankings']")).click();
		driver.findElement(By.xpath("(//nav[@gtm-label='rankings']/a)[position()=2]")).click();
		
		String rating=driver.findElement(By.xpath("//a[text()='Batting']/parent::nav/ancestor::div[@class='cb-col cb-col-100 cb-bg-white ng-scope']/descendant::a[text()='ODI']/ancestor::div[@class='cb-col cb-col-100 cb-rank-tabs']/descendant::a[text()='"+player+"']/ancestor::div[@class='cb-col cb-col-100 cb-font-14 cb-lst-itm text-center']/descendant::div[@class='cb-col cb-col-17 cb-rank-tbl pull-right']")).getText();
		
		
		String country=driver.findElement(By.xpath("//a[text()='Batting']/parent::nav/ancestor::div[@class='cb-col cb-col-100 cb-bg-white ng-scope']/descendant::a[text()='ODI']/ancestor::div[@class='cb-col cb-col-100 cb-rank-tabs']/descendant::a[text()='"+player+"']/following-sibling::div")).getText();
		System.out.println(country);
		
		
		//Fetching all the players and the corresponding ratings
		List<WebElement> ratings=driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-padding-left0']/descendant::a/ancestor::div[@class='cb-col cb-col-100 cb-font-14 cb-lst-itm text-center']/descendant::div[@class='cb-col cb-col-17 cb-rank-tbl pull-right']"));

		List<WebElement> players=driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-padding-left0']/descendant::a"));
		for(int i=0;i<players.size();i++)
		{
			String p=players.get(i).getText();
			String  r=ratings.get(i).getText();
			System.out.println(p +"====>"+ r);
			
		}
		
		
		
		
		
		driver.quit();
	}

}
