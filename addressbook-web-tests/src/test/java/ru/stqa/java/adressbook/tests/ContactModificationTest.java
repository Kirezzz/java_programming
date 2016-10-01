package ru.stqa.java.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

/**
 * Created by Sony on 24.09.2016.
 */
public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    //Если контактов нет, то создается контакт
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(
              "First name1",
              "Middle name1",
              "Last name1",
              "address1",
              "111-222-333",
              "test1@test.com",
              "test1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData(
            "First name1",
            "Middle name1",
            "Last name1",
            "address2",
            "111-000-333",
            "test2@test.com",
            null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
