package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

import java.util.List;

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

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
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
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
