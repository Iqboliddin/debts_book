package model.authorization;

import model.BaseModel;
import model.debt.Debt;

import java.math.BigDecimal;
import java.util.UUID;

public class Debtor extends BaseModel {
    private String phoneNumber;
    private String address;
    private String password;
    private int debtTotal;
    private int debtLimit;
    private Debt[] personalDebts = new Debt[30];

    public Debtor() {
    }

    public Debtor(UUID id, String name,
                  String phoneNumber,
                  String address, String password,
                  int debtTotal,
                  int debtLimit,
                  Debt[] personalDebts)
    {
        super(id, name);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.debtTotal = debtTotal;
        this.debtLimit = debtLimit;
        this.personalDebts = personalDebts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDebtTotal() {
        return debtTotal;
    }

    public void setDebtTotal(int debtTotal) {
        this.debtTotal = debtTotal;
    }

    public int getDebtLimit() {
        return debtLimit;
    }

    public void setDebtLimit(int debtLimit) {
        this.debtLimit = debtLimit;
    }

    public Debt[] getPersonalDebts() {
        return personalDebts;
    }

    public void setPersonalDebts(Debt[] personalDebts) {
        this.personalDebts = personalDebts;
    }
}
