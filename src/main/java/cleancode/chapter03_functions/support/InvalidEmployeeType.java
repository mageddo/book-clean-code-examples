package cleancode.chapter03_functions.support;

public class InvalidEmployeeType extends Exception {
  public InvalidEmployeeType(EmployeeType type) {
    throw new UnsupportedOperationException();
  }
}
