package de.dranke.learning.kata.args.training01;

import java.util.ArrayList;
import java.util.List;

class TestSchema implements Schema {


  private final ArrayList<Flag> flags = new ArrayList<>(3);

  TestSchema() {
    flags.add(new Flag('l', Boolean.class));
    flags.add(new Flag('d', String.class));
    flags.add(new Flag('p', Integer.class));
  }

  @Override
  public List<Flag> getFlags() {
    return flags;
  }
}
