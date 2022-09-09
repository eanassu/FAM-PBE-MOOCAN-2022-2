package br.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoFuncionario;
import br.vemprafam.pojo.Funcionario;

/**
 * Servlet implementation class ServletLista
 */
@WebServlet("/ServletLista")
public class ServletLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DaoFuncionario dao = new DaoFuncionario();
		List<Funcionario> lista = dao.getLista();
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset='ISO-8859-1'>\r\n"
				+ "<title>Exemplo de tabela</title>\r\n"
				+ "</head>\r\n"
				+ "<body>"
				+ "<table border='1'>"
				+ "<tr>\r\n"
				+ "<th>RE</th><th>nome</th><th>data adm.</th><th>salário</th>\r\n"
				+ "</tr>");
		
		for( Funcionario f:lista ) {
			out.println("<tr>\r\n"
					+ "<td>"+ f.getRe() + "</td>"
					+ "<td>"+ f.getNome() +"</td>"
					+ "<td>"+ f.getDataAdmissao() +"</td>"
					+ "<td>"+ f.getSalario() + "</td>\r\n"
					+ "</tr>");
		}
		out.println("</table>\r\n"
				+ "<br/><a href='/Projeto'>voltar</a>"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
