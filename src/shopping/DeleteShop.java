package shopping;
/*
●	상품삭제
○	프로시저명 : ShopDeleteGoods
○	In파라미터 : 삭제할 상품의 일련번호
○	Out파라미터 : 레코드 삭제 결과(1 혹은 0)
○	클래스명 : DeleteShop

 */

import java.sql.Types;

import shopping.connect.IConnectImpl;

public class DeleteShop extends IConnectImpl{
	
	public DeleteShop () {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute () {
		try {
			//Connection객체의 prepareCall() 메서드를 통해 프로시저 호출
			csmt = con.prepareCall("{call ShopDeleteGoods(?, ?)}");
			/*
			In파라미터 설정: 실제 삭제할 상품의 일련번호 
			Out파라미터 설정: 레코드 삭제 결과  
			 */
			csmt.setString(1, scanValue("삭제할 상품일련번호:"));
			csmt.registerOutParameter(2, Types.VARCHAR);
			//프로시저실행
			csmt.execute();
			
			System.out.println("삭제프로시저 실행결과:");
			System.out.println(csmt.getString(2));
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new DeleteShop().execute();

	}



}
