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

/* 		Iframe    
 * - En ocasiones hay páginas que tienen embebidas otras páginas, están dentro de un iframe.
 * - La web embebida suele tener otro dominio diferente.
 * - Para usar el iframe debemos cambiar el CONTEXTO usando switchTo()
 * 
 * - También se puede volver al frame por defecto mediante defaultContent()
 *  
 * */


public class HiframeCambioDeContexto {

	private WebDriver driver;
	
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		String wikipedia="https://www.w3schools.com/html/html_iframe.asp";
		driver.get(wikipedia);
	}

	
	
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(2000);
		//cambia el entorno al iframe con id:"". No tiene id, vamos a pedir que me de el primero que encuentre 
		driver.switchTo().frame(0);
		
		//ExplicitWait lo configuramos con 10 segundos de espera, y 2 segundos de polling
		WebDriverWait waitExplicito=new WebDriverWait(driver,20,5000);
		//ExplicitWait espera hasta que el elemento con ID sea cliclable. Ya que el botón hasta los 6 segundos está programado para estar desabilitado.
		WebElement enlaceCSS=waitExplicito.until(ExpectedConditions.elementToBeClickable(By.linkText("CSS")));
		enlaceCSS.click();
	
	//para poder volver al frame inicial:
		//driver.switchTo().defaultContent();
	
		
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
