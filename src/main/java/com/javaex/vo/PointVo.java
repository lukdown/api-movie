package com.javaex.vo;

public class PointVo {

	private int user_no;
	private String user_hp;
	private String user_birth;
	private String user_name;
	private int user_point;
	
	private int f_r_no;
	private int f_p_no;
	
	private String f_name;
	private int f_price;
	
	private int f_count;
	
	private int m_r_no;
	private int m_p_no;
	
	private String m_name;
	private int m_price;
	
	private int m_count;
	
	public PointVo() {
		super();
	}

	
	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public int getF_count() {
		return f_count;
	}


	public void setF_count(int f_count) {
		this.f_count = f_count;
	}


	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_hp() {
		return user_hp;
	}

	public void setUser_hp(String user_hp) {
		this.user_hp = user_hp;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public int getUser_point() {
		return user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}

	public int getF_r_no() {
		return f_r_no;
	}

	public void setF_r_no(int f_r_no) {
		this.f_r_no = f_r_no;
	}

	public int getF_p_no() {
		return f_p_no;
	}

	public void setF_p_no(int f_p_no) {
		this.f_p_no = f_p_no;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public int getF_price() {
		return f_price;
	}

	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	
	

	public int getM_r_no() {
		return m_r_no;
	}


	public void setM_r_no(int m_r_no) {
		this.m_r_no = m_r_no;
	}


	public int getM_p_no() {
		return m_p_no;
	}


	public void setM_p_no(int m_p_no) {
		this.m_p_no = m_p_no;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public int getM_price() {
		return m_price;
	}


	public void setM_price(int m_price) {
		this.m_price = m_price;
	}


	public int getM_count() {
		return m_count;
	}


	public void setM_count(int m_count) {
		this.m_count = m_count;
	}


	@Override
	public String toString() {
		return "PointVo [user_no=" + user_no + ", user_hp=" + user_hp + ", user_birth=" + user_birth + ", user_name="
				+ user_name + ", user_point=" + user_point + ", f_r_no=" + f_r_no + ", f_p_no=" + f_p_no + ", f_name="
				+ f_name + ", f_price=" + f_price + ", f_count=" + f_count + ", m_r_no=" + m_r_no + ", m_p_no=" + m_p_no
				+ ", m_name=" + m_name + ", m_price=" + m_price + ", m_count=" + m_count + "]";
	}


	

}
