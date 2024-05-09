package cleancode.chapter03_functions.listing_3_4;

import cleancode.chapter03_functions.support.Employee;
import cleancode.chapter03_functions.support.InvalidEmployeeType;
import cleancode.chapter03_functions.support.Money;

public class Payroll {
  public Money calculatePay(Employee e)
    throws InvalidEmployeeType {
    switch (e.type) {
      case COMMISSIONED:
        return calculateCommissionedPay(e);
      case HOURLY:
        return calculateHourlyPay(e);
      case SALARIED:
        return calculateSalariedPay(e);
      default:
        throw new InvalidEmployeeType(e.type);
    }
  }

  private Money calculateSalariedPay(Employee e) {
    throw new UnsupportedOperationException();
  }

  private Money calculateHourlyPay(Employee e) {
    throw new UnsupportedOperationException();
  }

  private Money calculateCommissionedPay(Employee e) {
    throw new UnsupportedOperationException();
  }

}
