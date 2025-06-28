package com.ninzahrm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest 
{
	@Test
	public void sampleTest()
	{
		String actualpname="pineapple";
		EdgeOptions option=new EdgeOptions();
		option.addArguments("--diable-notifications");
		WebDriver driver=new EdgeDriver(option);
		driver.get("http://49.249.28.218:8091/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(actualpname);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("raju");
	WebElement status=driver.findElement(By.xpath("(//select[@name='status'])[position()=2]"));
		Select s=new Select(status);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	//Read the project	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String projectid=	driver.findElement(By.xpath("(//td[text()='"+actualpname+"']/parent::tr/child::td)[position()=1]")).getText();
	System.out.println(projectid);
	
	String expectedprojectname=driver.findElement(By.xpath("(//td[text()='"+projectid+"']/parent::tr/child::td)[position()=2]")).getText();
	System.out.println(expectedprojectname);
		Assert.assertEquals(actualpname, expectedprojectname);
		
		driver.findElement(By.xpath("(//td[text()='NH_PROJ_202']/parent::tr/descendant::td/child::a)[position()=1]")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("lavendar");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("raju");
	WebElement st=driver.findElement(By.xpath("(//select[@name='status'])[position()=2]"));
		Select s1=new Select(st);
		s1.selectByVisibleText("Created");
		
	}

}
