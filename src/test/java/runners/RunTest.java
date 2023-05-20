package runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = {"pretty"},
		features="src/test/resources/features/FormularioContacto.feature",  //indicamos donde se almacena nuestro archivo feature que va a realizar la prueba
		glue= "steps", //unir feature con java
		tags="@escenario2"
	
)	
public class RunTest {
	
	
}
