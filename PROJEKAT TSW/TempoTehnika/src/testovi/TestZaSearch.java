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
import org.openqa.selenium.chrome.ChromeDriver;

class TestZaSearch {

	private Logger log = Logger.getLogger(TestZaSearch.class.getName());

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
	public void searchTest() {
		driver.get("https://www.tempo-tehnika.rs/");
		driver.manage().window().maximize();
		driver.findElement(By.id("JSsearch2")).click();
		driver.findElement(By.id("JSsearch2")).sendKeys("fox tv");
		driver.findElement(By.cssSelector(".fa-search")).click();
		driver.findElement(By.cssSelector(".JSproduct-list")).click();
		driver.findElement(By.linkText("Fox 32DLE462 DLED, 32\" (81 cm), HD READY 1366x768, ATV, DTV-T-C-T2")).click();

		String sb = "\nIme test : search\n" + "Opis testa : Provera pretrazianja sajta\n" + "Test je uspesan";
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
