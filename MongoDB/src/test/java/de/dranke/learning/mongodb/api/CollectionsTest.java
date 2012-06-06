package de.dranke.learning.mongodb.api;

import com.mongodb.*;
import org.testng.annotations.*;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA. User: daniel.ranke Date: 25.04.12 Time: 09:35 To change this template use File | Settings | File Templates.
 */
public class CollectionsTest {

  public static final String TEST_COLLECTION = "testCollection";
  private Mongo dbConnection;
  private DB db;
  private DBCollection collection;

  @BeforeClass
  public void init() throws Exception {
    System.out.println("enter init() ...");
    dbConnection = new Mongo("localhost", 27017);
    db = dbConnection.getDB("learn");
  }

  @AfterClass
  public void cleanUp() {
    System.out.println("enter cleanUp() ...");
    dbConnection.close();
  }

  @BeforeMethod
  public void setUp() throws Exception {
    System.out.println("enter setUp() ...");
  }

  @AfterMethod
  public void tearDown() throws Exception {
    System.out.println("enter tearDown() ...");
    if (db.getCollectionNames().contains(TEST_COLLECTION)) {
      db.getCollection(TEST_COLLECTION).drop();
    }
  }

  @Test
  public void erstelle_neue_collection_mit_getCollection_und_entferne_sie_am_ende() {
    // given
    assertThat(db.getCollectionNames()).isNotIn(TEST_COLLECTION);
    // when
    DBCollection collection = db.getCollection(TEST_COLLECTION);
    // Collection wird erst erzeugt, wenn der erste Eintrag hinzugefügt wurde.
    collection.insert(getNewEntry());
    // then
    assertThat(collection).isNotNull();
    assertThat(db.getCollectionNames()).isNotIn(collection.getName());
    collection.drop();
    assertThat(db.getCollectionNames()).isNotIn(collection.getName());
  }

  @DataProvider
  public Object[][] collectionGroessen() {
    return new Object[][]{
        {100000},
        {200000},
        {400000}
    };
  }

  @Test(dataProvider = "collectionGroessen")
  public void erstelle_neue_collection_mit_createCollection_und_initialer_groesse(Integer initSize) {
    // given
    assertThat(db.getCollectionNames()).isNotIn(TEST_COLLECTION);
    DBObject configuration = new BasicDBObject();
    configuration.put("size", initSize.toString());
    // when
    collection = db.createCollection(TEST_COLLECTION, configuration);
    // Collection wird erstellt ohne einen neuen Eintrag hinzuzufügen
    // then
    assertThat(collection).isNotNull();
    assertThat(db.getCollectionNames()).contains(collection.getName());
    System.out.println(collection.getStats());
    int size = Integer.parseInt(collection.getStats().get("storageSize").toString());
    assertThat(size).isEqualTo(initSize * 8);
  }

  private DBObject getNewEntry() {
    BasicDBObject doc = new BasicDBObject();
    doc.put("name", "Daniel Ranke");
    doc.put("gender", "male");
    doc.put("birthday", "14.06.78");
    return doc;
  }
}
