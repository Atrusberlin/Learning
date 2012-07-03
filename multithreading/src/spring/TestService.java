package spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

@Service
public class TestService {

  @Async
  public Future<Integer> getRandomInteger(Integer min, Integer max) {
    Random random = new Random();
    random.nextInt(min.intValue());

    return null;
  }
}
