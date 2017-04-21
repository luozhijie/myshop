package lzj.entity;

public class RememberMe {
	private int uid;
	private String md5;
	private String ip;

	public RememberMe() {
		super();
	}

	public RememberMe(int uid, String md5, String ip) {
		super();
		this.uid = uid;
		this.md5 = md5;
		this.ip = ip;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "RemberMe [uid=" + uid + ", md5=" + md5 + ", ip=" + ip + "]";
	}
}
