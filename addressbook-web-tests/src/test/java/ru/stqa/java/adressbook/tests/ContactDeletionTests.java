package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

import java.util.List;
import java.util.Set;

/**
 * Created by Sony on 23.09.2016.
 */
public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    //Если контактов нет, то создается контакт
    ContactData contact = new ContactData()
            .withFirstname("First name5")
            .withMiddlename("Middle name5")
            .withLastname("Last name5")
            .withAddress1("address5")
            .withTelhome("111-222-333")
            .withEmail1("test5@test.com")
            .withGroup("test1");
    if (app.contact().list().size() == 0) {
      app.contact().create(contact, true);
    }

  }

  @Test
  public void testContactDeletion() {

    Set<ContactData> before = app.contact().all();
    ContactData deletionContact = before.iterator().next();
    app.contact().delete(deletionContact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletionContact);
    Assert.assertEquals(before, after);
  }

}
