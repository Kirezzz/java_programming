package ru.stqa.java.adressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String address1;
  private final String telhome;
  private final String email1;
  private String group;

  public ContactData(String firstname, String middlename, String lastname, String address1, String telhome, String email1, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.address1 = address1;
    this.telhome = telhome;
    this.email1 = email1;
    this.group = group;
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

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
    if (telhome != null ? !telhome.equals(that.telhome) : that.telhome != null) return false;
    return email1 != null ? email1.equals(that.email1) : that.email1 == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (address1 != null ? address1.hashCode() : 0);
    result = 31 * result + (telhome != null ? telhome.hashCode() : 0);
    result = 31 * result + (email1 != null ? email1.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address1='" + address1 + '\'' +
            ", telhome='" + telhome + '\'' +
            ", email1='" + email1 + '\'' +
            ", group='" + group + '\'' +
            '}';

  }
}
