package ru.stqa.java.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new ContactData(
            "First name1",
            "Middle name1",
            "Last name1",
            "address1",
            "111-222-333",
            "test1@test.com",
            "test1"), true);

  }


}