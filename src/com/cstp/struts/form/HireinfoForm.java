/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.cstp.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.cstp.table.Users;

/** 
 * XDoclet definition:
 * @struts.form name="hireinfoForm"
 */
public class HireinfoForm extends ActionForm {
	
	private Integer id;
	private Users users;
	private String title;
	private Integer county;
	private Integer street;
	private Float salary;
	private Float minsalary;
	private Float maxsalary;
	private Integer roomCount;
	private Integer hallCount;
	private Integer type;
	private String telephone;
	private String linkman;
	private String houseInfo;
	private String createTime;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCounty() {
		return county;
	}

	public void setCounty(Integer county) {
		this.county = county;
	}

	public Integer getStreet() {
		return street;
	}

	public void setStreet(Integer street) {
		this.street = street;
	}

	public Float getSalary() {
		return salary;
	}

	public Float getMinsalary() {
		return minsalary;
	}

	public void setMinsalary(Float minsalary) {
		this.minsalary = minsalary;
	}

	public Float getMaxsalary() {
		return maxsalary;
	}

	public void setMaxsalary(Float maxsalary) {
		this.maxsalary = maxsalary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Integer getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}

	public Integer getHallCount() {
		return hallCount;
	}

	public void setHallCount(Integer hallCount) {
		this.hallCount = hallCount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(String houseInfo) {
		this.houseInfo = houseInfo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
}