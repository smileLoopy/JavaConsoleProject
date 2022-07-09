package shopping;

import java.sql.Types;

import shopping.connect.IConnectImpl;


public class UpdateShop extends IConnectImpl{
	
	public UpdateShop () {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute () {
		try {
			//Connection객체의 prepareCall() 메서드를 통해 프로시저 호출
			csmt = con.prepareCall("{call ShopUpdateGoods(?, ?, ?, ?, ?)}");
			/*
			In파라미터 설정: 상품명, 가격, 제품코드, 수정할 상품의 일련번호
			Out파라미터 설정: 레코드 수정 결과(1 혹은 0)
			 */
			csmt.setString(1, scanValue("상품명:"));
			csmt.setString(2, scanValue("상품가격:"));
			csmt.setString(3, scanValue("제품코드:"));
			csmt.setString(4, scanValue("수정할 상품의 일련번호"));
			csmt.registerOutParameter(5, Types.NUMERIC);
			//프로시저실행
			csmt.execute();
			
			System.out.println("수정프로시저 실행결과:");
			System.out.println(csmt.getString(5));
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new UpdateShop().execute();

	}


}
