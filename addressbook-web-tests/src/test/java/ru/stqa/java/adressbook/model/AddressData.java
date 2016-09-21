package ru.stqa.java.adressbook.model;

public class AddressData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String address1;
  private final String telhome;
  private final String email1;

  public AddressData(String firstname, String middlename, String lastname, String address1, String telhome, String email1) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.address1 = address1;
    this.telhome = telhome;
    this.email1 = email1;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress1() {
    return address1;
  }

  public String getTelhome() {
    return telhome;
  }

  public String getEmail1() {
    return email1;
  }
}
