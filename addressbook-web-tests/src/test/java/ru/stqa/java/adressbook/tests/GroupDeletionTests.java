package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    //Елси групп нет, то создается новая группа
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Set<GroupData> before = app.group().all();
    GroupData deletionGroup = before.iterator().next();
    app.group().delete(deletionGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletionGroup);
    Assert.assertEquals(before, after);

  }

}
