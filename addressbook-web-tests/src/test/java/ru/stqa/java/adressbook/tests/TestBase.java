package ru.stqa.java.adressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.java.adressbook.appmanager.ApplicationManager;

/**
 * Created by Sony on 21.09.2016.
 */
public class TestBase {

  protected ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
