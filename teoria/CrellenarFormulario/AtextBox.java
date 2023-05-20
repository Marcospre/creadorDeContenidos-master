package CrellenarFormulario;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 			textBox
 * Ejemplo: realizar una búsqueda mediante una caja de texto.
 * 
 * pasos:
 * 1º identificar la caja de texto
 * 2º identificar el botón que al pulsarlo realiza la búsqueda
 * 3º rellenar la caja de texto
 * 4º pulsar el botón enviar.
 * 
 * 
 * */


public class AtextBox {

	private WebDriver driver;
	
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		// ruta normal puede usar la rutaFirefox, pero no al revés.
		String rutaNormal="C:/Users/mraralma/OneDrive%20-%20IBERMATICA%20S.A/Escritorio/FUNCIONALES/curso%20Iberm%C3%A1tica/selenium%20con%20java%20para%20principiantes/index_completo.html";
		String rutaFirefox="file:///C:/Users/mraralma/OneDrive%20-%20IBERMATICA%20S.A/Escritorio/FUNCIONALES/curso%20Iberm%C3%A1tica/selenium%20con%20java%20para%20principiantes/index_completo.html";
		String wikipedia="https://www.wikipedia.es";
		driver.get(wikipedia);
	}

	
	
	@Test
	public void test() throws InterruptedException {

		WebElement cajaBusqueda=driver.findElement(By.id("searchInput"));
		WebElement botonBuscar=driver.findElement(By.id("searchButton"));
		
		cajaBusqueda.sendKeys("selenium");
		Thread.sleep(2000);
		botonBuscar.click();
		String tituloDeseado="Wikipedia";
		String titulo=driver.getTitle();
		if(tituloDeseado.equals(titulo)) {
			System.out.println("coinciden");
		}else {
			System.out.println("NO coinciden");
		}
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
