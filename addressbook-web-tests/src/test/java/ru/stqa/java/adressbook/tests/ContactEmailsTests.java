package ru.stqa.java.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Sony on 14.10.2016.
 */
public class ContactEmailsTests extends TestBase {
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
            .withEmail2("test6@test.com")
            .withEmail3("test7@test.com")
            .withGroup("test1");
    if (app.contact().list().size() == 0) {
      app.contact().create(contact, true);
    }
  }
    @Test
    public void testContactEmails() {
      app.goTo().homePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFormEditForm = app.contact().infoFormEditForm(contact);

      assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFormEditForm)));

    }

  private String mergeEmails(ContactData contact) {
   return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }


}


