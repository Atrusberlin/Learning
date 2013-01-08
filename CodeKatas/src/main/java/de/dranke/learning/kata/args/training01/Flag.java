package de.dranke.learning.kata.args.training01;

class Flag {

  char flagChar;

  Class flagType;

  public Flag(char flagChar, Class flagType) {
    this.flagChar = flagChar;
    this.flagType = flagType;
  }

  public char getFlagChar() {
    return flagChar;
  }

  public Class getFlagType() {
    return flagType;
  }
}
