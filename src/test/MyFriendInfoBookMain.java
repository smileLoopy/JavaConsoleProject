package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/*
친구를 표현한 최상위 클래스로 해당 프로그램에서는 Friend클래스로
객체생성은 하지 않는다. 기본정보를 저장하고 상속할 목적으로 정의된
클래스이다.
이런 클래스를 VO(Value Object)라고 부른다. 즉 값만 가진 객체라는 뜻이다.
 */

public class MyFriendInfoBookMain { //기능을 가지고 있는 클래스
	
	/*
	매개변수도 없고 반환타입도 없는 메서드 
	: 해당 프로그램에서 메뉴를 출력하는 용도로 정의함. 
	 */
	public static void menuShow () {
		System.out.println("####### 메뉴를 입력하세요 ########");
		System.out.print("1.고딩친구입력");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보출력");
		System.out.println("4.간략정보출력");
		System.out.print("5.검색");
		System.out.print("6.삭제");
		System.out.println("7.프로그램종료");
		System.out.print("메뉴선택>>>");
		
	}
	
	/*
	메인 메서드는 해당 프로그램의 시작점 (Entry point)이므로 복잡한 로직의
	구성보다는 프로그램의 전반적인 흐름에 대해서만 기술하는것이 좋다.
	따라서 선택한 메뉴에 따라 핸들러 메서드만 호출하는 형태로
	구현되어 있다. 
	 */
	public static void main(String[] args) {
		
		//사용자 입력을 위한 객체 생성 
		Scanner scan = new Scanner(System.in);
		/*
		기능을 담당하는 핸들러(메니저) 클래스의 객체를 생성
		초깃값으로 100명의 정보를 저장할 수 있는 Friend 타입의 객체배열을 생성한다.
		 */
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		
		/*
		무한루프 조건으로 특정 입력에만 종료할 수 있는 구조를 만들어 준다. 
		break문은 반복문을 탈출시키는 기능이 있으므로 이와같은 무한루프에서는 
		자주 사용된다. 
		또한 for (;;) 문을 통해 무한루프를 구현할 수 있으나 반복의 횟수가 정확하지 
		않는 경우에는 while문을 주로 사용한다. 
		 */
		while (true) {
			//메뉴를 출력한다. 
			menuShow();
			
			//사용자는 수행할 기능의 메뉴를 선택한다.
			int choice = scan.nextInt();
			
			//선택한 메뉴를 수행할 수 있는 메서드를 switch문을 통해 호출한다. 
			switch(choice) {
			case 1 : case 2:
				//고딩/대딩 친구 입력
				handler.addFriend(choice);
				break;
			case 3 : 
				//전체정보 출력
				handler.showAllData();
				break;
			case 4:	
				//간략정보 출력
				handler.showSimpleData();
				break;
			case 5:
				//검색
				//System.out.println ("검색")
				handler.searchInfo();
				break;
			case 6:
				//삭제
				handler.deleteInfo();
			case 7:
				//프로그램 종료
				System.out.println("프로그램종료");
				return; //main의 종료는 프로그램의 종료로 이어진다. 
			}
		}
		
		
		
	}

}
