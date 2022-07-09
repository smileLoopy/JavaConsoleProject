package shopping;

import java.util.Scanner;
import shopping.connect.IConnectImpl;

public class InsertShop extends IConnectImpl {

	public InsertShop () {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
	@Override
	public void execute () {
		try {
			//1.쿼리문준비: 값의 세팅이 필요한 부분을 ?(인파라미터)로 대체한다. 
			String query = "INSERT INTO sh_goods VALUES "
					+ " (seq_total_idx.nextval, ?, ?, sysdate, ?)";
			
			//2.prepared객체생성: 생성시 준비한 쿼리문을 인수로 전달한다. 
			psmt = con.prepareStatement(query);
			
			///3.사용자로부터 입력할 내용을 받는다. 
			Scanner scan = new Scanner(System.in);
			System.out.print("상품명:");
			String goods_name = scan.nextLine();
			System.out.print("상품가격:");
			String goods_price = scan.nextLine();
			System.out.print("상품코드:");
			String p_code = scan.nextLine();
			/*
			4.인파라미터 설정: ?의 순서대로 설정하고, 인덱스는 1부터 시작한다. 
				자료형이
					숫자면 setInt()
					문자면 setString()
					날짜면 setDate()
				입력값이 문자이거나 날짜면 싱글쿼테이션이 자동으로 삽입된다. 
			 */
			
			psmt.setString(1, goods_name);
			psmt.setString(2, goods_price);
			psmt.setString(3, p_code);
	
			//5.쿼리실행 후 결괏값 반환
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new InsertShop().execute();
	}

}
