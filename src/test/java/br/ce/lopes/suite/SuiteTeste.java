package br.ce.lopes.suite;
import static br.ce.lopes.core.DriverFactory.killDriver;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import br.ce.lopes.test.TesteAlertPrompt;
import br.ce.lopes.test.TesteCadastro;
import br.ce.lopes.test.TesteCampoTreinamento;
import br.ce.lopes.test.TesteDeEspera;
import br.ce.lopes.test.TesteFramesEJanelas;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteCampoTreinamento.class,
	TesteFramesEJanelas.class,
	TesteAlertPrompt.class,
	TesteDeEspera.class
})
public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo() {
	killDriver();	
	}
}
