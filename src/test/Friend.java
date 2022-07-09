package test;

public class Friend { //데이터 클래스
	//멤버변수 : 기본정보 3가지
	String name; //이름
	String phone; //전화번호
	String addr; //주소
	//인자생성자
	public Friend (String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		
	}
	//멤버변수 전체 정보를 출력할 목적의 멤버메서드
	public void showAllData() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		System.out.println("주소:"+ addr);
	}
	/*
	간략 정보를 출력하는 용도의 멤버메서드로 실행부가 없는 상태로 정의한다.
	해당 프로그램에서는 오버라이딩의 목적으로만 사용하기위해 정의한다.
	 */
	public void showBasicInfo() {}
}
