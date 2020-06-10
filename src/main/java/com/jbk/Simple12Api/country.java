package com.jbk.Simple12Api;

public class country {
 private int cid;
 private String cname;
 
 
 
public country(int cid, String cname) {
	super();
	this.cid = cid;
	this.cname = cname;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
 
}
