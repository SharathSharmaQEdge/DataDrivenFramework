package testcases;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;



public class LoginTest extends TestBase{
	
	@Test(dataProvider="getData")
	public void doLogin(String username, String password) throws InterruptedException
	{
		//System.out.println("Inside the login test case");
		driver.findElement(By.xpath(or.getProperty("email"))).sendKeys(username);
		driver.findElement(By.xpath(or.getProperty("pwd"))).sendKeys(password);
		driver.findElement(By.xpath(or.getProperty("logIn"))).click();
		//System.out.println("Inside the login test case");
		String expectedTitle = "Facebook"; 
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle,actualTitle);
		driver.findElement(By.xpath(or.getProperty("LogoutDropDown"))).click(); 
		Thread.sleep(4000);  
		driver.findElement(By.xpath(or.getProperty("LogoutOption"))).click();
		Thread.sleep(5000); 
				
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		String sheetName="LoginTest";
		int rows=excel.getRowCount(sheetName);
		System.out.println("Total rows : " + rows);
		int cols=excel.getColumnCount(sheetName);
		System.out.println("Total Cols : " + cols);
		Object[][] data= new Object[rows-1][cols];
		
		for(int rowNum=2; rowNum<=rows; rowNum++)
		{
			for(int colNum=0; colNum<cols; colNum++)
			{
				//data[0]
				data [rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); 
			}
		}
		return data;
	}


}
