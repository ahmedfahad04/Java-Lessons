package SOLID;

import javax.management.openmbean.InvalidOpenTypeException;

public class StudentAccount extends Account{

    @Override
    public void deposit(int amount) {
        System.out.println("STUDENT deposit: " + amount);
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("STUDENT withdraw: " + amount);
        throw new InvalidOpenTypeException("Amount is not compatible");
    }
}
