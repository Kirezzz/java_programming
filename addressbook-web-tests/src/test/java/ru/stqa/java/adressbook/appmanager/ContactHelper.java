package ru.stqa.java.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.java.adressbook.model.ContactData;

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


  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.xpath("//*[@id='maintable']/tbody/tr[@name='entry'][1]/td[@class='center'][1]/input[@type='checkbox']"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//*[@type='button' and @value='Delete']"));
  }

  public void initContactModification() {
    click(By.xpath("//*[@id='maintable']/tbody/tr[@name='entry'][1]/td[@class='center']/a[1]/img[@title='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("//*[@id='content']/form[1]/input[@name='update'][2]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//*[@id='maintable']/tbody/tr[@name='entry'][1]/td[@class='center'][1]/input[@type='checkbox']"));
  }

  public void createContact(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    returnToHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
