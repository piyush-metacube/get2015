package Controller;

import java.io.IOException;
import java.util.Collection;

import Helper.EmployeeModelHelper;
import Helper.GenericTextHelper;
import Helper.PageEnum;
import Model.Employee;

@WebServlet("/ListController")
public class ListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Collection<Employee> EmployeeList = EmployeeModelHelper.getAllEmployees();// getting list of all employees
	request.setAttribute("employeeList", EmployeeList);// setting list in request
	request.setAttribute("list", new GenericTextHelper().selector(PageEnum.EmployeeListPage));// getting list of content and setting in request
	RequestDispatcher rd = request.getRequestDispatcher(PageEnum.EmployeeListPage.getUrl());
	rd.forward(request, response);

    }

}
