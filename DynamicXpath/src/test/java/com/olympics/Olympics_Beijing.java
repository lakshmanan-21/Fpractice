package com.olympics;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Olympics_Beijing 
{
	@Test
	public void countryNameTest() throws InterruptedException
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the position");
		String p=s.nextLine();
		System.out.println("Enter the playername");
		String pl=s.nextLine();
		
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.olympics.com/en/olympic-games/tokyo-2020");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
		
		driver.findElement(By.xpath("//div[@class='sc-6ba3678f-3 kylzhR']/child::a[text()='Results']")).click();
		
		Actions action=new Actions(driver);
		action.scrollByAmount(0, 1300).build().perform();
		// driver.findElement(By.xpath("//p[text()='Boxing']"));
		  
		  WebElement b= driver.findElement(By.xpath("//h2[text()='Sports']/parent::div/parent::section/parent::section/descendant::p[text()='Boxing']"));
		 // WebElement b= driver.findElement(By.xpath("(//div[@class='sc-8eb57e66-1 cGEasT discipline-icon'])[position()=10]"));
		  action.moveToElement(b).click().build().perform();
		
		
		 
		  action.scrollByAmount(0, 1000).build().perform();
		WebElement e=driver.findElement(By.xpath("//div[@class='sc-d0fd8f2b-3 begcQS']//*[local-name()='svg']"));
		action.moveToElement(e).click().build().perform();
		List<WebElement> event=driver.findElements(By.xpath("//h2[@class='sc-1c8702ff-2 kwPbtY']"));
		
		String tex=null;
		
		for(WebElement t:event)
		{
			tex=t.getText();
			//System.out.println(tex);
		}
		
		
		driver.findElement(By.xpath("(//span[@class='sc-d0fd8f2b-1 ghiRYa'])[position()=1]//*[name()='svg']")).click();
		driver.findElement(By.xpath("(//button[@class='sc-6b7599d3-1 bBBRPj link-item'])[position()=2]")).click();
		driver.findElement(By.xpath("(//span[@class='sc-d0fd8f2b-1 ghiRYa'])[position()=2]//*[name()='svg']")).click();
		driver.findElement(By.xpath("(//button[@class='sc-6b7599d3-1 bBBRPj discipline-row'])[position()=2]")).click();
		driver.findElement(By.xpath("(//span[@class='sc-d0fd8f2b-1 ghiRYa'])[position()=3]//*[name()='svg']")).click();
		driver.findElement(By.xpath("(//button[@class='sc-6b7599d3-1 bBBRPj'])[position()=2]")).click();
		
		driver.findElement(By.xpath("//a[@data-cy='go-link']")).click();
		
		action.scrollByAmount(0, 1400).build().perform();
		String country=driver.findElement(By.xpath("(//div[@class='sc-d8cd2c5-2 dPlqCj']/child::h3[text()='"+pl+"']/ancestor::div[@data-row-id='event-result-row-1']/descendant::span)[position()=3]")).getText();
		System.out.println(pl+"===>"+country);
		
		driver.quit();
	}


}
