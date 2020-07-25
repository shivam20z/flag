package com.example.checkapp;

public class Country {

  // region Variables
  private String name;
  private int flag;
  // endregion

  // region Constructors
  Country() {
  }

  Country( String name, int flag) {
    this.name = name;
    this.flag = flag;
  }
  // endregion

  // region Getter/Setter


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }


  // endregion
}
