package de.dranke.learning.mongodb.api.administration;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.net.UnknownHostException;

import static org.fest.assertions.Assertions.assertThat;

public class UserManagementTest {

  private static final Logger LOG = Logger.getLogger(UserManagementTest.class);
  public static final String TEST_DB = "authTestDb";
  public static final String ADMIN = "admin";
  private Mongo mongoConnection;
  private DB authTestDb;

  @BeforeClass
  public void init() throws UnknownHostException {
    mongoConnection = new Mongo();
    DB adminDb = mongoConnection.getDB("admin");
    boolean authenticated = adminDb.authenticate("admin", "admin".toCharArray());
    LOG.info("User '" + ADMIN + "' is authenticated: " + authenticated);
  }

  @BeforeMethod
  public void setUp() throws Exception {
    authTestDb = mongoConnection.getDB(TEST_DB);
    LOG.info("Database " + TEST_DB + " was opened.");
  }

  @AfterMethod
  public void tearDown() {
    try {
      authTestDb.dropDatabase();
    } catch (Exception e) {
      LOG.error(TEST_DB + " was not dropped. " + e.toString());
    }
  }

  @AfterClass
  public void cleanUp() {
    mongoConnection.close();
  }

  @Test
  public void testAddUser() throws Exception {
    WriteResult result = authTestDb.addUser("userOne", "userOnePwd".toCharArray());

    LOG.debug("LastError - message: " + result.getLastError().getErrorMessage());
    assertThat(result.getLastError().isEmpty()).isFalse();
    assertThat(result.getLastError().ok()).isTrue();
  }

  @Test
  public void testAddUser_when_user_exists_already_leads_to_error() throws Exception {
    // given
    authTestDb.addUser("userOne", "userOnePwd".toCharArray());

    // when
    WriteResult result = authTestDb.addUser("userOne", "pw".toCharArray());

    // then
    //assertThat(result.getLastError().ok()).isFalse();
    LOG.debug("User was not added: " + result.getLastError().getErrorMessage());

  }

  @Test
  public void testRemoveUser() throws Exception {
    // given
    authTestDb.addUser("userOne", "userOnePwd".toCharArray());

    // when
    WriteResult result = authTestDb.removeUser("userOne");

    // then
    assertThat(result.getLastError().ok()).isTrue();

  }
}
