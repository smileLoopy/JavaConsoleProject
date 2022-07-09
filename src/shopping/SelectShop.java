package shopping;

import java.util.Scanner;

import shopping.connect.IConnectImpl;

public class SelectShop extends IConnectImpl{

	public SelectShop () {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
	
	/*
	●	Statement객체를 사용하여 작성한다.
●	클래스명 : SelectShop
●	검색할 상품명을 입력받은 후 like를 통해 해당조건에 맞는 레코드만 출력한다. 
●	출력항목 : 일련번호, 상품명, 가격, 등록일, 제품코드
●	단, 등록일은 0000-00-00 00:00 형태로 출력해야 한다.	
	상품가격은 세자리마다 컴마를 찍어준다.
●	Statement객체는 인파라미터를 통한 동적쿼리를 작성할 수 없으므로 순수 Java변수를 사용한다. 

	 */
	
	@Override
	public void execute () {
		try {
			
			stmt = con.createStatement();
			
			String query = "SELECT g_idx, goods_name, to_char(goods_price, 'L9,999,000') p1, "
					+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') d1, p_code "
					+ " FROM sh_goods "
					+ " WHERE goods_name LIKE 's%'";
			
			
			rs = stmt.executeQuery(query);
			
			
			while(rs.next()) {
				String g_idx = rs.getString(1);
				String goods_name = rs.getString(2);
				String goods_price = rs.getString("p1");
				String regidate = rs.getString("d1").substring(0, 10);
				String p_code = rs.getString(5);
				
				System.out.printf("%s %s %s %s %s\n", g_idx, goods_name, 
						goods_price, regidate, p_code);
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		SelectShop selectShop = new SelectShop();
		selectShop.execute();
	}

}
