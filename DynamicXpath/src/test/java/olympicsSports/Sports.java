package olympicsSports;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sports 
{
	@Test
	public void countryNameTest()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the sportsname");
		String sportname=s.nextLine();
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.bbc.com/sport/olympics/paris-2024/medals");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()='Medal results']")).click();
		driver.findElement(By.xpath("//select[@id='discipline-selector']/child::option[text()='"+sportname+"']")).click();
	    List<WebElement> country=driver.findElements(By.xpath("//tr//td/descendant::div[@class='ssrcss-fy4lnm-PrimaryName e1dg50ic1' or @class='ssrcss-1xzbuw5-SecondaryName e1dg50ic0']"));
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(int i=0;i<country.size();i++)
		{
			set.add(country.get(i).getText());
		}
		System.out.println(set);
		driver.quit();
	}
}
