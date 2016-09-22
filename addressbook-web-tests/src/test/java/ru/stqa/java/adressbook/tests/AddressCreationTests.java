package ru.stqa.java.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.AddressData;

public class AddressCreationTests extends TestBase {

  @Test
  public void testAddressCreation() {
    app.getContactHelper().initAddressCreation();
    app.getContactHelper().fillAddressForm(new AddressData("First name1", "Middle name1", "Last name1", "address1", "111-222-333", "test1@test.com"), AddressCreationTests.this);
    app.getContactHelper().submitAddressCreation();
    app.getContactHelper().returnToHomePage();
  }


}
