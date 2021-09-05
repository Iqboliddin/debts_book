package service;

import model.authorization.Debtor;
import model.debt.Debt;


public class DebtService extends BaseService{

    private Debt[] debts = new Debt[1000];
    private int index = 0;


    @Override
    public boolean add(Object object) {
        return false;
    }

    @Override
    public boolean addDebt(Object object, Object object1) {
        Debtor currentDebtor = (Debtor) object;
        Debt newDebt = (Debt) object1;
        boolean answer = false;
        int helper = currentDebtor.getDebtTotal() + newDebt.getAmount();
        if (helper <= currentDebtor.getDebtLimit()){
            currentDebtor.setDebtTotal(helper);
            for (int i = 0; i < currentDebtor.getPersonalDebts().length; i++) {
                if (currentDebtor.getPersonalDebts()[i] == null){
                    currentDebtor.getPersonalDebts()[i] = newDebt;
                    break;
                }
            }
            answer = true;
        }
        return answer;
    }

    @Override
    public void list(Object object) {
        Debtor currentDebtor = (Debtor) object;
        if (currentDebtor.getDebtTotal() != 0){
            int helper = currentDebtor.getDebtLimit() - currentDebtor.getDebtTotal();
            System.out.println("Total debt: " + currentDebtor.getDebtTotal());
            System.out.println("The rest of your possible limit: " + helper);
            int count = 0;
            for (Debt debt: currentDebtor.getPersonalDebts()) {
                if (debt != null){
                    System.out.println("\n***** " + (count + 1) + " - debt *****\n");
                    System.out.println("Amount: " + debt.getAmount());
                    System.out.println("Category: " + debt.getCategory());
                    System.out.println("Date: " + debt.getDate());
                    System.out.println();
                    count++;
                }

            }
        }
        else
            System.out.println("You have no debts pending");
    }

    @Override
    public void list() {

    }

    public int payDebt(Debtor currentDebtor, int money){
        int helper = currentDebtor.getDebtTotal() - money;
        if(helper >= 0)
            currentDebtor.setDebtTotal(helper);
        else
            currentDebtor.setDebtTotal(0);
        return helper;
    }
}
