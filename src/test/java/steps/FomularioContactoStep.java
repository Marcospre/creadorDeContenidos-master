package steps;

import creadorContenidoShop.Contacto.RellenarFormulario;
import creadorContenidoShop.Contacto.VerificarFormulario;
import creadorContenidoShop.Inicio.Navega;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
//import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;
//import static org.junit.jupiter.api.Assertions.assertTrue;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelos.Contacto;



public class FomularioContactoStep {
	
	//mvn test -Dbrowser=chrome

	//declaramos las accciones de las paginas que van a intervenir en la prueba
	Contacto contacto;
	
	Navega navega = new Navega();  //corresponde a la pagina inicio
	
	RellenarFormulario rellenarFormulario = new RellenarFormulario();
	
	VerificarFormulario verificarFormulario = new VerificarFormulario();

	

	@Given("el cliente entra en la pagina principal")
	public void el_cliente_entra_en_la_pagina_principal() {
	navega.entrarPaginaPrincipal();
	}
	@Given("se dirige a la pagina Contacto")
	public void se_dirige_a_la_pagina_contacto() {
	 navega.aPaginaContacto();  
	}
//	@When("rellena los datos del formulario correctamente")
//	public void rellena_los_datos_del_formulario_correctamente() throws InterruptedException {
//	rellenarFormulario.conDatosCorrectos();
//	}
	@When("rellena los datos del formulario nombre {string}, email {string}, titulo {string}, mensaje {string}")
	public void rellena_los_datos_del_formulario_nombre_email_titulo_mensaje(String string, String string2, String string3, String string4) {
		contacto = new Contacto(string);
		rellenarFormulario.conDatos(string,string2,string3,string4);
	}
	@Then("aparece el mensaje correspondiente")
	public void aparece_el_mensaje_correspondiente() {
		assertTrue(verificarFormulario.comprobarEnvio());
		assertEquals(verificarFormulario.devolverMensaje(),"Gracias por tu mensaje. Ha sido enviado.");
	}
	

	


	
	


}