package testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class TriProizvodaUkorpi2 {

	private Logger log = Logger.getLogger(TriProizvodaUkorpi2.class.getName());

	private WebDriver driver;
	private JavascriptExecutor js;
	private Map<String, Object> vars;

	@BeforeEach // OVO SVE ZA POKRETANJE DRAJVERA
	void podesavanje() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\02. Download D\\eclipse\\seleniumm\\Hrom driver\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	/*
	 * =============================================================================
	 * ===============================
	 */
	@AfterEach
	void zatvoriDrajver() {
		driver.quit(); // zatvara sve prozore pretrazivaca
		// driver.close(); //zatvara samo trenutni prozor kojim upravlja web driver
	}

	/*
	 * =============================================================================
	 * ===============================
	 */

	@Test
	public void dodavanjeUkorpu3prozivoda() throws InterruptedException {
		driver.get("https://www.tempo-tehnika.rs/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".JScategories > .text-center")).click();
		driver.findElement(By.linkText("TV, AUDIO,VIDEO")).click();
		driver.findElement(By.linkText("TELEVIZORI")).click();
		driver.findElement(By.cssSelector(".JSproduct:nth-child(11) .product-image")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("JSAddCartSubmit")).click();
		driver.findElement(By.xpath("//*[@id=\"JSfixed_header\"]/div[3]/div/div[1]/h1/a/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".JScategories > .text-center")).click();
		Thread.sleep(2000);
		{
			WebElement element = driver.findElement(By.linkText("MOBILNI TELEFONI I TABLETI"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.linkText("MOBILNI TELEFONI I TABLETI")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".col-md-3:nth-child(1) > .flex > span")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".JSproduct:nth-child(6) .product-image")).click();
		{
			WebElement element = driver.findElement(By.id("JSAddCartSubmit"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("JSAddCartSubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"JSfixed_header\"]/div[3]/div/div[1]/h1/a/img")).click();
		Thread.sleep(2000);
		{
			WebElement element = driver.findElement(By.linkText("TV, AUDIO,VIDEO"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		driver.findElement(By.cssSelector(".JSlevel-1 > li:nth-child(5) > a")).click();
		driver.findElement(By.cssSelector(".col-md-3:nth-child(1) > .flex > span")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".JSproduct:nth-child(9) .product-image")).click();
		driver.findElement(By.id("JSAddCartSubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
		String ocekivanaVR = driver.findElement(By.cssSelector(".JSdelivery_total_amount")).getText();
		System.out.println(ocekivanaVR);

		// Provera cene u korpi
		Thread.sleep(2000);

		assertEquals("83.710,00 rsd.", ocekivanaVR);

		String sb = "\nIme testa : Dodavanje 3 proizvoda u korpu \n"
				+ "Opis testa : Test proverava da li ce proizvodi biti uspesno dodati u korpu \n"
				+ "Test je uspesan \n\n";
		log.info(sb.toString());
		try {

			FileWriter fw = new FileWriter(
					"C:\\Users\\Lenovo\\Downloads\\PROJEKAT TSW\\TempoTehnika\\izvestajTestova\\test-report.txt",
					true);
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
