package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;
import ru.stqa.java.adressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 23.09.2016.
 */
public class ContactDeletionTests extends TestBase {
  @Test
  public void testContactDeletion() {
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
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptAlert();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
