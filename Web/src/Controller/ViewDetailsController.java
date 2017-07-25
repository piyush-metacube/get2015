package Controller;

import java.io.IOException;

import Helper.EmployeeModelHelper;
import Helper.GenericTextHelper;
import Helper.PageEnum;
import Model.Employee;

@WebServlet("/ViewDetailsController")
public class ViewDetailsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setAttribute("list", new GenericTextHelper().selector(PageEnum.EmployeeDetailsPage));// getting list of content and setting in request
	Employee employee = EmployeeModelHelper.getEmployeeForId(Integer.parseInt(request.getParameter("id"))); // getting id for that employee whose detail to display
	request.setAttribute("employeeDetails", employee);// setting employye to request
	RequestDispatcher rd = request.getRequestDispatcher(PageEnum.EmployeeDetailsPage.getUrl());
	rd.forward(request, response);// forwarded to employee Detail page
    }
}
