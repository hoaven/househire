/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.cstp.struts.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cstp.bean.Address;
import com.cstp.bean.DateDiff;
import com.cstp.bean.Salary;
import com.cstp.dao.UserDao;
import com.cstp.struts.form.HireinfoForm;
import com.cstp.table.Hireinfo;
import com.cstp.table.Users;

/** 
 * XDoclet definition:
 * @struts.action path="/hireinfo" name="hireinfoForm" parameter="status" scope="request" validate="true"
 */
public class HireinfoAction extends DispatchAction {
	
	UserDao dao = new UserDao();
	
	public ActionForward searchHireinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HireinfoForm hireinfoForm = (HireinfoForm) form;
		Hireinfo hireinfo = new Hireinfo();
		hireinfo.setCounty(hireinfoForm.getCounty());
		hireinfo.setStreet(hireinfoForm.getStreet());
		hireinfo.setRoomCount(hireinfoForm.getRoomCount());
		hireinfo.setHallCount(hireinfoForm.getHallCount());
		hireinfo.setType(hireinfoForm.getType());
		hireinfo.setCreateTime(hireinfoForm.getCreateTime());
		Salary sal = new Salary();
		sal.setMinsalary(hireinfoForm.getMinsalary());
		sal.setMaxsalary(hireinfoForm.getMaxsalary());
		DateDiff datediff = new DateDiff();
		hireinfo.setCreateTime(datediff.getPostTime(hireinfoForm.getCreateTime()));
		List hireinfolist = dao.searchHireinfo(hireinfo, sal);
		request.setAttribute("hireinfolist", hireinfolist);
		return mapping.findForward("list");
	}
	
	public ActionForward myHireinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Users user = (Users)request.getSession().getAttribute("user");
		List mylist = dao.findMyHireinfo(user);
		request.setAttribute("mylist", mylist);
		return mapping.findForward("my");
	}
	
	public ActionForward deleteHireinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Hireinfo hireinfo = (Hireinfo)dao.findById(id, Hireinfo.class);
		dao.delete(hireinfo);
		return mapping.findForward("hireinfo");
	}
	
	public ActionForward findHireinfoById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		int flag = Integer.parseInt(request.getParameter("flag"));
		Hireinfo hireinfo = (Hireinfo)dao.findById(id, Hireinfo.class);
		request.setAttribute("hireinfo", hireinfo);
		Address address = new Address();
		String county = address.getCounty(hireinfo.getCounty());
		String street = address.getStreet(hireinfo.getCounty(), hireinfo.getStreet());
		address.setCounty(county);
		address.setStreet(street);
		address.setI(hireinfo.getCounty());
		address.setJ(hireinfo.getStreet());
		request.setAttribute("address", address);
		if(flag == 0){
			return mapping.findForward("detail");
		}
		return mapping.findForward("update");
	}
	
	public ActionForward updateHireinfoById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		HireinfoForm hireinfoForm = (HireinfoForm) form;
		Hireinfo hireinfo = (Hireinfo)dao.findById(id, Hireinfo.class);
		hireinfo.setTitle(hireinfoForm.getTitle());
		hireinfo.setTelephone(hireinfoForm.getTelephone());
		hireinfo.setLinkman(hireinfoForm.getLinkman());
		hireinfo.setType(hireinfoForm.getType());
		hireinfo.setRoomCount(hireinfoForm.getRoomCount());
		hireinfo.setHallCount(hireinfoForm.getRoomCount());
		hireinfo.setSalary(hireinfoForm.getSalary());
		hireinfo.setCounty(hireinfoForm.getCounty());
		hireinfo.setStreet(hireinfoForm.getStreet());
		hireinfo.setHouseInfo(hireinfoForm.getHouseInfo());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = sdf.format(Calendar.getInstance().getTime());
		hireinfo.setCreateTime(createTime);
		dao.update(hireinfo);
		return mapping.findForward("hireinfo");
	}
	
	public ActionForward saveHireinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HireinfoForm hireinfoForm = (HireinfoForm) form;
		Users user = (Users)request.getSession().getAttribute("user");
		Hireinfo hireinfo = new Hireinfo();
		hireinfo.setUsers(user);
		hireinfo.setTitle(hireinfoForm.getTitle());
		hireinfo.setTelephone(hireinfoForm.getTelephone());
		hireinfo.setLinkman(hireinfoForm.getLinkman());
		hireinfo.setType(hireinfoForm.getType());
		hireinfo.setRoomCount(hireinfoForm.getRoomCount());
		hireinfo.setHallCount(hireinfoForm.getRoomCount());
		hireinfo.setSalary(hireinfoForm.getSalary());
		hireinfo.setCounty(hireinfoForm.getCounty());
		hireinfo.setStreet(hireinfoForm.getStreet());
		hireinfo.setHouseInfo(hireinfoForm.getHouseInfo());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = sdf.format(Calendar.getInstance().getTime());
		hireinfo.setCreateTime(createTime);
		request.getSession().setAttribute("hireinfo", hireinfo);
		Address address = new Address();
		address.setCounty(address.getCounty(hireinfoForm.getCounty()));
		address.setStreet(address.getStreet(hireinfoForm.getCounty(), hireinfoForm.getStreet()));
		request.setAttribute("address", address);
//		dao.save(hireinfo);
		return mapping.findForward("postconfirm");
	}
	
	public ActionForward confirm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Hireinfo hireinfo = (Hireinfo)request.getSession().getAttribute("hireinfo");
		dao.save(hireinfo);
		request.getSession().removeAttribute("hireinfo");
		return mapping.findForward("hireinfo");
	}
}