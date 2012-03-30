package de.dranke.learning.mongodb.api;

import com.mongodb.Mongo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static org.fest.assertions.Assertions.assertThat;

/** Created by IntelliJ IDEA. User: daniel.ranke Date: 29.03.12 Time: 16:32 To change this template use File | Settings | File Templates. */
public class DatabaseTest {

  private String dbname;
  private String hostName;
  private int hostPort;
  private Mongo mongoConnection;

  @BeforeMethod
  public void setUp() throws Exception {
    dbname = "learn";
    hostName = "localhost";
    hostPort = 27001;
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
    mongoConnection = new Mongo(hostName);
    // when
    showMongoDbDetails(mongoConnection);
    // then
    assertThat(mongoConnection.getVersion()).isNotEmpty();
  }

  private void showMongoDbDetails(Mongo mongoConnection) {
    System.out.println("Version: " + mongoConnection.getVersion());
    System.out.println("Databases: ");
    for (String dbName : mongoConnection.getDatabaseNames()) {
      System.out.println("\t" + dbName);
    }
  }
}
