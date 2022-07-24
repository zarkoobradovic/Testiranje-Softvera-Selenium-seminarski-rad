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

class ListaZelja {

	private Logger log = Logger.getLogger(ListaZelja.class.getName());

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
	public void listaZelja() throws InterruptedException {

		driver.get("https://www.tempo-tehnika.rs/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".dropdown-toggle")).click();
		{
			WebElement element = driver.findElement(By.id("login-icon"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("login-icon")).click();
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("JSemail_login")).click();
		driver.findElement(By.id("JSemail_login")).sendKeys("mejlzalekcije@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("JSpassword_login")).click();
		driver.findElement(By.id("JSpassword_login")).sendKeys("adminadmin12345");
		Thread.sleep(2000);
		driver.findElement(By.id("login")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("ALATI")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".col-md-3:nth-child(1) > .flex > span")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("DeWalt DCK211D2T 10.8, 2x2.0 Ah Akumulatorska bušilica - odvijač ...")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".JSadd-to-wish > .far")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Žarko Obradović")).click();
		Thread.sleep(2000);
		String pokupiNaziv = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/h2/a")).getText();
		Thread.sleep(2000);
		System.out.println(pokupiNaziv);

		assertEquals("DeWalt DCK211D2T 10.8, 2x2.0 Ah Akumulatorska bušilica - odvijač ...", pokupiNaziv);

		String sb = "\nIme testa : Dodavanje proizvoda u omiljene \n"
				+ "Opis testa : Test proverava da li su proizvodi dodati u omiljene i proverava da li proizvod ima isto ime kao dodati \n" + "Test je uspesan \n\n";
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
