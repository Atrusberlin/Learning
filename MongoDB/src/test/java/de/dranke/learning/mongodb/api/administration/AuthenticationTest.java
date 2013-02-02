package de.dranke.learning.mongodb.api.administration;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

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
}
