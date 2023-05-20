package creadorContenidoShop.Contacto;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class VerificarFormulario extends UIInteractionSteps {
	
	PageContacto pageContacto = new PageContacto();
		public boolean comprobarEnvio() {
//			WebDriverWait espera=new WebDriverWait(pageContacto.getDriver(),Duration.ofSeconds(5));
//		   String texto=espera.until(ExpectedConditions.visibilityOf(PageContacto.contenedorMensajeEnviado)).getText();
			boolean esEnviado=false;
			
			String texto = pageContacto.devolverMensaje();
			if(texto.equalsIgnoreCase("Gracias por tu mensaje. Ha sido enviado.")) {
				esEnviado=true;
				return esEnviado;
			}else {
				return esEnviado;
			}
		}
		
		public String devolverMensaje() {
			return  pageContacto.devolverMensaje();
		}
}
