package banking;

import java.util.InputMismatchException;
import java.util.Scanner;



public class BankingSystemMain implements ICustomDefine {
	
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner (System.in);
		
		AccountManager accountManager = new AccountManager(50);
		
		accountManager.readAccountInto();
		
		boolean isOK = true;
		
			while (isOK) {
				//메뉴를 출력한다.
			Account.menuShow();
			try {
				
				int choice = scan.nextInt();
				
				if(choice == MAKE) {
					accountManager.makeAccount();
				}
				else if (choice == DEPOSIT) {
					accountManager.depositMoney();
				}
				else if (choice == WITHDRAW) {
					accountManager.withdrawMoney();
				}
				else if (choice == INQUIRE) {
					accountManager.showAccInfo();
				}
				else if (choice == EXIT) {
					System.out.println("프로그램종료");
					accountManager.saveAccountIno();
					return; //main의 종료는 프로그램의 종료로 이어진다.
				}
				try {
					if(!(choice>=1 && choice<=5)) { //이건 자바 가상머신이 직접 할 수 없음. 
						MenuSelectException ce = new MenuSelectException();
						throw ce;
				}
				}
				catch (MenuSelectException e) {
					System.out.println(e.getMessage());
					isOK = true;
				}
			}
			//문자 입력 예외처리
			catch (InputMismatchException e) {
				System.out.println("숫자만 입력가능합니다.");
				isOK = true;
				scan.nextLine();
			}
		}
	
	}
}
