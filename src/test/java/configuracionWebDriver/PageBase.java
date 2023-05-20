package configuracionWebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import crossBrowser.DriverFactory;
import crossBrowser.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBase {

	 protected static WebDriver driver=DriverFactory.getDriver(DriverType.CHROME);
	 private static WebDriverWait wait;
	
	

	public PageBase(WebDriver driver) {
		PageBase.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public static void navegar(String url) {
		driver.get(url);
	}


	//           waits
	public boolean esVisibleElElemento(String localizador) {
		return this.esperaQueEsteVisibleYlocalizado(localizador) != null;
	}

	public boolean esVisibleElElemento(WebElement localizador) {
		return this.esperaQueEsteVisibleYlocalizado(localizador) != null;
	}

	private WebElement esperaQueEsteVisibleYlocalizado(String localizador) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(localizador)));
	}

	private WebElement esperaQueEsteVisibleYlocalizado(WebElement localizador) {
		return wait.until(ExpectedConditions.visibilityOf(localizador));
	}

	private WebElement esperaQueEsteVisibleYlocalizadoPorCss(String localizador) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(localizador)));
	}

	private WebElement esperaQueEsteVisible(WebElement localizador) {
		return wait.until(ExpectedConditions.visibilityOf(localizador));
	}
	private WebElement esperaQueEstePresenteElElemento(String localizador) { //presente pero no visible
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(localizador)));
	}
	private WebElement esperaQueSeaClicable(String localizador) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(localizador)));

	}
	public List <WebElement> esperaQueElPadreBusqueAlHijo(String padre, String hijo) {
		return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(By.xpath(padre), By.xpath(hijo)));
	}
	private void esperaJavaScript() {
		wait.until(new Function<WebDriver, Object>() {
			public Object apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}
	private WebElement esperaQueRefresqueYseaClicable(String localizador) {
		this.esperaJavaScript();
		By locator = By.xpath(localizador);
		return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
	}

	private WebElement esperaQueRefresqueYseaClicable(WebElement element) {
		this.esperaJavaScript();
		return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	private WebElement esperarQueEsteDisponible(String localizador) {
		this.esperaJavaScript();
		return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(localizador))));
	}

	public void esperaQueLaPaginaCargue(int tiempo) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(tiempo));//TimeoutException
	}

	public void dameTiempoEspera() {
		System.out.println("tiempo espera " + driver.manage().timeouts().getPageLoadTimeout());
	}
	public void esperaObligada(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("marcos no ha salido bien");
		}
	}

	public void  esperaCargaAsincrona(int tiempo) {
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(tiempo));

	}
	//     sendkeys
	public void escribeEnElCampo(String xpath, String texto) {
		try {
			esperaQueRefresqueYseaClicable(xpath);
			esperaQueEsteVisibleYlocalizado(xpath).clear();
			esperaQueRefresqueYseaClicable(xpath).click();
			esperaQueEsteVisibleYlocalizado(xpath).sendKeys(texto);
		}catch(ElementNotInteractableException e) {
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(texto);
		}
	}
	//  sendkeys
	public void escribeEnElCampo(WebElement element, String texto) {
		try {
			esperaQueRefresqueYseaClicable(element);
			esperaQueEsteVisible(element).clear();
			esperaQueEsteVisible(element).sendKeys(texto);
		}catch(ElementNotInteractableException e) {
			esperaQueRefresqueYseaClicable(element);
			esperaQueEsteVisible(element).clear();
			esperaQueEsteVisible(element).sendKeys(texto);
		}
	}
	public void escribeTabulacion(String xpath) {
		try {
			esperaQueRefresqueYseaClicable(xpath);
			esperaQueEsteVisibleYlocalizado(xpath).sendKeys(Keys.TAB);

		}catch(ElementNotInteractableException e) {

			driver.findElement(By.xpath(xpath)).sendKeys(Keys.TAB);
		}
	}
	public void escribeTabulacion2(String xpath) {
		try {

			esperaQueEsteVisibleYlocalizado(xpath).sendKeys(Keys.TAB);
		}catch(ElementNotInteractableException e) {
			driver.findElement(By.xpath(xpath)).sendKeys(Keys.TAB);
		}
	}
	public void escribeTabulacion3(String xpath) {
		try {
			esperaQueEstePresenteElElemento(xpath).sendKeys(Keys.TAB);
		}catch(ElementNotInteractableException e) {
			driver.findElement(By.xpath(xpath)).sendKeys(Keys.TAB);
		}
	}

	public void escribeTabulacion(WebElement elemento) {
		try {
			esperaQueRefresqueYseaClicable(elemento).sendKeys(Keys.TAB);

		}catch(ElementNotInteractableException e) {

			esperaQueRefresqueYseaClicable(elemento).sendKeys(Keys.TAB);
		}
	}

	//         clicks
	public void clickEnElElemento(String localizador) {
		esperaQueRefresqueYseaClicable(localizador);
		esperaQueEstePresenteElElemento(localizador).click();
	}
	
	

	public void clickEnElElemento(WebElement element) {
		esperaQueRefresqueYseaClicable(element).click();
	}

	//devolver webelements
	public WebElement dameWebElement(String localizador) {
		WebElement e= esperaQueEsteVisibleYlocalizado(localizador);
		if(e!=null) {
			return e;
		}else {
			System.out.println("elemento vacio");
			return null;
		}
	}


	//tablas
	public String getValorDeLaTabla(String localizador, int fila, int columna) {
		String celda=localizador+"/table/tbody/tr["+fila+"]/td["+columna+"]";
		return esperaQueEsteVisibleYlocalizado(celda).getText();
	}

	///////pedir texto

	public String dameValorDelCampo(String localizador) {
		esperaQueEsteVisibleYlocalizado(localizador);
		return esperaQueEstePresenteElElemento(localizador).getText();
	}

	public String dameValorDelCampoConWebElement(WebElement localizador) {
		esperaQueRefresqueYseaClicable(localizador);
		return localizador.getText();
	}

	public String dameValorDelCampoInput(String localizador) {
		esperaQueEsteVisibleYlocalizado(localizador);
		return esperaQueEstePresenteElElemento(localizador).getAttribute("value");
	}

	public List <WebElement> dameTodosLosElementoHijos(String localizador, String componente) {

		WebElement elemento = this.esperaQueEsteVisibleYlocalizado(localizador);

		ArrayList<WebElement>elementos=(ArrayList<WebElement>) elemento.findElements(By.tagName(componente));

		// esperaqueSeaVisible(trs);

		return elementos;

	}

	public void escribirEnCampoTabla(WebElement elemento, String texto) {
		try {
			clickEnElElemento(elemento);
			this.esperaObligada(200);
			clickEnElElemento(elemento);
			this.esperaObligada(200);
			escribeEnElCampo(elemento, texto);
		}catch(ElementNotInteractableException e) {
			clickEnElElemento(elemento);
			this.esperaObligada(200);
			clickEnElElemento(elemento);
			this.esperaObligada(200);
			escribeEnElCampo(elemento, texto);
		}
	}

	public void escribirTabulacionEnTabla(WebElement elemento) {
		try {
			clickEnElElemento(elemento);
			this.esperaObligada(200);
			clickEnElElemento(elemento);
			this.esperaObligada(200);
			escribeTabulacion(elemento);
		}catch(ElementNotInteractableException e) {
			clickEnElElemento(elemento);
			this.esperaObligada(200);
			clickEnElElemento(elemento);
			this.esperaObligada(200);
			escribeTabulacion(elemento);
		}
	}

	public void hacerScrollHaciaAbajo() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	private List<WebElement> esperaQueEsteVisibleYlocalizadoListaWebElements(String localizador) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(localizador)));
	}

	public List<WebElement> dameListaWebElements(String localizador) {
		List<WebElement> e= esperaQueEsteVisibleYlocalizadoListaWebElements(localizador);
		return e;
	}

	public WebElement dameWebElementPorCss(String localizador) {
		WebElement e= this.esperaQueEsteVisibleYlocalizadoPorCss(localizador);
		return e;
	}

}
