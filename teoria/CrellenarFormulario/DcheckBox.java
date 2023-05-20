package CrellenarFormulario;


import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 			Checkbox
 * - Se almacenan en una lista WebElement mediante .findElementssssssss(NAME)
 * - Se puede marcar uno o más checkbox haciendo click
 * - Se puede desmarcar uno o más checkbox haciendo click
 * - Se puede verificar el estado del checkbox, isSelected()
 * */


public class DcheckBox {

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

		List <WebElement> checkboxs=driver.findElements(By.name("listaCompra"));
		WebElement botonCheckBoxes=driver.findElement(By.id("enviaCheckboxes"));
	
		for(WebElement elemento:checkboxs) {
			elemento.click();
			Thread.sleep(1000);
		}
		System.out.println("_-_-_-_-_-_-_-_-_-_");
		checkboxs.get(0).click();
		Thread.sleep(1000);
		
		for(WebElement e:checkboxs) {
			System.out.println(e.isSelected());
			Thread.sleep(1000);
		}
	
		 botonCheckBoxes.click();  //CORRECTO!!!!!!!
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
