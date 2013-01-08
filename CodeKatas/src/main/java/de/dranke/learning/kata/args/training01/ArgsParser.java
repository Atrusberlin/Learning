package de.dranke.learning.kata.args.training01;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class ArgsParser {

  public static final String FLAG_PREFIX = "-";
  private Schema schema;
  private boolean initialized = false;
  private Map<Character, Object> arguments;

  public ArgsParser(Schema schema) {
    this.schema = schema;
    initialized = true;
  }

  public boolean isInitialized() {
    return initialized;
  }

  public boolean containsArgument(String args, char argFlag) {
    String[] arguments = args.split(" ");
    for (String argument : arguments) {
      if (isNotEmpty(argument)
          && argument.startsWith(FLAG_PREFIX)
          && argument.substring(1, 2).equalsIgnoreCase(String.valueOf(argFlag))) {
        return true;
      }
    }
    return false;
  }

}
