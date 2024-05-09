package cleancode.chapter03_functions._02_switch_statements.listing_3_5;

import cleancode.chapter03_functions.support.InvalidEmployeeType;

public interface EmployeeFactory {
public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
}
