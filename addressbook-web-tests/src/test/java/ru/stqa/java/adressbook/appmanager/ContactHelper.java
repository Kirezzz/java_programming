package ru.stqa.java.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.java.adressbook.model.ContactData;
import ru.stqa.java.adressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 22.09.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, Boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail());
    type(By.name("email3"), contactData.getEmail());
    //Если тест создания, то заполняем поле группы, иначе игнорируем заполнение
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void modify(ContactData contact) {
   initContactModificationById(contact.getId());
   fillContactForm(contact, false);
   submitContactModification();
   contactCache = null;
   returnToHomePage();
  }


  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("//*[@id='maintable']//input[@type='checkbox']")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    //wd.findElement(By.xpath("//*[@id='maintable']//input[@type='checkbox']")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//*[@type='button' and @value='Delete']"));
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    acceptAlert();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    acceptAlert();
    contactCache = null;
  }

  public void initContactModification(int index) {
    wd.findElements((By.xpath("//*[@id='maintable']//img[@title='Edit']"))).get(index).click();
  }

  public ContactData infoFormEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withAddress(address)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  public void initContactModificationById(int id) {
    wd.findElement((By.cssSelector("a[href='edit.php?id=" + id + "']"))).click();
  }

  public void submitContactModification() {
    click(By.xpath("//*[@id='content']/form[1]/input[@name='update'][2]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//*[@id='maintable']/tbody/tr[@name='entry'][1]/td[@class='center'][1]/input[@type='checkbox']"));
  }

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.xpath("//*[@id='maintable']//input[@type='checkbox']")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      ContactData contact = new ContactData()
              .withId(id).withFirstname(firstname).withLastname(lastname);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String[] emails = cells.get(4).getText().split("\n");
      String[] phones = cells.get(5).getText().split("\n");
      ContactData contact = new ContactData()
              .withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2])
              .withEmail(emails[0]).withEmail2(emails[1]).withEmail3(emails[2]);
      contactCache.add(contact);
    }
    return contactCache;
  }



}
