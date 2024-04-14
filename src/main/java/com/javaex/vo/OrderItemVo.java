package com.javaex.vo;

public class OrderItemVo {

	private int f_r_no;
	private int f_no;
	private int f_count;
	
	private int m_r_no;
	private int m_no;
	private int m_count;
	
	public OrderItemVo() {
		super();
	}

	public int getF_r_no() {
		return f_r_no;
	}

	public void setF_r_no(int f_r_no) {
		this.f_r_no = f_r_no;
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public int getF_count() {
		return f_count;
	}

	public void setF_count(int f_count) {
		this.f_count = f_count;
	}

	
	
	public int getM_r_no() {
		return m_r_no;
	}

	public void setM_r_no(int m_r_no) {
		this.m_r_no = m_r_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getM_count() {
		return m_count;
	}

	public void setM_count(int m_count) {
		this.m_count = m_count;
	}

	@Override
	public String toString() {
		return "OrderItemVo [f_r_no=" + f_r_no + ", f_no=" + f_no + ", f_count=" + f_count + ", m_r_no=" + m_r_no
				+ ", m_no=" + m_no + ", m_count=" + m_count + "]";
	}

	

	

	
}