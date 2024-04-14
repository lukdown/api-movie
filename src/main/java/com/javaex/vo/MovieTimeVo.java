package com.javaex.vo;

public class MovieTimeVo {

	private int s_no;
	private int m_no;
	private String s_date;
	
	public MovieTimeVo() {
		super();
	}
	public MovieTimeVo(int m_no, String s_date) {
		super();
		this.m_no = m_no;
		this.s_date = s_date;
	}
	public MovieTimeVo(int s_no, int m_no, String s_date) {
		super();
		this.s_no = s_no;
		this.m_no = m_no;
		this.s_date = s_date;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	@Override
	public String toString() {
		return "MovieTimeVo [s_no=" + s_no + ", m_no=" + m_no + ", s_date=" + s_date + "]";
	}
	
	
	

}