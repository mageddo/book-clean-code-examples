package cleancode.chapter03_functions.listing_3_5;

import cleancode.chapter03_functions.support.Money;

public class SalariedEmploye extends Employee {
  public SalariedEmploye(EmployeeRecord r) {
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
