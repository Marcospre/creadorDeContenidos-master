package creadorContenidoShop.Inicio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import configuracionWebDriver.PageBase;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://creadordecontenidoshop.com/")
public class PageInico extends PageBase{
	
	
	
	public PageInico() {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	private String botonCookie = "//a[contains(text(),'aceptar')]";
	private String botonContacto = "//a[contains(text(),'Contacto')]";
//	@FindBy(className="cdp-cookies-boton-aviso")
//	static WebElement botonCookie;
	
	
	public void entrar(String url) {
		this.navegar(url);
		this.clickEnElElemento(botonCookie);
	}
	
	public void aContacto() {
		this.esperaQueLaPaginaCargue(20);
		this.esperaCargaAsincrona(20);
	
		
		this.clickEnElElemento(botonContacto);
	}
	
	
	

}
