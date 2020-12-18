package domain;

public class ReceiverVO {
	private String recv_num;
	private String recv_customer;
	long amount;
	
	public String getrecv_num() {
		return recv_num;
	}
	public void setrecv_num(String recv_num) {
		this.recv_num = recv_num;
	}
	public String getrecv_customer() {
		return recv_customer;
	}
	public void setrecv_customer(String recv_customer) {
		this.recv_customer = recv_customer;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
	
}
