package de.hypoport.jop.multithreading.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration("classpath:/spring-config/async-test.spring.xml")
public class TestServiceTest extends AbstractTestNGSpringContextTests {

  @Autowired
  TestService testService;

  @Test
  public void timeOut_mit_einem_thread() throws ExecutionException, InterruptedException, TimeoutException {
    // given
    Future<Integer> future1 = testService.getInteger(4);

    // when
    Integer integer1 = future1.get(5, TimeUnit.SECONDS);
    System.out.println("Zufallszahl1: " + integer1.toString());

    // then
    assertThat(integer1).isEqualTo(4);

  }
}
