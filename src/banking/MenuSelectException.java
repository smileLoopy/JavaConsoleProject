package banking;

public class MenuSelectException extends Exception {

		public MenuSelectException () {
			super("1~5 이외의 숫자는 입력할 수 없습니다.");
		}
}
