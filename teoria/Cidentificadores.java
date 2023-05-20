package Ainiciacion;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*   LOCALIZADORES
 * 
 * - Hay un total de 9:
 *  By.id()
 *  By.name(string) ->nombre de los elementos
 *  By.className()  -> hace referencia al atributo class del elemento. Suele haber varios elementos, y devolverá una LISTA. Son usado para CSS
 *  By.tagName() -> devuelve un elemento HTML (title, h2,...), suele devolver una LISTA. Muy util para TABLAS y sus <tr>
 *  By.linkText()-> devuelve el elemento que coincida con el texto del LINK. Util para enlaces
 *  By.partialLinkText()
 *  By.ccsSelector()
 *  By.xpath()
 *  JavascriptExecutor js=(JavascriptExecutor) driver
 * 
 * 
 * - los más usados son:
 *    id: en caso de no tener id, usar name.
 *    name: no suele ser único.
 *    className: NO suele ser único.se utiliza para CSS
 *    
 * - Es más fiable los CSS que los Xpath  
 *    
 * -La clase WebElement también admite métodos de búsqueda que encuentran elementos secundarios. Por ejemplo,
	imagine que hay algunos elementos duplicados en una página. Sin embargo, están ubicados en
	elementos <div> separados. Primero podemos ubicar el elemento padre <div> y luego ubicar
	el elemento secundario dentro del contexto del elemento <div> de la siguiente manera:
		WebElement div = controlador.findElement(By.id("div1"));
		WebElement topLink = div.findElement(By.linkText("top"));
	También puede usar un método abreviado de la siguiente manera:
		WebElement enlace superior = controlador.findElement (By.id("div1")).findElement(By.linkText("arriba"));
		
		
	- Excepción NoSuchElementFoundExceptio: Los métodos findElement() y FindElements() lanzan esta excepcion cuando no pueden encontrar el deseado	
		
		
	- findElementsss(): se utiiza para enlaces, obtener filas de una tabla..	
 * */
public class Cidentificadores {
 
	private WebDriver driver; 
	private By id=By.id("n-randompage");
	private By ccsSelector=By.cssSelector("div#main-tga>p");
	private By linkText=By.linkText("Página aleatoria");
	private By tagName=By.tagName("title");
	private By xpath= By.xpath("//*[@id=\"p-logo\"]/a");
	private By localizadorEnlaces=By.xpath("(//div[@class=\"vector-menu-content\"])[6]/descendant::a");
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		driver.get("https://www.wikipedia.es");
		//driver.navigate().to("https://www.google.es");
	}
	
	@Test
	public void testBuscarTituloEnlacePaginaAleatoria(){
		//buscar el enlace "Página aleatoria" por ID y hacer click.,    texto del enlace->enlace.getAttribute("innerText"));
		//OJO!! es un enlace que está dentro de una lista, nosotros buscamos el id de la lista.
				driver.findElement(id).click();
				String titulo=driver.getTitle();
				System.out.println(titulo);  //Castillo Dolbadarn - Wikipedia, la enciclopedia libre
			
	}
	
	@Test
	public void testBuscarLinkText(){
		  //buscar por LinkText
		driver.findElement(linkText).click();
		String titulo=driver.getTitle();
		System.out.println(titulo);  //ok
		
	}
	
	@Test
	public void testBuscarTagName() {
		//buscar por tagName   
		  // nos devuelve el primer elemento html que encuentre. Esto no es seguro.
		     // es mejor almacenar una lista de elementos que cumpla una condición
			// para ello utilizaremos  findElements(By.tagName("elemento HTML")
			WebElement paginaAleatoria= driver.findElement(By.tagName("title"));
			String tituloDeseado= paginaAleatoria.getAttribute("innerText"); //buscamos el atributo innerText de la página.
			String tituloObtenido=driver.getTitle();
			System.out.println("soy el atributo innerText: " + tituloDeseado); //soy el atributo innerText: Wikipedia, la enciclopedia libre
			System.out.println(tituloObtenido);  //Wikipedia, la enciclopedia libre
			assertEquals(tituloDeseado,tituloObtenido,"No son el mismo título");

	}
	
	@Test
	public void testBuscarXpath() {
		//buscar por xpath.    abrir inspeccionar, ctrol F

		WebElement enlace= driver.findElement(xpath);
		enlace.click();
		WebElement enlaceVerificacion= driver.findElement(xpath);
		String titulo2=enlaceVerificacion.getAttribute("title");
		System.out.println(titulo2);  //Wikipedia:Bienvenidos. CORRECTO!!
	}
	@Test
	public void testBuscarCssSelecto(){	
		//buscar por cssSelector  utilizamos la sintaxis de JQuery
		WebElement parrafo=driver.findElement(ccsSelector);
		String texto=parrafo.getText();
		System.out.println(texto); //CORRECTO!!!
	}
	
	@Test
	public void testMultiplesElementos(){
		//buscamos una lista de enlaces, verificamos su tamaño. Sabemos que en total hay 9
		List <WebElement> enlaces=driver.findElements(localizadorEnlaces);
		 assertEquals(9, enlaces.size(), "No tiene el 9 enlaces");
		 
		 //vamos a mostrar por pantalla los enlaces con la propiedad href
		 for(WebElement link : enlaces)
			 System.out.println(link.getAttribute("href"));
	
	
	}
	
	@AfterEach
	public void tearDown(){
		driver.quit();
	}

}
