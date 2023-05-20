package crossBrowser;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static WebDriver driver=null;
	
	@BeforeAll()
	public static WebDriver getDriver(DriverType tipo){
	
		switch(tipo) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			 ChromeOptions chromeOptions=new ChromeOptions();
			 chromeOptions.addArguments("--no-first-run");
			 chromeOptions.addArguments("--ignore-certificate-errors");
			 chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
			 chromeOptions.addArguments("--remote-allow-origins=*");
			 chromeOptions.addArguments("--disable-notifications");
			 driver=new ChromeDriver(chromeOptions);

//			WebDriverManager.firefoxdriver().setup();
//			WebDriverManager.operadriver().setup();
//			WebDriverManager.chromiumdriver().setup()
//			WebDriverManager.iedriver().setup();
			 break;
			 
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions=new FirefoxOptions();
//			firefoxOptions.addArguments("--no-first-run");
//			firefoxOptions.addArguments("--ignore-certificate-errors");
//			firefoxOptions.addArguments("--disable-blink-features=AutomationControlled");
//			firefoxOptions.addArguments("--remote-allow-origins=*");
//			//	 chromeOptions.addArguments("user-data-dir=C:/Users/TU_NOMBRE_USUARIO_WINDOWS/AppData/Local/Google/Chrome/User Data");
//			firefoxOptions.addArguments("--disable-notifications");

//			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
//			firefoxOptions.addArguments("--disable-dev-shm-usage");
			driver = new FirefoxDriver(firefoxOptions);
			break;
			 
		case EDGE:
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--no-first-run");
			 options.addArguments("--ignore-certificate-errors");
			 options.addArguments("--disable-blink-features=AutomationControlled");
			 options.addArguments("--remote-allow-origins=*");
			 options.addArguments("--disable-notifications");
//			  options.addArguments("disable-extensions", "disable-infobars", "disable-breakpad");
//			  Map<String, Object> prefs = new HashMap<>();
//			  prefs.put("exit_type", "None");
//			  prefs.put("exited_cleanly", true);
//			  options.setExperimentalOption("prefs", prefs);
//			  String edgePath = System.getProperty("webdriver.edge.binary");
			
			driver=new EdgeDriver(options);
			 break;
			 default:
				 System.out.println("NO HAY INSTANCIA DE NAVEGADOR");
				 break;

		}
		return driver	;
	}
	
	 @AfterAll()
	    void teardown() {
	//no cerrar aqui!!!!
//	        driver.quit();
	    }
}
