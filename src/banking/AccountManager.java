package banking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class AccountManager {
	
	//static으로 Scanner 인스턴스 생성해놔도 좋다. 어짜피 계속 쓰니까. 
	
//	private ArrayList <Account> myAccounts;
	//HashSet으로 변경 
	private HashSet<Account> myAccounts;
	
	
	//생성자
	public AccountManager (int num) {
		
//		myAccounts = new ArrayList<Account>();
		
		//HashSet으로 변경 
		myAccounts = new HashSet<Account>();		
	}
	
	
	public void makeAccount() {
		
		//계좌정보 입력받음. 
		Scanner scan = new Scanner (System.in);
		String accountNum, name, creditRate;
		int balance, nInterest, hInterest, choice;
		
		System.out.println("***신규계좌개설***");
		System.out.println("---계좌선택---");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택:"); choice = scan.nextInt();//nextint 는 정수를 입력받는데 정수를 집어넣고 enter를 치면 남음... 루프 안에서 계속 돌아감.
		
		scan.nextLine();//버퍼날림  
		System.out.println("계좌번호: "); accountNum = scan.nextLine();
		System.out.println("이름: "); name = scan.nextLine();
		System.out.println("잔고: "); balance = scan.nextInt();
		
		/*
		Account클래스 정의시 별도의 오버라이딩을 하지 않으면 아래 객체의 경우 중복처리 없이 입력된다.
		우리가 직접 정의한 클래스는 JVM이 동일한 객체인지 판단할 기준이 없으므로, 직접 정의해줘야 한다.
		 */
		
		if(choice==1) {
			
			System.out.println("기본이자%(정수형태로입력):"); nInterest  = scan.nextInt();
			NormalAccount normalAccount = 
					new NormalAccount(accountNum, name, balance, nInterest);
			
			System.out.println(myAccounts.add(normalAccount) ? "계좌번호 입력 성공" : "계좌번호 중복");
			
		}
		else if (choice==2) {
			
			System.out.println("기본이자%(정수형태로입력):"); hInterest = scan.nextInt();
			scan.nextLine();
			System.out.println("신용등급(A,B,C등급):"); creditRate = scan.nextLine();
			HighCreditAccount highCreditAccount = 
					new HighCreditAccount(accountNum, name, balance, hInterest, creditRate);
			
			System.out.println(myAccounts.add(highCreditAccount) ? "계좌번호 입력 성공" : "계좌번호 중복");
			
		}
			
		
	}
	
	//입금
	public void depositMoney () {
	
		//검색한 계좌정보가 없는 경우 false를 유지한다. 
		boolean isFind = false;
		Scanner scan = new Scanner (System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.println("계좌번호:");
		String searchAccountNum = scan.nextLine();
		System.out.println("입금액:");
		
	
		Iterator<Account> itr = myAccounts.iterator();
		while(itr.hasNext()) {
			Account ac = itr.next();
			if(searchAccountNum.equals(ac.getAccountNum())) {
				isFind = true;
				ac.depositMoney();	
				return;
			}
			else  {
				System.out.println("계좌번호를 찾을 수 없습니다.");
				return;
			}
		}			
	}
	
	//출금
	public void withdrawMoney() {
		
		
		//검색한 계좌정보가 존재하는 지 확인하는 변수 
		boolean isFind = false;
		Scanner scan = new Scanner (System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.println("계좌번호:");
		String searchAccountNum = scan.nextLine();
		System.out.println("출금액:");
		int money = scan.nextInt();
		
		if(money>0) {
			if(money%1000==0) {
				Iterator <Account> itr = myAccounts.iterator();
				while(itr.hasNext()) {
					Account ac = itr.next();
					if(searchAccountNum.equals(ac.getAccountNum())) {
						System.out.println("***출금***");
						
						if(money<ac.getBalance()) {
							ac.setBalance(ac.getBalance() - money);
							System.out.println("출금이 완료되었습니다.");
							isFind = true;
						}
						
						else if(money>ac.getBalance()) {
							System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
							System.out.println("YES: 금액전체 출금처리");
							System.out.println("NO: 출금요청 취소");
							
							scan.nextLine();
							String yesOrNo = scan.nextLine();
							
							if(yesOrNo.equals("YES")) {
								ac.setBalance(0);
								System.out.println("금액전체 출금처리 완료");
								
							}
							if(yesOrNo.equals("NO")) {
								System.out.println("출금요청 취소처리 완료");
								return;
							}
							isFind = true;
							
						}
					}
					else if(isFind == false) {
						System.out.println("입력한 계좌번호는 존재하지 않습니다.");
					}
				}
			}	
			else if (!(money%1000==0)) {
				System.out.println("출금은 1000단위로만 가능합니다.");
			}
		}
		else if (money<0) {
			System.out.println("음수를 출금 할 수 없습니다.");
		}
		
		
	}
	
	//전체정보 출력용
	public void showAccInfo () {
		
		//iterator 대신 확장 for문으로 대체
		for(Account ac : myAccounts) {
			ac.showAccInfo();
		}
		System.out.println();
		System.out.println(":전체계좌정보 출력이 완료되었습니다.");
		System.out.println("----------------------------------------");
		
	}
	
	//프로그램 종료시 정보 직렬화
	public void saveAccountIno () {
		try {
			ObjectOutputStream out = new ObjectOutputStream 
					(new FileOutputStream("src/banking/AccountInfo.obj"));
			for(Account ac : myAccounts ) {
				out.writeObject(ac);
			}
			
		}
		catch (Exception e){
			System.out.println("정보 직렬화시 예외 발생");
			
		}
		
	}
	
	
	public void readAccountInto () {
		
		try {
			ObjectInputStream in = new ObjectInputStream
					(new FileInputStream("src/banking/AccountInfo.obj"));
			
			while(true) {
				
				Account ac = (Account) in.readObject();
				myAccounts.add(ac);
				
				if(ac==null) break;
			}	
		}
		catch (Exception e) {
			
			System.out.println("계좌 정보가 복원되었습니다.");
			System.out.println("----------------------------------------");
		}
		showAccInfo();
	}
	
}













