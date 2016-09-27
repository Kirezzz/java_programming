package ru.stqa.java.adressbook.appmanager;

import org.omg.CORBA.TypeCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.java.adressbook.model.AddressData;
import ru.stqa.java.adressbook.tests.TestBase;

/**
 * Created by Sony on 22.09.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillAddressForm(AddressData addressData) {
    type(By.name("firstname"), addressData.getFirstname());
    type(By.name("middlename"), addressData.getMiddlename());
    type(By.name("lastname"), addressData.getLastname());
    type(By.name("address"), addressData.getAddress1());
    type(By.name("home"), addressData.getTelhome());
    type(By.name("email"), addressData.getEmail1());
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitAddressCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initAddressCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.xpath("//*[@id='maintable']/tbody/tr[@name='entry'][1]/td[@class='center'][1]/input[@type='checkbox']"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//*[@type='button' and @value='Delete']"));
  }

  public void initAddressModification() {
    click(By.xpath("//*[@id='maintable']/tbody/tr[@name='entry'][1]/td[@class='center']/a[1]/img[@title='Edit']"));
  }

  public void submitAddressModification() {
    click(By.xpath("//*[@id='content']/form[1]/input[@name='update'][2]"));
  }
}
