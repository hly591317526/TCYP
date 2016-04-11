package entity;

import java.io.Serializable;

public class Member implements Serializable {

	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String password;
	private Integer qq;
	// root 0 是游客， 1是管理员
	private String root;
	private String descr;
	public Member(String name, String phone, String email, String password,
			Integer qq, String root, String info) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.qq = qq;
		this.root = root;
		this.descr = info;
	}



	public Member(Integer id, String name, String phone, String email,
			String password, Integer qq, String root, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.qq = qq;
		this.root = root;
		this.descr = desc;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + ", qq=" + qq
				+ ", root=" + root + ", desc=" + descr + "]";
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String desc) {
		this.descr = desc;
	}

	public Member() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getQq() {
		return qq;
	}

	public void setQq(Integer qq) {
		this.qq = qq;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

}
