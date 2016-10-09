package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData(
            "First name5",
            "Middle name5",
            "Last name5",
            "address5",
            "111-222-333",
            "test5@test.com",
            "test1");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);
/*
    int max = 0;
    for (ContactData c : after) {
      if (c.getId() > max) {
        max = c.getId();
      }
    }
    int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    contact.setId(max);
 */

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
