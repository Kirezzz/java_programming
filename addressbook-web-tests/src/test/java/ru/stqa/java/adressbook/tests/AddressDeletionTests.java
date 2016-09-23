package ru.stqa.java.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Sony on 23.09.2016.
 */
public class AddressDeletionTests extends TestBase {
  @Test
  public void testAddressDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptAlert();
  }
}
