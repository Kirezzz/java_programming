package ru.stqa.java.adressbook.tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Sony on 16.10.2016.
 */
public class ContactDetailsTests extends TestBase {
  @Test
  public void testContactDetails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();

    ContactData contactInfoDetailsForm = app.contact().contactInfoDetailsForm(contact);
    MatcherAssert.assertThat(contact.getAllContactinfo(), Matchers.equalTo(mergeAllContactInfo(contactInfoDetailsForm)));

  }

  private String mergeAllContactInfo(ContactData contact) {
    return Arrays.asList(contact.getLastname(),contact.getFirstname(),contact.getAddress(),
            contact.getEmail(),contact.getEmail2(),contact.getEmail3(),
            contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            //.map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  /*public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
  */
}

