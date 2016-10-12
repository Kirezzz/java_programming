package ru.stqa.java.adressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sony on 12.10.2016.
 */
public class Contacts extends ForwardingSet<ContactData> {
  private Set<ContactData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate());
  }

  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;
  }

  public Contacts withAdded(ContactData contact) {
   Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return  contacts;
  }

  public Contacts without(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return  contacts;
  }
}
