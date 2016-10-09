package ru.stqa.java.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.java.adressbook.model.ContactData;

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
    type(By.name("address"), contactData.getAddress1());
    type(By.name("home"), contactData.getTelhome());
    type(By.name("email"), contactData.getEmail1());
    //Если тест создания, то заполняем поле группы, иначе игнорируем заполнение
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void modify(int index, ContactData contact) {
   initContactModification(index);
   fillContactForm(contact, false);
   submitContactModification();
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

  public void deleteSelectedContact() {
    click(By.xpath("//*[@type='button' and @value='Delete']"));
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    acceptAlert();

  }

  public void initContactModification(int index) {
    wd.findElements((By.xpath("//*[@id='maintable']//img[@title='Edit']"))).get(index).click();
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
      ContactData contact = new ContactData(id, firstname, null, lastname, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
