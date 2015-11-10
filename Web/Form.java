import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String errorMessage = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	    String name = request.getParameter("name").trim();
	    String password = request.getParameter("password").trim();
	    String cPassword = request.getParameter("cPassword").trim();
	    String email = request.getParameter("email").trim();
	    String phoneNumber = request.getParameter("pNumber").trim();
	    response.setContentType("text/html");

	    PrintWriter output = response.getWriter();
	    if (!verifyData(name, password, cPassword, email, phoneNumber)) {
		output.println(errorMessage);
	    } else {
		RequestDispatcher requestDispatcherObject = request.getRequestDispatcher("SecondServlet");
		requestDispatcherObject.forward(request, response);
	    }
	} catch (NullPointerException exception) {
	    response.sendRedirect("index.html");
	}
    }

    private boolean verifyData(String... data) {
	boolean returnValue = true;
	if (data[0].equals("") || data[1].equals("") || data[2].equals("") || data[3].equals("") || data[4].equals("")) {

	    errorMessage = "Form Field can't be empty!!";
	    returnValue = false;

	} else if (!data[1].equals(data[2])) {

	    errorMessage = "Password and Confirm password should be same!!";
	    returnValue = false;

	} else if (data[1].length() < 8) {

	    errorMessage = "Password length should be greater than 8";
	    returnValue = false;

	} else if (data[3].indexOf("@") < 0 || data[3].length() < 4 || (data[3].lastIndexOf(".") - data[3].indexOf("@") < 1)
		|| (data[3].length() - data[3].lastIndexOf(".")) < 1) {

	    errorMessage = "Invalid Email Address!!";
	    returnValue = false;

	} else if (data[4].length() > 12 || data[4].length() < 9) {

	    errorMessage = "Incorrect phone number";
	    returnValue = false;

	}
	return returnValue;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }

}
