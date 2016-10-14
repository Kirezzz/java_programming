package ru.stqa.java.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;
import ru.stqa.java.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
            .withAddress("address5")
            .withHomePhone("111")
            .withMobilePhone("222")
            .withWorkPhone("333")
            .withEmail("test5@test.com")
            .withGroup("test1");
    if (app.contact().list().size() == 0) {
      app.contact().create(contact, true);
    }

  }

  @Test
  public void testContactDeletion() {

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().getContactCount(), equalTo(before.size() - 1));//хеширование
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));

    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
