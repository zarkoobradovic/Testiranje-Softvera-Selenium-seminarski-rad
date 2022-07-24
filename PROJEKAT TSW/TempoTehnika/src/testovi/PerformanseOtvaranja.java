package testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class PerformanseOtvaranja {

	private Logger log = Logger.getLogger(PerformanseOtvaranja.class.getName());

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
	public void BrzinaOtvaranja5stranica() throws InterruptedException {

		double p = System.currentTimeMillis();

		driver.get("https://www.tempo-tehnika.rs/");
		double k = System.currentTimeMillis();
		double res = k - p;
		String ispis1 = "Pocetna stranica: "+res;
		System.out.println(ispis1);
		/* ===================================================== */

		double p2 = System.currentTimeMillis();

		driver.get("https://www.tempo-tehnika.rs/tv--audio-video");
		double k2 = System.currentTimeMillis();
		double res2 = k2 - p2;
		String ispis2 = "Audio Video stranica: "+res2;
		System.out.println(ispis2);
		/* ===================================================== */

		double p3 = System.currentTimeMillis();

		driver.get("https://www.tempo-tehnika.rs/mobilni-telefoni-i-tableti");
		double k3 = System.currentTimeMillis();
		double res3 = k3 - p3;
		String ispis3 = "Mobilni-telefoni-i-tableti stranica: "+res3;
		System.out.println(ispis3);
		/* ===================================================== */

		double p4 = System.currentTimeMillis();

		driver.get("https://www.tempo-tehnika.rs/laptop--i-desktop-racunari");
		double k4 = System.currentTimeMillis();
		double res4 = k4 - p4;
		String ispis4 = "Laptop--i-desktop-racunari stranica: "+res4;
		System.out.println(ispis4);
		/* ===================================================== */

		double p5 = System.currentTimeMillis();

		driver.get("https://www.tempo-tehnika.rs/grejanje-i-klimatizacija");
		double k5 = System.currentTimeMillis();
		double res5 = k5 - p5;
		String ispis5 = "Grejanje-i-klimatizacija stranica: "+res5;
		System.out.println(ispis5);
		/* ===================================================== */

		double srednjaVR = (res + res2 + res3 + res4 + res5) / 5;
		String ukupanIspis = "Srednja vrednost: " + srednjaVR;
		System.out.println(ukupanIspis);
		/* ===================================================== */

		String sb = "\nIme testa : Performasne otvaranja \n"
				+ "Opis testa : Performanse otvaranja 5 različitih stranica \n" + "Test je uspesan \n\n";
		log.info(sb.toString());
		try {

			FileWriter fw = new FileWriter(
					"C:\\Users\\Lenovo\\Downloads\\PROJEKAT TSW\\TempoTehnika\\izvestajTestova\\test-report.txt",
					true);
			fw.write(sb.toString());
			fw.write("\nIzvestaj o performansama stranica.\n");
			fw.write(ispis1+"\n");
			fw.write(ispis2+"\n");
			fw.write(ispis3+"\n");
			fw.write(ispis4+"\n");
			fw.write(ispis5+"\n");
			fw.write("\n--------------------------------------------------------------\n");
			fw.write(ukupanIspis+"\n");
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
