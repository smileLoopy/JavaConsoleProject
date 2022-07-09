package banking;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class NormalAccount extends Account {
	
	//자식에서 확장한 멤버변수
	private int nInterest; //이자
	
	//기본 생성자
	public NormalAccount () {
		
	}
	
	//인자 생성자
	public NormalAccount (String accountNum, String name, int balance, int nInterest) {
		super(accountNum, name, balance);
		this.nInterest = nInterest;
		
	}
	
	
	public int getnInterest() {
		return nInterest;
	}

	public void setnInterest(int nInterest) {
		this.nInterest = nInterest;
	}

	//입금
	@Override
	public void depositMoney() {
		
		Scanner scan = new Scanner (System.in);
		
		try {
			
			int money = scan.nextInt();
		
		if(money>0) {
			if(money%500==0) {
					
				int balance = getBalance();

				balance += Math.floor((balance * nInterest/100) + money);
				setBalance (balance);
				System.out.println("입금이 완료되었습니다.");
				return;
			}	
			else {
				System.out.println("입금은 500원 단위로 가능합니다.");
			}		
		}
		else {
			System.out.println("음수를 입력할 수 없습니다.");
		}
		}
		catch (InputMismatchException e) {
			System.out.println("문자는 입력할 수 없습니다.");
		}
	}
	
	

	@Override
	public void showAccInfo() {
		System.out.println();
		System.out.println("====보통예금계좌(전체정보)====");
		super.showAccInfo();
		System.out.println("기본이자 =>" +nInterest + "%");
	}


}
