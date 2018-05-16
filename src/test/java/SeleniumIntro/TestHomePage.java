package SeleniumIntro;

import junit.framework.TestCase;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;

public class TestHomePage{

	private static WebDriver driver;

	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\walke\\Documents\\Work\\chromedriver.exe");
		driver = new ChromeDriver();
	}


	@Test
	public void testGoogleSearch() throws InterruptedException {
		driver.manage().window().fullscreen();
		Thread.sleep(1000);
		driver.get("http://www.google.com/");
		Thread.sleep(1000);
		WebElement googleSearchField = driver.findElement(By.name("q"));
		googleSearchField.sendKeys("funny vines compilation");
		Thread.sleep(2000);
		googleSearchField.submit();
		Thread.sleep(2000);
		WebElement funnyVine = driver.findElement(By.partialLinkText("Best Vines of All Time Vine Compilation"));
		funnyVine.click();
		Thread.sleep(15000);
	}

	@Test
	public void testShop() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.name("search_query"));
		search.sendKeys("Dress");
		Thread.sleep(1000);
		search.submit();
		Thread.sleep(2000);
	}


	@Test
	public void SendHelp() throws InterruptedException{
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://www.youtube.com/watch?v=9SFxtqc3v08");
		Thread.sleep(20000);
		WebElement search = driver.findElement(By.name("0"));
		search.click();
		Thread.sleep(1000);
	}

	@Test
	public void SendHelp2() throws InterruptedException{
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://www.youtube.com/watch?v=mqDOQzfM5Kc");
		Thread.sleep(3000);
	}

	@Test
	public void WhatAmI() throws InterruptedException{
		driver.manage().window().maximize();
		Thread.sleep(500);
		driver.get("");
	}

	@Test
	public void holiday() throws InterruptedException{
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
		Thread.sleep(2000);

		WebElement book = driver.findElement(By.id("select2-drop"));
		book.sendKeys("London, United Kingdom");
		book.submit();
		Thread.sleep(1000);

	}


	@Test
	public void drag() throws InterruptedException{
		driver.manage().window().maximize();
		driver.get("http://demoqa.com");

		WebElement draggableMenuButton = driver.findElement(By.id("menu-item-140"));
		draggableMenuButton.click();
		Thread.sleep(1000);
		WebElement draggableBox = driver.findElement(By.id("draggable"));

		Actions builder = new Actions(driver);
		builder.clickAndHold(draggableBox).moveByOffset(50,50).perform();
		builder.clickAndHold(draggableBox).moveByOffset(150,50).perform();
		builder.clickAndHold(draggableBox).moveByOffset(50,150).perform();
		Thread.sleep(3000);


	}

	@After
	public void tearDown(){
		driver.quit();
	}

	private WicketTester tester;

	public void setUp()
	{
		tester = new WicketTester();
	}

	public void testRenderMyPage()
	{
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);

		//assert rendered label component
		tester.assertLabel("message", "If you see this message wicket is properly configured and running");
	}
}
