package BmecanismosDeEspera;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;




/* 		Fluent Wait
 * 
 *  - Se declara cuando vaya a usarse.
 *  - Se aplica solo a los elementos seleccionados.
 *  - Nos permite ignorar especificamente el error o errores posibles que devuelva un elemento.
 *  - Nos permite configurar el Timeout.
 *  - Nos permite configurar el polling. Por defecto el tiempo no está configurado.
 * 
 * 
 *   Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
 *   .withTimeout(Duration.ofSeconds(15))
 *   .pollingEvery(Duration.ofSeconds(3))   //Tiempo de consulta a la pagina
 *   .ignoring(NoSuchElementException.class);
 *   
 *   
 *   
 * 
 * 
 * 
 * */
public class CfluentWait {

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
	public void test(){
		//Configuramos FluentWait, duración 15 segundos, polling 3 segundos e ignora la excepción NoSuchELementException
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(15))
		.pollingEvery(Duration.ofSeconds(3))
		.ignoring(NoSuchElementException.class);
		//Se declara una función ANONIMA,
		WebElement botonImplicitWait=fluentWait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("implicitWaitButton"));
			}
		});
		botonImplicitWait.click();//No sale JOOOOOOOO
	//	Thread.sleep(4000);

	
		
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
