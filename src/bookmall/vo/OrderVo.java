package bookmall.vo;

public class OrderVo {
	private int no;
	private String name;
	private String email;
	private int price;
	private String address;
	private int cusomorNo;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCusomorNo() {
		return cusomorNo;
	}
	public void setCusomorNo(int cusomorNo) {
		this.cusomorNo = cusomorNo;
	}
	
}
