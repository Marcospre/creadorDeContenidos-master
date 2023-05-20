package creadorContenidoShop.Contacto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class RellenarFormulario extends UIInteractionSteps{

	PageContacto pageContacto = new PageContacto();
//	@Step("el usuario rellena los datos del formulario")
//	
//	public void conDatosCorrectos() throws InterruptedException {
////		Thread.sleep(2000);
////		PageContacto.campoNombre.sendKeys("marcos");
////		Thread.sleep(2000);
////		PageContacto.campoEmail.sendKeys("marcos@gmail.com");
////		Thread.sleep(2000);
////		PageContacto.campoTitulo.sendKeys("Saludar");
////		Thread.sleep(2000);
////		PageContacto.campoMensaje.sendKeys("querido marcos........");
////		
////		PageContacto.botonEnviar.click();
////		Thread.sleep(2000);
//	}

//	public boolean comprobarEnvio() {
//		WebDriverWait espera=new WebDriverWait(pageContacto.getDriver(),Duration.ofSeconds(5));
//	   String texto=espera.until(ExpectedConditions.visibilityOf(PageContacto.contenedorMensajeEnviado)).getText();
//		boolean esEnviado=false;
//		if(PageContacto.contenedorMensajeEnviado.getText().equalsIgnoreCase("Gracias por tu mensaje. Ha sido enviado.")) {
//			esEnviado=true;
//			return esEnviado;
//		}else {
//			return esEnviado;
//		}
//	}
	public void conDatos(String string, String string2, String string3, String string4) {
		
//		pageContacto.rellenarFormulario(string, string2, string3, string4);
		pageContacto.escribreEnElCampoNombre(string);
		pageContacto.escribreEnELCampoEmail(string2);
		pageContacto.escribeEnElCampoTitulo(string3);
		pageContacto.escribeEnElCampoMensaje(string4);
		pageContacto.pulsarEnviar();
//		PageContacto.campoNombre.sendKeys(string);
//		PageContacto.campoEmail.sendKeys(string2);
//		PageContacto.campoTitulo.sendKeys(string3);
//		PageContacto.campoMensaje.sendKeys(string4);
//		PageContacto.botonEnviar.click();
		
	}
}
