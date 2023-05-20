package BmecanismosDeEspera;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 			 Explicit Wait
 *  - Se declara cuando vaya a usarse y no antes.
 *  - Nos permite configurar el POLLING. opcional
 *  - Se aplica únicamente a los elementos seleccionados.
 *  - Nos permite especificar la condición deseada (estado del elemento) para dar por finalizada la espera.
 *  - El tiempo de espera NO está configurado.
 *  - Seleníum irá consultando en el DOM hasta que se agote el tiempo límite especificado.
 *  
 *  WebDriverWait wait=new WebDriverWait(driver,10);
 *  WebElement boton=wait.until(ExpectedConditions.elementToBeClickable(By.id("boton1")));
 *  En caso de agotarse el tiempo se lanzará la excepción : TimeOutException
 *   
 * 
 * 
 * */
public class DexplicitWait {

	private WebDriver driver;
	
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		// ruta normal puede usar la rutaFirefox, pero no al revés.
		String rutaNormal="C:/Users/mraralma/OneDrive%20-%20IBERMATICA%20S.A/Escritorio/FUNCIONALES/curso%20Iberm%C3%A1tica/selenium%20con%20java%20para%20principiantes/index_completo.html";
		String rutaFirefox="file:///C:/Users/mraralma/OneDrive%20-%20IBERMATICA%20S.A/Escritorio/FUNCIONALES/curso%20Iberm%C3%A1tica/selenium%20con%20java%20para%20principiantes/index_completo.html";
		driver.get(rutaNormal);
	}
	
	@Test
	public void test() throws InterruptedException {
		//ExplicitWait lo configuramos con 10 segundos de espera,
		WebDriverWait waitExplicito=new WebDriverWait(driver,Duration.ofSeconds(10));
		//ExplicitWait espera hasta que el elemento con ID sea cliclable. Ya que el botón hasta los 6 segundos está programado para estar desabilitado.
		WebElement botonExplicitWait=waitExplicito.until(ExpectedConditions.elementToBeClickable(By.id("explicitWaitButton")));
		botonExplicitWait.click();
		Thread.sleep(4000);

	
		
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
