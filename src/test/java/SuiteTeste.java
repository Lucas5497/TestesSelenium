import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteCampoTreinamento.class,
	TesteFramesEJanelas.class,
	TesteAlertPrompt.class,
	TesteDeEspera.class
})
public class SuiteTeste {

}
