package CrellenarFormulario;



import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 		Prompt    * es diferente
 * - debemos declarar un explicit wait y preguntar si el alert está presente
 * - Para almacenarlo usaremos la variable de tipo Alert
 * - tiene un campo para escribir
 * - tiene 2 botones aceptar y cancelar.
 * 
 * - utilizar Firefox para hacer las pruebas.
 * 
 * */


public class Gpromt {

	private WebDriver driver;
	
	@BeforeEach
	public void configurar() {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//driver= new ChromeDriver(); 
		System.setProperty("webdriver.firefox.driver", "./drivers/geckodriver.exe");
		driver= new FirefoxDriver(); 
		driver.manage().window().maximize(); 
		// ruta normal puede usar la rutaFirefox, pero no al revés.
		String rutaNormal="C:/Users/mraralma/OneDrive%20-%20IBERMATICA%20S.A/Escritorio/FUNCIONALES/curso%20Iberm%C3%A1tica/selenium%20con%20java%20para%20principiantes/index_completo.html";
		String rutaFirefox="file:///C:/Users/mraralma/OneDrive%20-%20IBERMATICA%20S.A/Escritorio/FUNCIONALES/curso%20Iberm%C3%A1tica/selenium%20con%20java%20para%20principiantes/index_completo.html";
		String wikipedia="https://www.wikipedia.es";
		driver.get(rutaNormal);
	}

	
	
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(2000);
		WebElement boton=driver.findElement(By.id("buttonAlertPromt"));
		boton.click();
		Thread.sleep(2000);
		//1º creamos un wait explícito
		WebDriverWait waitExplicito =new WebDriverWait(driver,10);
		//2º hay que preguntar si el ALERT está presente:
		Alert alert=waitExplicito.until(ExpectedConditions.alertIsPresent());
		//3º No podemos enviar texto al alert nos saldria la excepcion ElementNotInteractableException
		 alert.sendKeys("hola");
		 Thread.sleep(2000);
		//3º podemos pulsar el botón aceptar o cancelar
	    //alert.accept();  
		alert.dismiss(); //cancelar
		Thread.sleep(2000);
	
		
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
