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

/* 			ComboBox Simple o Menú Desplegable para React y Bootstrap.   *es diferente marcos
 * Es de tipo Button, hay que hacer cick para que salga las opciones
 * Necesitamos esperar un tiempo para que carguen las opciones.
 * 
 * Las opciones son de tipo A (enlaces), y son hijos de un Div.
 * 
 * 
 * */


public class CcomboBoxSimpleReactBootstrap {

	private WebDriver driver;
	private By botonComboBoxBootstrap=By.id("dropdown-basic");
	private By opcionMarcada=By.cssSelector("div[aria-labelledby=\"dropdown-basic\"]>a[href=\"#/action-2\"]"); //Another action
	
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		// 
		String bootstrap="https://react-bootstrap.github.io/components/dropdowns/";
		driver.get(bootstrap);
	}

	
	
	@Test
	public void test() throws InterruptedException  {
		WebElement boton=driver.findElement(botonComboBoxBootstrap);
     boton.click();
     Thread.sleep(2000);
     WebElement enlaceMarcado=driver.findElement(opcionMarcada);
     enlaceMarcado.click();
     
	 assertEquals("Another action", enlaceMarcado.getAttribute("innerText"));
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
