package banking;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

//신용계좌: 잔고 + (잔고*기본이자) + (잔고*추가이자) + 입금액
//A:7%, B:4%, C:2%
public class HighCreditAccount extends Account implements ICustomDefine{
	
	
	private int hInterest;
	private String creditRate;
	
	//기본생성자
	public HighCreditAccount () {
		
	}
	//인자생성자
	public HighCreditAccount (String accountNum, String name, int balance, int hInterest ,String creditRate) {
		
		super(accountNum, name, balance);
		this.hInterest = hInterest;
		this.creditRate = creditRate;
		
	}
	
	public int gethInterest() {
		return hInterest;
	}
	public void sethInterest(int hInterest) {
		this.hInterest = hInterest;
	}
	public String getCreditRate() {
		return creditRate;
	}
	public void setCreditRate(String creditRate) {
		this.creditRate = creditRate;
	}
	
	@Override
	public void depositMoney() {
		
		super.depositMoney();
		
		Scanner scan = new Scanner (System.in);
		
		try {
		int money = scan.nextInt();
		
		if(money>0) {
			if(money % 500 ==0) {
				
				int balance = getBalance();
				
				if(creditRate.equals("A")) {
					
					balance += Math.floor((balance * hInterest/100) 
								+ (balance * A/100)+ money);
				}
				else if(creditRate.equals("B")) {
					balance += Math.floor((balance * hInterest/100) 
								+ (balance * B/100)+ money);
				}
				else if(creditRate.equals("C")) {
					balance += Math.floor((balance * hInterest/100) 
								+ (balance * C/100)+ money);
				}
				
				setBalance(balance);
				
				System.out.println("입금이 완료되었습니다.");
				
			}
			else {
				System.out.println("※※※ 입금은 500원 단위로만 가능합니다. ※※※");
			}
		}
		else {
			System.out.println("※※※ 음수를 입력할 수 없습니다. ※※※");
		}
		}
		catch (InputMismatchException e) {
			System.out.println("※※※ 문자는 입력할 수 없습니다.※※※");
		}
		
		
	}
	
	@Override
	public void showAccInfo() {
		System.out.println();
		System.out.println("====신용신뢰계좌(전체정보)====");
		super.showAccInfo();
		System.out.println("기본이자 =>" +hInterest + "%");
		System.out.println("신용등급 =>"+ creditRate + "등급");
	}

}
