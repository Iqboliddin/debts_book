package front;

import model.authorization.Debtor;
import model.debt.Debt;
import model.history.Category;
import service.DebtService;

import java.util.Scanner;

public class DebtFront extends BaseResponse{
    public static void addDebt(Debtor debtor, DebtService debtService) {
        Scanner scanner = new Scanner(System.in);

        Debt debt = new Debt();

        System.out.print("Enter amount: ");
        debt.setAmount(scanner.nextInt());

        System.out.print("Choose category: ");
        System.out.println("1.FOOD   2.PERFUME   3.CLEANING_PRODUCTS   4.OTHER");
        int cardType = scanner.nextInt();
        switch (cardType) {
            case 1:
                debt.setCategory(Category.FOOD);
                break;
            case 2:
                debt.setCategory(Category.PERFUME);
                break;
            case 3:
                debt.setCategory(Category.CLEANING_PRODUCTS);
                break;
            case 4:
                debt.setCategory(Category.OTHER);
                break;
            default:
                System.out.println("Please, choose relevant category");
        }

        scanner = new Scanner(System.in);
        System.out.print("Enter date: ");
        debt.setDate(scanner.nextLine());

        boolean status = debtService.addDebt(debtor, debt);
        response(status);
        if (!status)
            System.out.println("You are trying to exceed your debt limit!");
    }

    public static void payDebt(Debtor debtor){
        DebtService debtService = new DebtService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your current debt = " + debtor.getDebtTotal());
        if(debtor.getDebtTotal() == 0){
            System.out.println("You don't have to pay! ");
        }else{
            System.out.print("How much would you like to pay, please enter: ");
            int amountMoney = scanner.nextInt();
            int res = debtService.payDebt(debtor, amountMoney);
            if (res == 0)
                System.out.println("Your debt is fully paid!");
            else if(res < 0){
                System.out.println("Your debt is fully paid!");
                System.out.println("Take " + Math.abs(res) + " as change!" );
            }else
                System.out.println("You have " + res + " amount left to pay!");
        }

    }
}
