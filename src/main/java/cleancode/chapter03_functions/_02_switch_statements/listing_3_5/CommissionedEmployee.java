package cleancode.chapter03_functions._02_switch_statements.listing_3_5;

import cleancode.chapter03_functions.support.Money;

public class CommissionedEmployee extends Employee {

  public CommissionedEmployee(EmployeeRecord r) {
    super();
  }

  @Override
  public boolean isPayday() {
    return false;
  }

  @Override
  public Money calculatePay() {
    return null;
  }

  @Override
  public void deliverPay(Money pay) {

  }
}
