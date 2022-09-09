package br.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.vemprafam.pojo.Funcionario;

public class DaoFuncionario {

	Connection connection;
	String url="jdbc:hsqldb:hsql://localhost/";
	String user = "SA";
	String password = "";
	
	public DaoFuncionario() {
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserirFuncionario( Funcionario funcionario ) {
		try {
			String sql = "INSERT INTO FUNCIONARIOS VALUES(?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, funcionario.getRe());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setDate(3, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(4, funcionario.getSalario());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void excluirFuncionario(Funcionario funcionario ) {
		try {
			String sql = "DELETE FROM FUNCIONARIOS WHERE RE=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	public void atualizarFuncionario( Funcionario funcionario ) {
		
	}
	
	public List<Funcionario> getLista() {
		List<Funcionario> lista = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FUNCIONARIOS");
			while( rs.next() ) {
				int re = rs.getInt("re");
				String nome = rs.getString(2);
				Date dataAdmissao = rs.getDate(3);
				double salario = rs.getDouble("salario");
				lista.add(new Funcionario(re,nome,dataAdmissao,salario));
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static void main(String[] args) {
		DaoFuncionario dao = new DaoFuncionario();
		List<Funcionario> lista = dao.getLista();
		for( Funcionario f: lista ) {
			System.out.println(f);
		}
	}
}
