package CrellenarFormulario;



import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 		DatePicker     calendario
 * 
 * ejemplo: seleccionar la fecha 15-12-1980 a las 10:30h.
 * 
 * pasos:
 * - Identificar el elemento calendario.
 * - Introducir la fecha.
 * - Pulsar TABULADOR para seleccionar la hora.
 * - introducir la hora
 * 
 * 
 * */


public class Fcalendario_Datepicker {

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


		WebElement datePicker=driver.findElement(By.xpath("//input[@name='fecha']"));
		
	
		Thread.sleep(2000);
		datePicker.sendKeys("15121980"+ Keys.TAB + "1030");
		Thread.sleep(2000);
		
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
