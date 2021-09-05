import front.DebtFront;
import front.DebtorFront;
import model.authorization.Debtor;
import service.DebtService;
import service.DebtorService;

import java.util.Scanner;

public class Main implements Action {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Max debtors: ");
        DebtorService debtorService = new DebtorService(scanner.nextInt());
        DebtService debtService = new DebtService();

        int stepCode = 1;
        while (stepCode != 0) {
            System.out.println(debtorAction);
            System.out.print("N = ");
            stepCode = scanner.nextInt();
            switch (stepCode) {
                case 1:
                    DebtorFront.addDebtor(debtorService);
                    break;
                case 2:
                    Debtor debtor = DebtorFront.signIn(debtorService);
                    if (debtor != null) {
                        payment(debtor, debtService);
                    } else
                        System.out.println("Invalid username or password!");
                    break;
                case 3:
                    debtorService.list();
                    break;
            }
        }


    }

    public static void payment(
            Debtor debtor,
            DebtService debtService
    ) {
        Scanner scanner = new Scanner(System.in);

        int stepCode = 1;
        while (stepCode != 0) {

            System.out.println("This is " + debtor.getName() + "'s debt account. Choose action to complete:");
            System.out.println(debtAction);
            System.out.print("N = ");
            stepCode = scanner.nextInt();
            switch (stepCode) {
                case 1:
                    DebtFront.addDebt(debtor, debtService);
                    break;
                case 2:
                    debtService.list(debtor);
                    break;
                case 3:
                    DebtFront.payDebt(debtor);
                    break;
            }
        }
    }
}