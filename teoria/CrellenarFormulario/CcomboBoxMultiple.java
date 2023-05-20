package CrellenarFormulario;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/* 			ComboBox Multiple o Menú Desplegable.   *es diferente marcos
 * Se almacena en un objeto Select
 * Se puede elegir 1 o más opciones
 * Ejemplo: Seleccionar un elemento del menú desplegable
 * pasos:
 * 1º Identificar el comboBox o menu desplegable.
 * 2º seleccionar el valor deseado mediante el índice, el valor o el texto asociado
 * 
 * */
 

public class CcomboBoxMultiple {

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
      //Se almacena en  un SELECT
		Select comboBoxMultiple= new Select(driver.findElement(By.id("combobox2")));
	//las opciones que tenemos son seleccionar o deseleccionar
		//hay 3 formas de seleccionar
		comboBoxMultiple.selectByIndex(0);  // es el primero
		Thread.sleep(2000);
		comboBoxMultiple.selectByValue("granada");
		Thread.sleep(2000);
		comboBoxMultiple.selectByVisibleText("Plátano");
		Thread.sleep(2000);
		// hay 4 formas para deseleccionar, la nueva es deseleccionar todo()
		comboBoxMultiple.deselectByIndex(0);
		Thread.sleep(2000);
		comboBoxMultiple.deselectByValue("granada");
		Thread.sleep(2000);
		comboBoxMultiple.deselectByVisibleText("Plátano");
		Thread.sleep(2000);
		//comboBoxMultiple.deselectAll();
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
