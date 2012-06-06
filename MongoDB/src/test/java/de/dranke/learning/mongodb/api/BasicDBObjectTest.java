package de.dranke.learning.mongodb.api;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Entwickler
 * Date: 06.06.12
 * Time: 21:56
 * To change this template use File | Settings | File Templates.
 */
public class BasicDBObjectTest {

  public static final String COLL_NAME = "writeColl";
  private Mongo dbConnection;
  private DB db;
  private DBCollection collection;

  @BeforeClass
  public void init() {
    try {
      dbConnection = new Mongo();
      db = dbConnection.getDB("learn");
      collection = db.getCollection(COLL_NAME);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  @AfterClass
  public void tearDown() {
    dbConnection.close();
  }

  @Test
  public void insert_fuegt_ein_neues_Dokument_zur_Collection_hinzu() {
    // given
    BasicDBObject doc = new BasicDBObject();
    doc.put("lastName", "Ranke");
    doc.put("firstName", "Daniel");

    // when
    collection.insert(doc);

    // then
    assertThat(collection.count()).isEqualTo(1);
  }
}
