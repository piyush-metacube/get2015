package com.vehicledekho.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicledekho.dao.CreateUserDao;
import com.vehicledekho.factories.UserFactory;
import com.vehicledekho.model.User;
import com.vehicledekho.utils.Logger;

/**
 * Servlet implementation class NewUserCreationServlet
 */
@WebServlet("/AddNewUserServlet")
public class AddNewUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewUserServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	String username = request.getParameter("usernametb");
	String password = request.getParameter("passwordtb");
	String fName = request.getParameter("fnametb");
	String lName = request.getParameter("lnametb");
	String phone = request.getParameter("phonenumbertb");
	String email = request.getParameter("emailtb");

	if (username != null && password != null && fName != null
		&& lName != null && phone != null && email != null) {

	    UserFactory userFactory = new UserFactory();
	    Logger.log("Creating new user");

	    User newUser = userFactory.makeUser(username, password, fName,
		    lName, phone, email);

	    Logger.log("UserName : " + username);
	    Logger.log("password : " + password);
	    Logger.log("fName : " + fName);
	    Logger.log("lName : " + lName);
	    Logger.log("phone : " + phone);
	    Logger.log("email : " + email);

	    if (newUser != null) {
		CreateUserDao createUserDao = new CreateUserDao();
		if (createUserDao.SaveUserToDatabase(newUser)) {

		    Logger.log(new java.util.Date().toString()
			    + "  User Added Successfully");
		    response.sendRedirect("Accounts/Dashboard.jsp");
		}
	    }

	}
    }
}
