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

@WebServlet("/decode")
public class Decode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String k =request.getParameter("k");
		HttpSession ses = request.getSession();
		RSAmodel rsa = (RSAmodel)ses.getAttribute("rsa");
//		String res = "-1";
		if(rsa != null){
			rsa.setCiphertext(k);
			rsa = new RsaDao().decode(rsa);
			ses.removeAttribute("rsa");
		}
		response.getWriter().print(rsa.getCleartext());
	}

}
