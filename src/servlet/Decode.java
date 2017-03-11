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
		System.out.println("k1=" + k);
//		Keys ks = new Keys();
//		k = ks.bytesToHexString(new BASE64Decoder().decodeBuffer(k));
		System.out.println("k=" + k);
//		k = new BASE64Decoder().decodeBuffer(k);
		HttpSession ses = request.getSession();
		RSAmodel rsa = (RSAmodel)ses.getAttribute("rsa");
		String res = "-1";
		if(rsa != null){
			rsa.setCiphertext(k);
			res = new RsaDao().decode(rsa);
			ses.removeAttribute("rsa");
		}
		System.out.println("dr=" + res);
		response.getWriter().print(res);
	}

}
