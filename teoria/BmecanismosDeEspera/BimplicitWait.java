package BmecanismosDeEspera;



import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*   Implicit Wait
 * 
 *  - Se declara al inicio del script
 *  - Se aplica a todos los elementos desde el momento que se declare.
 *  - Por defecto su tiempo de espera es 0.
 *  - Selenium irá consultando en el DOM hasta que se agote el tiempo límite especificado
 *  
 *  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 * 
 * 
 * */
public class BimplicitWait {

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
		//CONFIGURAMOS LA INSTANCIA DE WEBDRIVER AGREGANDO UNA ESPERA IMPLÍCITA DE 10 SEGUNDOS
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
//este botón está programado para que se cargue 3 segundos después de cargar la página.
		// por tanto el implicitWait debe ser como mínimo de 3 segundos o más para que no nos de error
		WebElement botonImplicitWait=driver.findElement(By.id("implicitWaitButton"));
		botonImplicitWait.click();
		Thread.sleep(4000);

		
	
		
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
