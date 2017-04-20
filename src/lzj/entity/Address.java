package lzj.entity;

public class Address {
	private int adressId;// 地址ID
	private String adress;// 地址
	private String phoneNumber;// 联系电话
	private String sendName;// 联系姓名
	private int userId;// 用户ID

	public Address() {
		super();
	}

	public Address(int adressId, String adress, String phoneNumber, String sendName, int userId) {
		super();
		this.adressId = adressId;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.sendName = sendName;
		this.userId = userId;
	}

	public int getAdressId() {
		return adressId;
	}

	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Adress [adressId=" + adressId + ", adress=" + adress + ", phoneNumber=" + phoneNumber + ", sendName="
				+ sendName + ", userId=" + userId + "]";
	}

}
