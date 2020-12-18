package dao;

public class TransException extends Exception {
	public String getMessage(){
		return "이체시 오류가 발생하였습니다";
	}
}
