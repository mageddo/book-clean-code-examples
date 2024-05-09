package cleancode.chapter03_functions.support;

public class InvalidEmployeeType extends Exception {
  public InvalidEmployeeType(Employee.Type type) {
    throw new UnsupportedOperationException();
  }
}
