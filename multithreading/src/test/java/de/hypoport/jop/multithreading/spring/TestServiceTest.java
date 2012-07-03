package de.hypoport.jop.multithreading.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration("classpath:/spring-config/async-test.spring.xml")
public class TestServiceTest extends AbstractTestNGSpringContextTests {

  @Autowired
  TestService testService;

  @Test
  public void timeOut_mit_einem_Thread() throws ExecutionException, InterruptedException, TimeoutException {
    // given
    Future<Integer> future1 = testService.getInteger(4);

    // when
    Integer integer1 = future1.get();
    System.out.println("Integer 1: " + integer1.toString());

    // then
    assertThat(integer1).isEqualTo(4);

  }

  @Test
  public void timeOut_mit_zwei_Threads() throws ExecutionException, InterruptedException, TimeoutException {
    // given
    Future<Integer> future1 = testService.getInteger(4);
    Future<Integer> future2 = testService.getInteger(7);

    // when
    System.out.println("Aufruf der Future.get()");
    Integer integer1 = future1.get();
    Integer integer2 = future2.get();
    System.out.println("Integer 1: " + integer1.toString());
    System.out.println("Integer 2: " + integer2.toString());

    // then
    assertThat(integer1).isEqualTo(4);
    assertThat(integer2).isEqualTo(7);

  }
}
