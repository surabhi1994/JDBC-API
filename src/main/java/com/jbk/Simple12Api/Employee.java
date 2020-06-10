package com.jbk.Simple12Api;

public class Employee {
	private int id;
	private String name;
	private String Phoneno;
	private String Departmentit;
	private  String Status;
	private String Createddtm;
	private String Createdby;
	private String Updateddtm;
	private String Updatedby;
	private int cid;
	public Employee(int id, String name, String phoneno, String departmentit, String status, String createddtm,
			String createdby, String updateddtm, String updatedby, int cid) {
		super();
		this.id = id;
		this.name = name;
		Phoneno = phoneno;
		Departmentit = departmentit;
		Status = status;
		Createddtm = createddtm;
		Createdby = createdby;
		Updateddtm = updateddtm;
		Updatedby = updatedby;
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return Phoneno;
	}
	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}
	public String getDepartmentit() {
		return Departmentit;
	}
	public void setDepartmentit(String departmentit) {
		Departmentit = departmentit;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getCreateddtm() {
		return Createddtm;
	}
	public void setCreateddtm(String createddtm) {
		Createddtm = createddtm;
	}
	public String getCreatedby() {
		return Createdby;
	}
	public void setCreatedby(String createdby) {
		Createdby = createdby;
	}
	public String getUpdateddtm() {
		return Updateddtm;
	}
	public void setUpdateddtm(String updateddtm) {
		Updateddtm = updateddtm;
	}
	public String getUpdatedby() {
		return Updatedby;
	}
	public void setUpdatedby(String updatedby) {
		Updatedby = updatedby;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	

}
