package ru.stqa.java.adressbook.tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Sony on 16.10.2016.
 */
public class ContactDetailsTests extends TestBase {
  @Test
  public void testContactDetails() {
    app.goTo().homePage();
    ContactData contact = app.contact().allForDetails().iterator().next();
    ContactData contactInfoDetailsForm = app.contact().contactInfoDetailsForm(contact);
    assertThat(contact.getAllContactinfo(), equalTo(mergeAllContactInfo(contactInfoDetailsForm)));
  }

  private String mergeAllContactInfo(ContactData contact) {
    return Arrays.asList(contact.getLastname(),contact.getFirstname(),contact.getAddress(),
            contact.getEmail(),contact.getEmail2(),contact.getEmail3(),
            contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> s!=null && !s.equals(""))
            .map(ContactDetailsTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String details) {
    return details.replaceAll("\\s", "")
            .replaceAll("[-()]", "");
  }

}

