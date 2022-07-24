package testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

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

class IdenticniPodaci {

	private Logger log = Logger.getLogger(IdenticniPodaci.class.getName());

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
	public void proveraPodataka() throws InterruptedException {
		driver.get("https://www.tempo-tehnika.rs/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".dropdown-toggle")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("login-icon")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("JSemail_login")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("JSemail_login")).sendKeys("mejlzalekcije@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("JSpassword_login")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("JSpassword_login")).sendKeys("adminadmin12345");
		Thread.sleep(2000);
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Žarko Obradović")).click();
		Thread.sleep(2000);
		String imeTest = driver.findElement(By.name("ime")).getAttribute("value");
		String prezimeTest = driver.findElement(By.name("prezime")).getAttribute("value");
		Thread.sleep(2000);
		String emailTest = driver.findElement(By.name("email")).getAttribute("value");
		String lozinkaTest = driver.findElement(By.name("lozinka")).getAttribute("value");
		Thread.sleep(2000);
		String telefonTest = driver.findElement(By.name("telefon")).getAttribute("value");
		String adresaTest = driver.findElement(By.name("adresa")).getAttribute("value");
		Thread.sleep(2000);
		String mestoTest = driver.findElement(By.name("mesto")).getAttribute("value");

		System.out.println(imeTest);
		System.out.println(prezimeTest);
		System.out.println(emailTest);
		System.out.println(lozinkaTest);
		System.out.println(telefonTest);
		System.out.println(adresaTest);
		System.out.println(mestoTest);

		assertEquals("Žarko", imeTest);
		assertEquals("Obradović", prezimeTest);
		assertEquals("mejlzalekcije@gmail.com", emailTest);
		assertEquals("adminadmin12345", lozinkaTest);
		assertEquals("060123456789", telefonTest);
		assertEquals("Cara Dusana 25", adresaTest);
		assertEquals("Cacak", mestoTest);

		String sb = "\nIme testa : Identicni podaci \n"
				+ "Opis testa : Test  proverava da li su podaci korišćeni pri registraciji jednaki sa podacima na vašem profilu \n"
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
