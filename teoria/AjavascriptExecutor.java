package DelementosIntermedios;



import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import EpatronPOM.pageObjects.GooglePage;


/*  clase JavascriptExecutor    "ejecutar snippets"
 * 
 * - Se utiliza para crear código javaScript y ejecutarlo con selenium.
 * 
 * - pasos:
 * 1º creamos el objeto JavascriptExecutor
 * 2º utilizamos el método .executeScript() para ejecutarlo
 * 
 * 3º crear una lista de tabs para 
 *
 * 
 * 
 * */
public class AjavascriptExecutor {

	
	private WebDriver driver;
	private String wikipedia;
	GooglePage googlePage;
	By localizadorCookies=By.xpath("//button[@id=\"L2AGLb\"]");
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		this.wikipedia="https://www.w3schools.com/html/html_iframe.asp";
		
	}

	

	@Test()
	public void moverBarraDesplazamiento() throws InterruptedException {
		driver.get(this.wikipedia);
		Thread.sleep(2000);
		List<WebElement>enlaces=driver.findElements(By.cssSelector("[target=\"_top\"]"));
		System.out.println(enlaces.size()); //121
		WebElement ultimoEnlace=driver.findElement(By.linkText("Keyboard Shortcuts"));
		//crear el objeto
			JavascriptExecutor js=(JavascriptExecutor) driver;
	//le estamos diciendo que mueva el SCROLL hacia el último enlace que hay 
			js.executeScript("window.scrollBy(0, arguments[0])", ultimoEnlace.getLocation().getY());
			Thread.sleep(2000);
			
	
		
	}
	@Test
	public void abrirPestanaYcambiarFoco() throws InterruptedException {
		driver.get(this.wikipedia);
		Thread.sleep(2000);
		//crear el objeto
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//abrir una nueva pestaña (tab)
		js.executeScript("window.open('https://www.google.com')");
	
		
//cambiar el foco de la pestaña		
	String pestaniaConFoco=driver.getWindowHandle();
	String pestaniaSinFoco="";
	Set <String> oyentes=driver.getWindowHandles();
	for(String actual:oyentes) {
		
		if(!actual.equalsIgnoreCase(pestaniaConFoco)){
			driver.switchTo().window(actual);
			pestaniaSinFoco=actual;  //aquí cambiamos el foco a la pestaña nueva
		}
	}
	//con la nueva pestaña nos vamos a google y aceptamos las cookies
	googlePage=new GooglePage(driver);
	googlePage.aceptarCookies();
	Thread.sleep(4000);
	
	//volver a la pestaña de origen
	driver.switchTo().window(pestaniaConFoco);
	driver.get("https://www.google.com");
	Thread.sleep(2000);                    //TODO PERFECTO
	
	
	
	}
	
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}
}
