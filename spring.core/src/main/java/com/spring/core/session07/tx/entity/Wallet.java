package com.spring.core.session07.tx.entity;

public class Wallet {

	private Integer wid;
	private String wname;
	private Integer moeny;
	
    public Wallet() {
		
	}
	 
	public Wallet(String wname, Integer moeny) {
		
		this.wname = wname;
		this.moeny = moeny;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public Integer getMoeny() {
		return moeny;
	}

	public void setMoeny(Integer moeny) {
		this.moeny = moeny;
	}

	@Override
	public String toString() {
		return "Wallet [wid=" + wid + ", wname=" + wname + ", moeny=" + moeny + "]";
	}
	
	
	
}
