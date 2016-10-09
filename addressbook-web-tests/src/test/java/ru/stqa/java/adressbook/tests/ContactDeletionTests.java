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
    app.goTo().homePage();
    //Если контактов нет, то создается контакт
    ContactData contact = new ContactData(
            "First name1",
            "Middle name1",
            "Last name1",
            "address1",
            "111-222-333",
            "test1@test.com",
            "test1");
    if (app.contact().list().size() == 0) {
      app.contact().create(contact, true);
    }

  }

  @Test
  public void testContactDeletion() {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
