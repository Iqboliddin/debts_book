package front;

import model.authorization.Debtor;
import model.debt.Debt;
import model.history.Category;
import service.DebtService;
import service.DebtorService;

import java.util.Scanner;

public class DebtorFront extends BaseResponse{

    public static void addDebtor(DebtorService debtorService){
        Scanner scanner = new Scanner(System.in);
        Debtor debtor = new Debtor();

        debtor.setId();

        System.out.print("Enter name: ");
        debtor.setName(scanner.nextLine());

        System.out.print("Enter phone number: ");
        debtor.setPhoneNumber(scanner.nextLine());

        System.out.print("Enter debt limit: ");
        debtor.setDebtLimit(scanner.nextInt());

        scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        debtor.setPassword(scanner.nextLine());

        System.out.print("Enter address: ");
        debtor.setAddress(scanner.nextLine());

        boolean status = debtorService.add(debtor);
        response(status);
    }

    public static Debtor signIn(DebtorService debtorService){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return debtorService.signIn(phoneNumber, password);
    }
}
