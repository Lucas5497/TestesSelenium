package br.ce.lopes.core;

import static br.ce.lopes.core.DriverFactory.getDriver;
import static br.ce.lopes.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		Files.copy(arquivo, new File("imagens" + File.separator + "screenshot/" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
		killDriver();
		}
	}
}