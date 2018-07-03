package com.medic.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.medic.dao.UserDao;
import com.medic.dao.UserDaoImpl;
import com.medic.pojo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * ��֤�û��������Ƿ���ȷ
 * @author ����
 *
 */
public class UserAction extends ActionSupport{
	private UserDao userDao = new UserDaoImpl();
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
 
	//��½��֤
	public String login() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String validateCode = request.getParameter("validateCode");
		String code = (String) ActionContext.getContext().getSession()
				.get("code");
		System.out.println("��¼��֤#########");
		String returnValue = "login";
		if (validateCode.equalsIgnoreCase(code)) {
			if (this.userDao.checkUserLogin(this.getUser().getUsername(), this
					.getUser().getPassword())) {
				returnValue = "success";
				ActionContext.getContext().getSession()
						.put("username", this.getUser().getUsername());
			} else {
				request.setAttribute("tip", "�û������������");

			}
		} else {
			request.setAttribute("tip", "��֤�����");
		}
		return returnValue;
	}

	//ע��
	public String regist() {
		System.out.println("ע����֤#########");
		System.out.println(this.user);
		this.userDao.addUser(this.user);
		return "success";
		
	}
}
