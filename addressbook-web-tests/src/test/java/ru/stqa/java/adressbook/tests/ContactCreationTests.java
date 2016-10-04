package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;
import ru.stqa.java.adressbook.model.GroupData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData(
            "First name2",
            "Middle name2",
            "Last name2",
            "address2",
            "111-222-333",
            "test1@test.com",
            "test1"), true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }


}
