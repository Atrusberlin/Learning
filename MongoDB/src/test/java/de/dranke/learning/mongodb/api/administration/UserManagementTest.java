package de.dranke.learning.mongodb.api.administration;

import com.mongodb.*;
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
  private DBCollection usersCollection;

  @BeforeClass
  public void init() throws UnknownHostException {

  }

  @BeforeMethod
  public void setUp() throws Exception {
    mongoConnection = new Mongo();
    DB adminDb = mongoConnection.getDB("admin");
    boolean authenticated = adminDb.authenticate("admin", "admin".toCharArray());
    LOG.info("User '" + ADMIN + "' is authenticated: " + authenticated);
    authTestDb = mongoConnection.getDB(TEST_DB);
    usersCollection = authTestDb.getCollection("system.users");
    LOG.info("Database " + TEST_DB + " was opened.");
  }

  @AfterMethod
  public void tearDown() {
    try {
      authTestDb.dropDatabase();
      mongoConnection.close();
    } catch (Exception e) {
      LOG.error(TEST_DB + " was not dropped. " + e.toString());
    }
  }

  @AfterClass
  public void cleanUp() {
  }

  @Test
  public void testAddUser() throws Exception {
    WriteResult result = authTestDb.addUser("userOne", "userOnePwd".toCharArray());

    LOG.debug("LastError - message: " + result.getLastError().getErrorMessage());
    assertThat(result.getLastError().isEmpty()).isFalse();
    assertThat(result.getLastError().ok()).isTrue();
  }

  @Test
  public void testAddUser_aktualisiert_den_Eintrag_bei_erneutem_Aufruf() throws Exception {
    // given
    authTestDb.addUser("userOne", "userOnePwd".toCharArray());
    assertThat(usersCollection.count()).isEqualTo(1);

    // when
    WriteResult result = authTestDb.addUser("userOne", "pw".toCharArray());

    // then
    assertThat(result.getLastError().ok()).isTrue();
    assertThat(usersCollection.count()).isEqualTo(1);
    assertThat(authTestDb.authenticate("userOne", "userOnePwd".toCharArray())).isFalse();
    assertThat(authTestDb.authenticate("userOne", "pw".toCharArray())).isTrue();
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

  @Test
  public void testRemoveUser_if_the_user_doesnot_exists__not_error_() throws Exception {
    // given

    // when
    WriteResult result = authTestDb.removeUser("userOne");

    // then
    assertThat(result.getLastError().ok()).isTrue();
    assertThat(usersCollection.count()).isZero();
  }

  @Test
  public void testReadOnlyUser_cannot_insert() throws Exception {
    // setup
    authTestDb.addUser("reader", "reader".toCharArray(), true);
    mongoConnection.close();

    // given
    mongoConnection = new Mongo();
    DB db = mongoConnection.getDB(TEST_DB);
    assertThat(db.isAuthenticated()).isFalse();
    db.authenticate("reader", "reader".toCharArray());
    DBCollection test = db.getCollection("test");
    assertThat(db.isAuthenticated()).isTrue();


    // when
    WriteResult result = test.insert(new BasicDBObject("key", "value"));

    // then
    assertThat(result.getError()).isNotNull();
    assertThat(result.getError()).isEqualTo("unauthorized");
    assertThat(test.count()).isZero();

  }
}
