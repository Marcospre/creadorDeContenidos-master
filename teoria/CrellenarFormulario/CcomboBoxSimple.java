 package CrellenarFormulario;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/* 			ComboBox Simple o Menú Desplegable.   *es diferente marcos
 * Se almacena en un objeto Select
 * SÓLO puedes elegir 1 opción
 * Ejemplo: Seleccionar un elemento del menú desplegable
 * pasos:
 * 1º Identificar el comboBox o menu desplegable.
 * 2º seleccionar el valor deseado mediante el índice, el valor o el texto asociado
 * 
 * */


public class CcomboBoxSimple {

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
	public void test() throws InterruptedException  {
      //Se almacena en  un SELECT
		Select comboBoxSimple= new Select(driver.findElement(By.id("combobox1")));
	//las opciones que tenemos son seleccionar.No deseleccionar, daría una exception UnsupportedOperarionException
		//hay 3 formas de seleccionar
		comboBoxSimple.selectByIndex(0);  // es el primero
		Thread.sleep(2000);
		comboBoxSimple.selectByValue("huevos");
		Thread.sleep(2000);
		comboBoxSimple.selectByVisibleText("Leche");
		Thread.sleep(2000);
		try {
			comboBoxSimple.deselectByVisibleText("Leche");
			Thread.sleep(2000);
		}catch(UnsupportedOperationException e) {
			System.out.println(e.getMessage());
			System.out.println("No puedes deseleccionar en un comboBox simple");
		}
		//almacenar el valor de la opción seleccionada
		String valor=comboBoxSimple.getFirstSelectedOption().getText();
		System.out.println("el valor es: " + valor);
		assertEquals("Leche", valor);
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
