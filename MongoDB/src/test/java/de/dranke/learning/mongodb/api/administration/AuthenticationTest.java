package de.dranke.learning.mongodb.api.administration;

import com.mongodb.*;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static org.fest.assertions.Assertions.assertThat;

public class AuthenticationTest {

  public static final String DB_NAME = "newDb";
  private static final Logger LOG = Logger.getLogger(AuthenticationTest.class);
  public static final int UNAUTHORIZED = 10057;

  @Test
  public void authenticateToAdminDatabase() throws Exception {
    Mongo mongo = new Mongo();
    DB adminDb = mongo.getDB("admin");

    boolean authenticated = adminDb.authenticate("admin", "admin".toCharArray());

    assertThat(authenticated).isTrue();
  }

  @Test
  public void eine_Authentifizierung_gehoert_zu_einer_Verbindung() throws UnknownHostException {
    Mongo connection1 = new Mongo();
    authenticateToAdminCollection(connection1);

    DB db1 = connection1.getDB(DB_NAME);
    assertThat(db1.isAuthenticated()).isFalse();
    insertDataIntoTestCollection(db1);
    connection1.close();

    Mongo connection2 = new Mongo();
    DB db2 = connection2.getDB(DB_NAME);
    assertThat(connection2.getDB("admin").isAuthenticated()).isFalse();
    assertThat(db2.isAuthenticated()).isFalse();
    try {
      insertDataIntoTestCollection(db2);
    } catch (MongoException e) {
      LOG.error(e.getMessage() + "\n" + e.toString());
      assertThat(e.getCode()).isEqualTo(UNAUTHORIZED);
    }
    connection2.close();
  }

  private void authenticateToAdminCollection(Mongo mongo) {
    DB adminDb = mongo.getDB("admin");
    assertThat(adminDb.authenticate("admin", "admin".toCharArray())).isTrue();
  }

  private void insertDataIntoTestCollection(DB newDb) {
    DBCollection test1 = newDb.getCollection("test1");
    test1.insert(new BasicDBObject("name", "Daniel"));
    assertThat(test1.count()).isEqualTo(1);
    test1.drop();
  }
}
