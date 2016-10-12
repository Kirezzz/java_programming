package ru.stqa.java.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;
import ru.stqa.java.adressbook.model.Contacts;
import ru.stqa.java.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
            .withAddress1("address5")
            .withTelhome("111-222-333")
            .withEmail1("test5@test.com")
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
            .withAddress1("address2")
            .withTelhome("111-000-333")
            .withEmail1("test2@test.com");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()));

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
