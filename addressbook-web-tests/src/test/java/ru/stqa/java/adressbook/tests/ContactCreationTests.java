package ru.stqa.java.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.ContactData;
import ru.stqa.java.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/Superman_shield.png");
    ContactData contact = new ContactData()
            .withFirstname("First name5")
            .withLastname("Last name5")
            .withPhoto(photo)
            .withHomePhone("111-222-333")
            .withEmail("test5@test.com")
            .withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));//хеширование
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.
            withAdded(contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testCurrentDir() {
  File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/Superman_shield.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }
}
