package de.dranke.learning.mongodb.api;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static org.fest.assertions.Assertions.assertThat;

/** Created by IntelliJ IDEA. User: daniel.ranke Date: 29.03.12 Time: 16:32 To change this template use File | Settings | File Templates. */
public class DatabaseTest {

  public static final String LEARNDB = "learn";
  private String dbname;
  private String hostName;
  private int hostPort;
  private Mongo mongoConnection;

  @BeforeMethod
  public void setUp() throws Exception {
    dbname = "learn";
    hostName = "localhost";
    hostPort = 27017;
  }

  @AfterMethod
  public void tearDown() throws Exception {
    if (mongoConnection != null) {
      mongoConnection.close();
    }
  }

  @Test
  public void erzeugen_einer_Verbindung_ohne_Parameter() throws UnknownHostException {
    // given
    mongoConnection = new Mongo();

    // when
    showMongoDbDetails(mongoConnection);

    // then
    assertThat(mongoConnection.getVersion()).isNotEmpty();
  }

  @Test
  public void erzeugen_einer_Verbindung_mit_Host_Parameter() throws UnknownHostException {
    // given
    mongoConnection = new Mongo(hostName);
    // when
    showMongoDbDetails(mongoConnection);
    // then
    assertThat(mongoConnection.getVersion()).isNotEmpty();
  }

  @Test
  public void erzeugen_einer_Verbindung_mit_Host_und_Port_Parameter() throws UnknownHostException {
    // given
    mongoConnection = new Mongo(hostName, hostPort);
    // when
    showMongoDbDetails(mongoConnection);
    // then
    assertThat(mongoConnection.getVersion()).isNotEmpty();
  }

  @Test
  public void verbinden_zu_Datenbank_learn() throws UnknownHostException {
    // given
    mongoConnection = new Mongo(hostName);
    // when
    DB learn = mongoConnection.getDB(LEARNDB);
    // then
    assertThat(learn.getStats()).isNotNull();
    showDBStats(learn);
  }

  @Test
  public void erstelle_und_loesche_Datenbank() throws UnknownHostException {
    // given
    mongoConnection = new Mongo(hostName);
    // when
    String neueTestDatenbankName = "neueTestDatenbank";
    // neue Datenbank wird erstellt, wenn sie noch nicht vorhanden ist
    DB testDatenbank = mongoConnection.getDB(neueTestDatenbankName);

    assertThat(testDatenbank).isNotNull();
    assertThat(testDatenbank.getStats().ok()).isTrue();
    assertThat(mongoConnection.getDatabaseNames().contains(neueTestDatenbankName)).isTrue();
    showDBStats(testDatenbank);

    // die Datenbank wird gelöscht.
//    mongoConnection.dropDatabase(neueTestDatenbankName);
    // eine alternative Löschvariante ist
    testDatenbank.dropDatabase();
    assertThat(mongoConnection.getDatabaseNames().contains(neueTestDatenbankName)).isFalse();

    // then

  }

  private void showDBStats(DB database) {
    System.out.println("ok=" + database.getStats().ok());
    for (String key : database.getStats().keySet()) {
      System.out.println("Key(" + key + ")=" + database.getStats().get(key));
    }
  }

  private void showMongoDbDetails(Mongo mongoConnection) {
    System.out.println("Version: " + mongoConnection.getVersion());
    System.out.println("Databases: ");
    for (String dbName : mongoConnection.getDatabaseNames()) {
      System.out.println("\t" + dbName);
    }
  }
}
