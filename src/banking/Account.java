package banking;

import java.io.Serializable;
import java.util.Objects;

/*
추상클래스: 인스턴스 생성을 허용하지 않는 abstract 클래스
 */
public abstract class Account implements Serializable { //직열화는 부모쪽에만 있으면 된다. 
	//멤버변수: 계좌 기본정보 3가지 선언
	//멤버변수를 private으로 선언하면 getter setter 씀
	private String accountNum;
	private String name;
	private int balance;
	
	//기본 생성자
	public Account () {
		
	}
	
	//인자 생성자 
	public Account (String accountNum, String name, int balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}
	
	
	//멤버변수를 private으로 선언했기에 다른곳에서 호출하기 위해 getter/setter 필요. 
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public static void menuShow () {
		System.out.println("------ [ Menu ] ------");
		System.out.println("1.계좌개설 ");
		System.out.println("2.입금 ");
		System.out.println("3.출금 ");
		System.out.println("4.계좌정보출력 ");
		System.out.println("5.프로그램종료 ");
		System.out.println("선택:");
		
		
	}
	
	/*
	멤버변수 전체 정보를 출력할 목적의 멤버베서드 
	 */
	public void showAccInfo() {
		System.out.println("▶ 계좌정보출력:");
		System.out.println("계좌번호 =>"+ accountNum);
		System.out.println("고객이름 =>"+ name);
		System.out.println("잔고 =>"+ balance);
		System.out.println("---------------");
		
	}

	@Override
	public int hashCode () {
		
		int hascode = this.accountNum.hashCode();
		return hascode;		
	}
	
	@Override
	public boolean equals (Object obj) {
		
		Account ac = (Account) obj;
		if(this.accountNum.equals(ac.accountNum)) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public void makeAccount() {}
	public void depositMoney() {}
	public void withdrawMoney() {}
	
}




