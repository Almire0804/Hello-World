package com.webOrder;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/adilalim/Documents/selenuim dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();

		Random n1 = new Random() ;
		int num1 = n1.nextInt(100) +1;
		String almaNum = "" + num1;
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("almaNum");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"))
		.sendKeys("Jhon" + " " + "Smith");
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Alexandria");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virgina");
		//Enter a random 5 digit number to the zip code field
		Random rnd = new Random();
	    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(Integer.toString(rnd.nextInt(10)));
	    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(Integer.toString(rnd.nextInt(10)));
	    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(Integer.toString(rnd.nextInt(10)));
	    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(Integer.toString(rnd.nextInt(10)));
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(Integer.toString(rnd.nextInt(10)));
	
	//Select any card type. Every time your code should select a different type
	int card = (int)(Math.random()*3);
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_"+ card)).click();
	
	//Enter any card number, If you selected visa, card number should start with 4, If you selected master, card number should start with 5;
	//If you selected AMX, card number should start with 3;New card number should be auto generated every time you run the test.
	//Card numbers should be 16 digits for Visa and Master, 15 for American Express.
	switch (card) {
	case 0:
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(4));
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(rnd.nextInt(10)));
		break;
	case 1:
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(5));
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(rnd.nextInt(10)));
		break;
	case 2:
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(3));
		break;
	}
	StringBuilder ccnum = new StringBuilder();
	for(int i = 0; i< 14;i ++) {
		ccnum.append((int)(Math.random()*10));
	}
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(ccnum.toString());
	
	// Enter any valid expiration sate
	StringBuilder exp = new StringBuilder();
	exp.append(rnd.nextInt(2));
	if(exp.toString().endsWith("0")) {
		exp.append(rnd.nextInt(10));
	}else{
		exp.append(rnd.nextInt(3));
	}
	exp.append("/"+rnd.nextInt(10));
	exp.append(rnd.nextInt(10));
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(exp.toString());
	
	// click on process
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	

		// verify than the page contains text New order has been successfully added.
//		String expected = "New order has been successfully added.";
//		String actual = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();
//
//		if ( actual.contains(expected) ) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
		
		if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText().contains("New order has been successfully added")) {
		      System.out.println("Pass");
		    } else {
		System.out.println("Fail");
			
		}
		


			
			

	
	}
}
