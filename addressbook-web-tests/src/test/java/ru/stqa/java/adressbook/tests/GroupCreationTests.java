package ru.stqa.java.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java.adressbook.model.GroupData;
import ru.stqa.java.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test10");
    app.group().create(group);
    assertThat(app.group().getGroupCount(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.
            withAdded(group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
  }

  @Test
  public void tesBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test10'");
    app.group().create(group);
    assertThat(app.group().getGroupCount(), equalTo(before.size()));
    Groups after = app.group().all();


    assertThat(after, equalTo(before));
  }

}
