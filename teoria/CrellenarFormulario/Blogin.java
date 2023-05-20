package CrellenarFormulario;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 			login
 * Ejemplo: logarnos correctamente
 * 
 * pasos:
 * 1º identificar la caja de texto nombre por ID
 * 2º identificar la caja de texto password por xpath
 * 3º rellenar las dos cajas
 * 4º identificar boton enviar 
 * 5º pulsar el botón enviar.
 * 
 * 
 * */


public class Blogin {

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
		driver.get(rutaNormal);
	}

	
	
	@Test
	public void test() throws InterruptedException {

		WebElement inputNombre=driver.findElement(By.cssSelector("input#username"));
		WebElement inputPassword=driver.findElement(By.xpath("//input[@id=\"password\"]"));
		WebElement botonLogin=driver.findElement(By.id("botonLogin"));
		inputNombre.sendKeys("usuario");
		inputPassword.sendKeys("password");		
		Thread.sleep(2000);
		botonLogin.click();
		Thread.sleep(2000);  ///CORRECTO!!!
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
