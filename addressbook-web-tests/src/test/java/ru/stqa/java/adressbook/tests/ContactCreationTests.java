package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("First name5")
            .withMiddlename("Middle name5")
            .withLastname("Last name5")
            .withAddress1("address5")
            .withTelhome("111-222-333")
            .withEmail1("test5@test.com")
            .withGroup("test1");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }


}
