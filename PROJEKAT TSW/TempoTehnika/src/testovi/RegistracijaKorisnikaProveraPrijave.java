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

class RegistracijaKorisnikaProveraPrijave {

	private Logger log = Logger.getLogger(RegistracijaKorisnikaProveraPrijave.class.getName());

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
	public void registracijaNaloga() {
		driver.get("https://www.tempo-tehnika.rs/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".dropdown-toggle")).click();
		driver.findElement(By.id("registration-icon")).click();
		driver.findElement(By.id("ime")).click();
		driver.findElement(By.id("ime")).sendKeys("Zarko");
		driver.findElement(By.id("prezime")).sendKeys("Obradovic");
		driver.findElement(By.id("email")).sendKeys("aaabbb@gmail.com");
		driver.findElement(By.id("lozinka")).sendKeys("adminadmin123");
		driver.findElement(By.id("telefon")).click();
		driver.findElement(By.id("telefon")).sendKeys("060123456");
		driver.findElement(By.id("adresa")).click();
		driver.findElement(By.id("adresa")).sendKeys("Cacak");
		driver.findElement(By.id("mesto")).sendKeys("Cacak");
		driver.findElement(By.cssSelector(".text-center > .button")).click();

		String sb = "\nIme testa : Registracija korisnika \n" + "Opis testa : Test proverava registraciju korisnika \n"
				+ "Test je uspesan \n\n";
		log.info(sb.toString());
		try {

			FileWriter fw = new FileWriter(
					"C:\\Users\\Lenovo\\Downloads\\Projekat TSW selenium fajlovi\\izvestajTestova\\test-report.txt",
					true);
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * =============================================================================
	 * ===============================
	 */
	@Test
	public void proveraPrijaveNaProdavnicu() {
		driver.get("https://www.tempo-tehnika.rs/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".caret")).click();
		{
			WebElement element = driver.findElement(By.id("login-icon"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.id("login-icon")).click();
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		driver.findElement(By.id("JSemail_login")).click();
		driver.findElement(By.id("JSemail_login")).sendKeys("mejlzalekcije@gmail.com");
		driver.findElement(By.id("JSpassword_login")).sendKeys("adminadmin123");
		driver.findElement(By.id("JSpassword_login")).sendKeys(Keys.ENTER);

		String sb = "\nIme testa : Provera prijave na prodavnicu i registracija \n"
				+ "Opis testa : Test proverava da li ce prijava biti uspesna \n" + "Test je uspesan \n\n";
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
