package service;

import model.authorization.Debtor;

public class DebtorService extends BaseService{

    private Debtor[] debtors;
    private int index;

    public DebtorService(int size) {
        this.debtors = new Debtor[size];
        this.index = 0;
    }

    @Override
    public boolean add(Object object) {
        Debtor newDebtor = (Debtor) object;
        boolean isHasDebtor = false;
        for (Debtor debtor : this.debtors) {
            if (debtor != null)
                if (debtor.getPhoneNumber().equals(newDebtor.getPhoneNumber()))
                    isHasDebtor = true;
        }
        if (!isHasDebtor)
            this.debtors[index++] = newDebtor;
        return !isHasDebtor;
    }

    @Override
    public boolean addDebt(Object object, Object object1) {
        return false;
    }

    public Debtor signIn(String phoneNumber, String password){
        Debtor debtor = null;
        for (int i = 0; i < this.debtors.length && (debtor == null); i++) {
            if (this.debtors[i] != null)
                if (phoneNumber.equals(this.debtors[i].getPhoneNumber()) &&
                        password.equals(this.debtors[i].getPassword()))
                    debtor = this.debtors[i];
        }
        return debtor;
    }

    @Override
    public void list(Object object) {

    }

    @Override
    public void list() {
        System.out.println("Debit account of the shop is: "+ allDebtsOfShop());
        for (int i = 0; i < this.debtors.length; i++) {
            Debtor debtor = debtors[i];
            if (debtor != null){
                System.out.println("\n***** ACCOUNT " + (i+1) + " *****");
                System.out.println("Name: " + debtor.getName());
                System.out.println("Total debt of debtor: " +debtor.getDebtTotal());
                System.out.println("Phone Number: " +debtor.getPhoneNumber());
                System.out.println("Address: " +debtor.getAddress());
                System.out.println("Password: " +this.getMaskPassword(debtor.getPassword()));
            }else{
                System.out.println("\n==> All of debtors list <== \n");
                break;
            }
        }
    }

    private String getMaskPassword(String str){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            res.append("*");
        }
        return res.toString();
    }

    public int allDebtsOfShop(){
        int allDebts = 0;
        for (int i = 0; i < this.debtors.length; i++) {
            Debtor debtor = debtors[i];
            if (debtor != null)
               allDebts += debtor.getDebtTotal();
        }
        return allDebts;
    }
}
