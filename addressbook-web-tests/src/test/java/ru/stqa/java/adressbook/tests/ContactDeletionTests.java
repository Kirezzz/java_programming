package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

import java.util.List;

/**
 * Created by Sony on 23.09.2016.
 */
public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    //Если контактов нет, то создается контакт
    ContactData contact = new ContactData(
            "First name1",
            "Middle name1",
            "Last name1",
            "address1",
            "111-222-333",
            "test1@test.com",
            "test1");
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(contact, true);
    }

  }

  @Test(enabled = false)
  public void testContactDeletion() {

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptAlert();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
