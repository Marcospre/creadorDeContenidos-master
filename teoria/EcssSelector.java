package Ainiciacion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EcssSelector {

	private WebDriver driver;
	
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		driver.get("https://es.wikipedia.org/wiki/Isekai_Cheat_Magician");
		//driver.navigate().to("https://www.google.es");
	}
	
	@Test
	public void test() throws InterruptedException {

//buscar por cssSelector, usando el lenguaje JQuery
/*    
 *   elemento.(clase)
 *   elemento#(id)
 * 
 *   div#p-logo  -> busca un DIV cuyo id sea "p-logo"
 *   
 *   div.mw-parser-output   ->busca un DIV cuyo clase o css sea "mw-parser-output"
 *            >   -> un hijo
 *  p:nth-of-type(5)   ->busca el PARRAFO quinto!!!!
 *            
 * input#username  -> busca un INPUT con id username
 * 
 * [name^='com']  -> busca un elemento cuyo name EMPIEZA por "com"
 * 
 * [value$='ada']  -> busca un elemento cuyo valor TERMINA por "ada"
 * 
 * input[name^='com'][value$='ada']  -> busca un elemento input cuyo name empieza por com Y cuyo value termina por ada. CONCATENAMOS
 * 
 * a[href="https//..."]  ->devuelve el Link 
 * 
 * div[aria-labelledby="dropdown-basic"]>a[href="#/action-2"] --> Buscamos en el div un HIJO que es de tipo a
 * 
 *  img:not([alt])) -> todos los elementos IMP que NO tiene el atributo alt. Muy usado con los atributos tiene valores aleatorios
 *  
 *  ^=   input[id^='ctrl']        ->empieza por:
 *  $=   input[id$='_userName']   -> termina por
 *  *=   Input[id*='userName']    ->contiene  
 *  
 *  
 *  
 *  - Buscar por texto que contiene el elemento:
 *    td:contains('Item 1')  --> busca un elemento TD que tiene como texto "item 1". Es OBSOLETO
 *    td[innerText="Item 1"]  --> igual. NO funciona con FIREFOX
 *    td[textContent='Item 1']--> igual.
 *    
 *    
 *    
 *  
 * */		
		
		WebElement parrafo=driver.findElement(By.cssSelector("div#mw-content-text>div.mw-parser-output>p:nth-of-type(3)"));
		String texto=parrafo.getText();
		System.out.println(texto);  //CORRECTO
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
