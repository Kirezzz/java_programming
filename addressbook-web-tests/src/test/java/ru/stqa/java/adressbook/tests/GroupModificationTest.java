package ru.stqa.java.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.GroupData;
import ru.stqa.java.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sony on 23.09.2016.
 */
public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    //Елси групп нет, то создается новая группа
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
}

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    assertThat(app.group().getGroupCount(), equalTo(before.size()));
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }

}
