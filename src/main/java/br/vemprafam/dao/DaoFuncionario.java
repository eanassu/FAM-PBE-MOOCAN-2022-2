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
			throw new RuntimeException(e);
		}
	}
	
	public void inserirFuncionario( Funcionario funcionario ) {
		try {
			String sql = "INSERT INTO FUNCIONARIOS VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, funcionario.getRe());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setDate(3, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(4, funcionario.getSalario());
			pstmt.setString(5, funcionario.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
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
			throw new RuntimeException(e);
		}			
	}
	
	public void atualizarFuncionario( Funcionario funcionario ) {
		try {
			String sql = "UPDATE FUNCIONARIOS SET NOME=?,DATAADMISSAO=?,SALARIO=?,"
					+ "EMAIL=? WHERE RE=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setDate(2, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(3, funcionario.getSalario());
			pstmt.setString(4, funcionario.getEmail());
			pstmt.setInt(5, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}			
		
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
				String email = rs.getString(5);
				lista.add(new Funcionario(re,nome,dataAdmissao,salario,email));
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public Funcionario buscarPeloRe( int re ) {
		try {
			String sql = "SELECT * FROM FUNCIONARIOS WHERE RE=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, re);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				return new Funcionario(rs.getInt(1),
						rs.getString(2),rs.getDate(3),rs.getDouble(4),rs.getString(5));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}			
		
	}
	
	public static void main(String[] args) {
		DaoFuncionario dao = new DaoFuncionario();
		List<Funcionario> lista = dao.getLista();
		for( Funcionario f: lista ) {
			System.out.println(f);
		}
	}
}
