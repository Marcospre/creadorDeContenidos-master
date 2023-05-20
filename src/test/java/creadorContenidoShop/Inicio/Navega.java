package creadorContenidoShop.Inicio;

public class Navega {
	
	creadorContenidoShop.Inicio.PageInico inicio = new creadorContenidoShop.Inicio.PageInico();

//	@Step("el cliente entra en la pagina principal")
	public void entrarPaginaPrincipal() {
		inicio.entrar("https://creadordecontenidoshop.com/");
	}
	
//	@Step("se dirige a la patina contacto")
	public void aPaginaContacto() {
		inicio.aContacto();
	}
}
