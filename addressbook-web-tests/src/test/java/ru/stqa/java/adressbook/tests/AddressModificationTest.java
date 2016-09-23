package ru.stqa.java.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.AddressData;

/**
 * Created by Sony on 24.09.2016.
 */
public class AddressModificationTest extends TestBase {
  @Test
  public void testAddressModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initAddressModification();
    app.getContactHelper().fillAddressForm(new AddressData("First name1", "Middle name1", "Last name1", "address1", "111-222-333", "test1@test.com"));
    app.getContactHelper().submitAddressModification();
    app.getContactHelper().returnToHomePage();
  }
}
