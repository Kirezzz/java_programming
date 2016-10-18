package ru.stqa.java.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;
import ru.stqa.java.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sony on 24.09.2016.
 */
public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    //Если контактов нет, то создается контакт
    ContactData contact = new ContactData()
            .withFirstname("First name5")
            .withMiddlename("Middle name5")
            .withLastname("Last name5")
            .withAddress("address5")
            .withHomePhone("111-222-333")
            .withEmail("test5@test.com")
            .withGroup("test1");
    if (app.contact().list().size() == 0) {
      app.contact().create(contact, true);
    }

  }

  @Test
  public void testContactModification() {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("First name1")
            .withMiddlename("Middle name1")
            .withLastname("Last name1")
            .withAddress("address2");
    app.contact().modify(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size()));//хеширование
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()));

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
