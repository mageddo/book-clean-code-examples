package cleancode.chapter03_functions.listing_3_5;

import cleancode.chapter03_functions.support.Money;

public abstract class Employee {
public abstract boolean isPayday();
public abstract Money calculatePay();
public abstract void deliverPay(Money pay);
}
