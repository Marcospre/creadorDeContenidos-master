package creadorContenidoShop.Contacto;

import configuracionWebDriver.PageBase;

public class PageContacto extends PageBase{
	
	
	public PageContacto() {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String campoNombre = "(//input[contains(@class,'wpcf7-form-control wpcf7-text')])[1]";
	private String campoEmail = "(//input[@name='your-email'])[1]";
	private String campoTitulo = "(//input[@name='your-subject'])[1]";
	private String campoMensaje = "(//textarea[@name='your-message'])[1]";
	private String botonEniviar = "(//input[@value='Enviar'])[1]";
	private String contenedorMensajeEnviado = "(//form[@data-status='sent']//div)[2]";


	
	public void escribreEnElCampoNombre(String nombre){
		this.escribeEnElCampo(campoNombre, nombre);
	}
	
	public void escribreEnELCampoEmail(String email) {
		this.escribeEnElCampo(campoEmail, email);
	}
	
	public void escribeEnElCampoTitulo(String titulo) {
		this.escribeEnElCampo(campoTitulo, titulo);
	}
	
	public void escribeEnElCampoMensaje(String mensaje) {
		this.escribeEnElCampo(campoTitulo, mensaje);
	}
	
	public void pulsarEnviar() {
		this.clickEnElElemento(botonEniviar);
	}
	
	public String devolverMensaje() {
		return this.dameValorDelCampo(contenedorMensajeEnviado);
	}
	public void rellenarFormulario(String string, String string2, String string3, String string4) {
		
		this.escribeEnElCampo(campoNombre, string);
		this.escribeEnElCampo(campoEmail, string2);
		this.escribeEnElCampo(campoTitulo, string3);
		this.escribeEnElCampo(campoMensaje, string4);
		this.clickEnElElemento(botonEniviar);
		
	}
}
