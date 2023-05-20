package DelementosIntermedios;



import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*   ShadowDOM  encapsular.
 * 
 * - La finalidad es encapsular y aislar componentes web.
 * - hay dos modos de trabajar: open y closed.
 * - Mediante CLOSED no se puede manipular los elementos y no se puede automatizar pruebas.
 * - Se utilizan snippets de JS para manipular los elementos dentro del shadowDOM.
 * 
 * - El nodo "shadowHost" va a ser el nodo que vamos a encapsular.
 * - El nodo "shadowRoot" es el padre de nuestro nodo oculto
 * 
 * - pasos:
 * 1º localizar el nodo shadowHost.
 * 2º ejecutar el snippet JS y almacenar el objeto como shadowRoot
 * 3º Considerar el nuevo shadowRoot como origen desde el que partir para realizar búsquedas.
 * 4º Localizar elementos usando el shadowRoot.
 * 
 * */
public class BshadowDOMencapsulacion {

	
	private WebDriver driver;
	private String wikipedia;
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		this.wikipedia="https://www.w3schools.com/html/html_iframe.asp";
		
	}

	

	@Test
	public void test() throws InterruptedException {
		driver.get(this.wikipedia);
		Thread.sleep(4000);
	//1º localizar el shadowHost
		WebElement nodoShadowHost=driver.findElement(By.id(""));
	//2º crear objeto JS
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
	//3º localizamos el shadowRoot usando el shadowHost. Si el shadowDOM estuviera closed nos devolvería NULL
		WebElement nodoShadowRoot=(WebElement)js.executeScript("return arguments[0].shadowRoot", nodoShadowHost);
			Thread.sleep(4000);
	
	//4º buscar un elemento con el nuevo shadowRoot.
			WebElement nuevo=nodoShadowRoot.findElement(By.id(""));
		
	}
	
	
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}
}
