package de.dranke.learning.mongodb.api.administration;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static org.fest.assertions.Assertions.assertThat;

public class AuthenticationTest {

  private static final Logger LOG = Logger.getLogger(AuthenticationTest.class);

  @Test
  public void authenticateToAdminDatabase() throws Exception {
    Mongo mongo = new Mongo();
    DB adminDb = mongo.getDB("admin");

    boolean authenticated = adminDb.authenticate("admin", "admin".toCharArray());

    assertThat(authenticated).isTrue();
  }

  @Test
  public void authenticationContainsToConnection() throws UnknownHostException {
    Mongo mongo = new Mongo();
    DB adminDb = mongo.getDB("admin");

    assertThat(adminDb.authenticate("admin", "admin".toCharArray())).isTrue();

    DB newDb = mongo.getDB("newDb");
//    assertThat(newDb.isAuthenticated()).isTrue();
    DBCollection test1 = newDb.getCollection("test1");
    test1.insert(new BasicDBObject("name", "Daniel"));
    assertThat(test1.count()).isEqualTo(1);
    test1.drop();
    mongo.close();

    Mongo mongoCon2 = new Mongo();
    DB newDb1 = mongoCon2.getDB("newDb");
    assertThat(mongoCon2.getDB("admin").isAuthenticated()).isFalse();
    assertThat(newDb1.isAuthenticated()).isFalse();
    test1 = newDb.getCollection("test1");
    test1.insert(new BasicDBObject("name", "Daniel"));
    test1.drop();
  }
}
