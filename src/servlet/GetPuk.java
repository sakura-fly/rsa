package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RsaDao;
import model.RSAmodel;
import th.Timeout;


@WebServlet("/getpuk")
public class GetPuk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RsaDao rd = new RsaDao();
		RSAmodel rsa = rd.init();
		HttpSession ss = request.getSession();
		ss.setAttribute("rsa", rsa);
		new Timeout().sessionTimeout(ss);
		System.out.println("puk={" + rsa.getPukStr() + "}\nprik={" + rsa.getPrikStr() + "}");
		response.getWriter().print(rsa.getPukStr());    
	}  
                                 
}
       