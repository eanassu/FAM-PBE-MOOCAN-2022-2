package br.vemprafam.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TesteMvc implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Executou a lógica");
		return "testemvc.jsp";
	}

}
