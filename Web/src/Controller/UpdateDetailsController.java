package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import Helper.EmployeeModelHelper;
import Model.Employee;

@WebServlet("/UpdateDetailsController")
public class UpdateDetailsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter out = response.getWriter();
	Employee objEmployeeBean = new Employee();// 'setting values to update of employee
	objEmployeeBean.setEmployeeId(Integer.parseInt(request.getParameter("empid")));
	objEmployeeBean.setName(request.getParameter("empname"));
	objEmployeeBean.setEmail(request.getParameter("empemail"));
	objEmployeeBean.setAge(Double.parseDouble(request.getParameter("empage")));
	objEmployeeBean.setDateOfRegistration(new Date());
	out.println(request.getParameter("empid"));
	EmployeeModelHelper.updateEmployee(objEmployeeBean);// updating employee
	RequestDispatcher rd = request.getRequestDispatcher("/ListController");
	rd.forward(request, response);// forwarded to list page
    }
}
