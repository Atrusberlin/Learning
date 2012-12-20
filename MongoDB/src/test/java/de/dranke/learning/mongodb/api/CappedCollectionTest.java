package de.dranke.learning.mongodb.api;

import com.mongodb.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 20.12.12
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class CappedCollectionTest {

  public static final String DB_TEST = "test";
  public static final int MAX_ITEM_COUNT = 10;
  private Mongo connection;
  private DB db;
  private DBCollection collection;

  @BeforeMethod
  public void setUp() throws Exception {
    connection = new Mongo();
    db = connection.getDB(DB_TEST);
    collection = createCollection();
  }

  private DBCollection createCollection() {
    BasicDBObject options = new BasicDBObject();
    options.put("capped", true);
    options.put("size", 1024);
    options.put("max", MAX_ITEM_COUNT);
    return db.createCollection("cappedCollection", options);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    collection.drop();
  }

  @Test
  public void createCappedCollection() {

    assertThat(collection.getStats().get("max")).isEqualTo(MAX_ITEM_COUNT);

  }

  @Test
  public void first_entry_will_be_removed_if_the_11th_entry_was_put() throws Exception {

    // when
    String key = "entry";
    for (int i = 0; i < MAX_ITEM_COUNT; i++) {
      collection.insert(new BasicDBObject(key, i));
    }

    // then
    assertThat(collection.getCount()).isEqualTo(MAX_ITEM_COUNT);
    assertThat(collection.findOne().get(key)).isEqualTo(0);

    // when
    collection.insert(new BasicDBObject(key, 10));

    // then
    assertThat(collection.getCount()).isEqualTo(MAX_ITEM_COUNT);
    assertThat(collection.findOne().get(key)).isEqualTo(1);

  }

  @Test
  public void update_fail__when_existing_entry_become_larger() throws Exception {
    // given
    WriteResult entry = collection.insert(new BasicDBObject("entry", 1));

    // when
    HashMap<String, Object> newValues = new HashMap<>();
    newValues.put("entry", 1);
    newValues.put("description", "It's not possible to make these changes.");

    WriteResult update = collection.update(new BasicDBObject("entry", 1), new BasicDBObject(newValues));

    // then
    assertThat(update.getLastError().getException()).isNotNull();
    assertThat(update.getLastError().getException().getCode()).isEqualTo(10003);
  }

  @Test
  public void update_is_successful_when_not_change_the_entry_size() throws Exception {
    // given
    WriteResult entry = collection.insert(new BasicDBObject("entry", 1));

    // when
    WriteResult update = collection.update(new BasicDBObject("entry", 1), new BasicDBObject("entry", 10));

    // then
    assertThat(update.getLastError().getException()).isNull();

  }
}
