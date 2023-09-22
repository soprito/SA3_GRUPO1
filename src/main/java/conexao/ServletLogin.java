package conexao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Usuario;

@WebServlet("/ServeletAuten")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletLogin() {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			Usuario user01 = new Usuario();
			user01.setUsuario(login);
			user01.setSenha(senha);
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg" , "Login e/ou Senha estão incorretos");
			redirecionar.forward(request, response);
		}
	}

}
