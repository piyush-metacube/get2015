import java.util.Scanner;

public class PaymentGateway
{
	private static Scanner sc = new Scanner(System.in);

	public static boolean paymentMenu()
	{
		System.out.println();
		System.out.println("Choose from Payment Options");
		System.out.println("1. Credit Card a survey");
		System.out.println("2. Wallet all Survey");
		System.out.println("3. Net Banking");
		System.out.println("4. Cancel");
		int choice = sc.nextInt();
		if (choice != 1 && choice != 2 && choice != 3 && choice != 4) paymentMenu();
		switch (choice)
		{
		case 1:
			return creditPayment();

		case 2:
			return walletPayment();

		case 3:
			return internetBankingPayment();

		case 4:
		default:
			return false;
		}
	}

	private static boolean creditPayment()
	{
		System.out.print("Enter Credit Card Number : ");
		String ccNum = sc.next();
		sc.nextLine();  // Consume newline left-over

		System.out.print("Enter CVV Number : ");
		String cvvNum = sc.next();
		sc.nextLine();  // Consume newline left-over

		if (!ccNum.isEmpty() && !cvvNum.isEmpty())
			return true;
		else
		{
			System.out.println("Payment Process Failed Invalid Inputs| Press Enter to go back ");
			sc.nextLine();
			return false;
		}
	}

	private static boolean walletPayment()
	{
		System.out.println("Payment Processed | Press Enter to go back ");
		sc.nextLine();
		return true;
	}

	private static boolean internetBankingPayment()
	{
		System.out.print("Enter Bank Name ");
		String bankName = sc.next();
		sc.nextLine();  // Consume newline left-over

		System.out.print("Enter User Name ");
		String userName = sc.next();
		sc.nextLine();  // Consume newline left-over

		System.out.print("Enter Password ");
		String password = sc.next();
		sc.nextLine();  // Consume newline left-over
		if (!bankName.isEmpty() && !userName.isEmpty() && !password.isEmpty())
			return true;
		else
		{
			System.out.print("Payment Process Failed Invalid Inputs| Press Enter to go back ");
			sc.nextLine();
			return false;
		}
	}
}
