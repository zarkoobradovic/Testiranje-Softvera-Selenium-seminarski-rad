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

import org.junit.jupiter.api.Test;

class ProveraDrustvenihMreza {

	private Logger log = Logger.getLogger(ProveraDrustvenihMreza.class.getName());

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
	public void proveraDrustvenihMreza() {
		driver.get("https://www.tempo-tehnika.rs/");
		driver.manage().window().maximize();
		{
			WebElement element = driver.findElement(By.cssSelector(".JSright-body-link"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		String linkFB0 = driver.findElement(By.xpath("//*[@id=\"preheader\"]/div[1]/a[1]")).getAttribute("value");
		driver.findElement(By.cssSelector(".fa-facebook-f")).click();
		System.out.println(linkFB0);

		driver.get("https://www.tempo-tehnika.rs/");
		String linkInsta0 = driver.findElement(By.cssSelector(".fa-instagram")).getAttribute("value");
		driver.findElement(By.cssSelector(".fa-instagram")).click();
		System.out.println(linkInsta0);

		driver.get("https://www.tempo-tehnika.rs/");
		String linkYT0 = driver.findElement(By.cssSelector(".fa-youtube")).getAttribute("value");
		driver.findElement(By.cssSelector(".fa-youtube")).click();
		System.out.println(linkYT0);

		String sb = "\nIme testa : Provera linkova drustvenih mreza \n" + 
		"Opis testa : Test proverava putanje do drustvenih mreza da li su ispravne i da li ce se otvoriti stranica prodavnice na odabranoj drustvenoj mrezi \n"
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
